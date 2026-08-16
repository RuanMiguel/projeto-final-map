package blackJack;

import framework.player.Player;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Criar os jogadores da partida
        List<Player> players = new ArrayList<>();
        players.add(new Player("Jogador 1"));
        players.add(new Player("Dealer"));

        // 2. Instanciar os componentes específicos do Blackjack
        BlackjackRule rule = new BlackjackRule();
        BlackJackDeckFactory deckFactory = new BlackJackDeckFactory();
        BlackjackDealStrategy dealStrategy = new BlackjackDealStrategy();

        // 3. Criar a instância do jogo passando as dependências do framework
        BlackjackGame game = new BlackjackGame(players, rule, deckFactory, dealStrategy);

        // 4. Iniciar o fluxo completo gerenciado pelo Template Method do Game
        game.start();
    }
}