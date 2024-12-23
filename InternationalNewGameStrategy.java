package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;

/**
 * Implements the International version of the New Game strategy for Blackjack.
 * In this strategy, both the player and dealer receive cards initially, but
 * only the player receives two cards.
 */
class InternationalNewGameStrategy implements NewGameStrategy {

  /**
   * Starts a new game by dealing initial cards to both the player and the dealer.
   * The player receives two face-up cards, and the dealer receives one face-up
   * card.
   *
   * @param deck   The deck of cards to be used.
   * @param dealer The dealer involved in the game.
   * @param player The player involved in the game.
   * @return True when the initial cards are successfully dealt.
   */
  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    dealCard(deck, player, true); // Player's first card
    dealCard(deck, dealer, true); // Dealer's first card
    dealCard(deck, player, true); // Player's second card

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