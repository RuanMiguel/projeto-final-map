package framework.game;

import framework.cards.Deck;
import framework.factory.DeckFactory;
import framework.player.Player;
import framework.strategy.DealStrategy;

import java.util.List;

/**
 * Define a estrutura básica de execução de um jogo de cartas.
 *
 * É o Abstract Template do padrão Template Method, controlando as etapas comuns
 * de uma partida, como criação do baralho, embaralhamento, distribuição das cartas
 * e finalização.
 *
 * As etapas específicas de cada jogo são implementadas pelas subclasses.
 */
public abstract class Game {
    protected Deck deck;
    protected List<Player> players;
    protected Rule rule;
    protected DeckFactory deckFactory;
    protected DealStrategy dealStrategy;

    /**
     * Cria um jogo com os jogadores, regras, fábrica de baralho
     * e estratégia de distribuição informados.
     *
     * @param players jogadores que participarão da partida
     * @param rule regras utilizadas pelo jogo
     * @param deckFactory fábrica responsável pela criação do baralho
     * @param dealStrategy estratégia responsável pela distribuição das cartas
     */
    public Game(List<Player> players, Rule rule, DeckFactory deckFactory, DealStrategy dealStrategy) {
        this.players = players;
        this.rule = rule;
        this.deckFactory = deckFactory;
        this.dealStrategy = dealStrategy;
    }

    /**
     * Inicia a execução do jogo.
     *
     * É o Template Method; executa as etapas de criação do baralho, embaralhamento,
     * distribuição das cartas, execução das rodadas e finalização.
     */
    public void start() {
        createDeck();
        shuffle();
        dealCards();
        rounds();
        finish();
    }

    /**
     * Cria o baralho utilizando a fábrica configurada para o jogo.
     */
    protected void createDeck() {
        deck = deckFactory.createDeck();
    }

    /**
     * Embaralha o baralho atual.
     */
    protected void shuffle() {
        deck.shuffle();
    }

    /**
     * Distribui as cartas aos jogadores utilizando a estratégia
     * de distribuição configurada.
     */
    protected void dealCards() {
        dealStrategy.deal(deck, players);
    }

    /**
     * Retorna os jogadores da partida.
     *
     * @return lista de jogadores
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Retorna as regras utilizadas pela partida.
     *
     * @return regras do jogo
     */
    public Rule getRule() {
        return rule;
    }

    /**
     * Executa as rodadas específicas do jogo.
     *
     * A implementação deve ser fornecida pela subclasse.
     */
    protected abstract void rounds();

    /**
     * Finaliza a partida e apresenta ou processa o resultado do jogo.
     *
     * A implementação deve ser fornecida pela subclasse.
     */
    protected abstract void finish();
}