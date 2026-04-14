import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private static final DateTimeFormatter DATA_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final NumberFormat MOEDA_BR =
            NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    private static final BigDecimal AUMENTO = new BigDecimal("1.10");
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static void main(String[] args) {

        List<Funcionario> funcionarios = inserirFuncionarios();

        removerJoao(funcionarios);

        imprimirFuncionarios(funcionarios);

        aplicarAumento(funcionarios);

        Map<String, List<Funcionario>> agrupados = agruparPorFuncao(funcionarios);
        imprimirAgrupados(agrupados);

        imprimirAniversariantes(funcionarios);

        imprimirMaisVelho(funcionarios);

        imprimirOrdemAlfabetica(funcionarios);

        imprimirTotalSalarios(funcionarios);

        imprimirSalariosMinimos(funcionarios);
    }

    // 3.1
    private static List<Funcionario> inserirFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        return funcionarios;
    }

    // 3.2
    private static void removerJoao(List<Funcionario> funcionarios) {
        funcionarios.removeIf(f -> f.getNome().equals("João"));
    }

    // 3.3
    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\n--- LISTA DE FUNCIONÁRIOS ---");

        funcionarios.forEach(f ->
                System.out.println(
                        f.getNome() + " | " +
                        f.getDataNascimento().format(DATA_FORMATTER) + " | " +
                        MOEDA_BR.format(f.getSalario()) + " | " +
                        f.getFuncao()
                )
        );
    }

    // 3.4
    private static void aplicarAumento(List<Funcionario> funcionarios) {
        funcionarios.forEach(f ->
                f.setSalario(f.getSalario().multiply(AUMENTO))
        );
    }

    // 3.5
    private static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // 3.6
    private static void imprimirAgrupados(Map<String, List<Funcionario>> agrupados) {
        System.out.println("\n--- AGRUPADOS POR FUNÇÃO ---");

        agrupados.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });
    }

    // 3.8
    private static void imprimirAniversariantes(List<Funcionario> funcionarios) {
        System.out.println("\n--- ANIVERSARIANTES OUTUBRO E DEZEMBRO ---");

        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonth() == Month.OCTOBER ||
                             f.getDataNascimento().getMonth() == Month.DECEMBER)
                .forEach(f -> System.out.println(f.getNome()));
    }

    // 3.9
    private static void imprimirMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = Collections.min(funcionarios,
                Comparator.comparing(Funcionario::getDataNascimento));

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();

        System.out.println("\n--- FUNCIONÁRIO MAIS VELHO ---");
        System.out.println(maisVelho.getNome() + " - " + idade + " anos");
    }

    // 3.10
    private static void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("\n--- ORDEM ALFABÉTICA ---");

        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.println(f.getNome()));
    }

    // 3.11
    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n--- TOTAL SALÁRIOS ---");
        System.out.println(MOEDA_BR.format(total));
    }

    // 3.12
    private static void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        System.out.println("\n--- SALÁRIOS MÍNIMOS ---");

        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtd + " salários mínimos");
        });
    }
}