package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Implements the American version of the New Game strategy for Blackjack.
 * In this strategy, both the player and dealer receive two cards initially,
 * with one of the dealer's cards dealt face down.
 */
class AmericanNewGameStrategy implements NewGameStrategy {

  /**
   * Starts a new game by dealing initial cards to both the player and the dealer.
   * The player receives two face-up cards, and the dealer receives one face-up
   * card and one face-down card.
   *
   * @param deck   The deck of cards to be used.
   * @param dealer The dealer involved in the game.
   * @param player The player involved in the game.
   * @return True when the initial cards are successfully dealt.
   */
  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    dealCard(deck, player, true);  // Första kortet till spelaren, öppet
    dealCard(deck, dealer, true);  // Första kortet till dealern, öppet
    dealCard(deck, player, true);  // Andra kortet till spelaren, öppet
    dealCard(deck, dealer, false); // Andra kortet till dealern, dolt

    return true;
  }

  /**
   * function to get card and show it.
   */
  private void dealCard(Deck deck, Player player, boolean isVisible) {
    Card.Mutable card = deck.getCard();
    card.show(isVisible);
    player.dealCard(card);
  }
}
