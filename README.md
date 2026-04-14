# Teste Prático - Java (Iniflex)

## Descrição

Este projeto foi desenvolvido como parte de um teste técnico com o objetivo de avaliar conhecimentos em Java.

A aplicação realiza a manipulação de uma lista de funcionários, executando operações como remoção, atualização salarial, agrupamento, ordenação e cálculos diversos.

---

## Tecnologias Utilizadas

* Java 17+
* API Stream
* LocalDate
* BigDecimal

---

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/teste-pratico-iniflex.git
```

2. Abra o projeto em uma IDE de sua preferência:

   * IntelliJ
   * Eclipse
   * VS Code

3. Execute a classe:

```
Principal.java
```

---

## Estrutura do Projeto

```
src/
├── Pessoa.java
├── Funcionario.java
└── Principal.java
```

---

## Funcionalidades Implementadas

* [x] Inserção de funcionários
* [x] Remoção do funcionário "João"
* [x] Impressão com formatação de data (dd/MM/yyyy)
* [x] Impressão com formatação de valores (padrão brasileiro)
* [x] Aplicação de aumento salarial de 10%
* [x] Agrupamento de funcionários por função
* [x] Exibição de funcionários por função
* [x] Filtro de aniversariantes (meses 10 e 12)
* [x] Identificação do funcionário mais velho
* [x] Ordenação alfabética
* [x] Cálculo do total de salários
* [x] Cálculo de salários mínimos por funcionário

---

## Exemplo de Saída

```
--- LISTA DE FUNCIONÁRIOS ---
Maria | 18/10/2000 | R$ 2.009,44 | Operador
Caio | 02/05/1961 | R$ 9.836,14 | Coordenador
...

--- FUNCIONÁRIO MAIS VELHO ---
Caio - 63 anos

--- TOTAL SALÁRIOS ---
R$ XX.XXX,XX
```

---

## Autor

Desenvolvido por **Geremias Garcia**
