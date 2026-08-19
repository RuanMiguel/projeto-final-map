# Design e Implementação de uma Infraestrutura Reutilizável para Jogos de Cartas

## Sobre o projeto

Este projeto consiste no desenvolvimento de um mini framework orientado a objetos para jogos de cartas, acompanhado de uma aplicação cliente que utiliza a infraestrutura desenvolvida para implementar o jogo Blackjack.

O projeto foi desenvolvido como trabalho final da disciplina de Métodos Avançados de Programação, com foco na aplicação prática de conceitos de projeto arquitetural, padrões GoF, princípios GRASP e princípios SOLID.

A infraestrutura foi projetada para permitir a reutilização da maior parte do código em diferentes jogos de cartas, deixando como pontos de extensão os elementos específicos de cada jogo, como regras, formas de distribuição, estratégias e condições de vitória.

## Objetivos

O principal objetivo é construir uma infraestrutura reutilizável que possa servir de base para diferentes jogos de cartas, como:

- Blackjack
- Uno
- Truco
- Poker
- Super Trunfo
- Outros jogos que possam ser incorporados posteriormente

A solução busca possibilitar a criação de diferentes jogos sem a necessidade de modificar o núcleo do framework, favorecendo reutilização, extensibilidade, baixo acoplamento e alta coesão.

## Arquitetura

A solução é dividida em duas partes principais:

### Framework

Contém as abstrações e implementações reutilizáveis que formam a infraestrutura para jogos de cartas.

Entre os principais componentes estão:

`Card`
`BasicCard`
`CardDecorator`
`Deck`
`Hand`
`Player`
`Game`
`Rule`
`DeckFactory`
`DealStrategy`

### Aplicação cliente

A aplicação cliente utiliza o framework para implementar um jogo concreto.

Neste projeto, foi desenvolvido o Blackjack, contendo componentes específicos como:

`BlackjackGame`
`BlackjackRule`
`BlackJackDeckFactory`
`BlackjackDealStrategy`

### Estrutura geral
```
src/
├── framework/
│   ├── cards/
|   |   ├── Card.java
|   |   ├── BasicCard.java
|   |   ├── CardDecorator.java
|   |   ├── Deck.java
|   |   └── Hand.java
|   |
│   ├── factory/
|   |   └── DeckFactory.java
|   |
│   ├── game/
|   |   ├── Game.java
|   |   └── Rule.java
|   |
│   ├── player/
|   |   └── Player.java
|   |
│   └── strategy/
|       └── DealStrategy.java
│
└── blackJack/
    ├── BlackjackGame.java
    ├── BlackjackRule.java
    ├── BlackjackDealStrategy.java
    ├── BlackJackDeckFactory.java
    └── Main.java
```

## Integrantes

-   [Laryssa Dantas Ramos](https://github.com/laryssadrr)
-   [Letícia Barbosa M. da Cruz](https://github.com/daCruzZzLeticia)
-   [Marcella Viana da Silva Lins](https://github.com/MarcellaLins)
-   [Ruan Miguel da Silva Costa](https://github.com/RuanMiguel)
