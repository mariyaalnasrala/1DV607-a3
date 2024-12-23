package view;

import model.Card;
import model.GameObserver;

/**
 * The View interface represents the required functionalities for different
 * views in the game. This interface defines methods for displaying the game state,
 * handling user input, and updating the game display.
 */
public interface View extends GameObserver {

  /**
   * Displays a welcome message to the player.
   */
  void displayWelcomeMessage();

  /**
   * Gets the command input from the user.
   *
   * @return The command entered by the user.
   */
  Command getInput();

  /**
   * Displays a single card.
   *
   * @param card The card to display.
   */
  void displayCard(Card card);

  /**
   * Displays the dealer's hand and its score.
   *
   * @param hand  The dealer's hand of cards.
   * @param score The score of the dealer's hand.
   */
  void displayDealerHand(Iterable<Card> hand, int score);

  /**
   * Displays the player's hand and its score.
   *
   * @param hand  The player's hand of cards.
   * @param score The score of the player's hand.
   */
  void displayPlayerHand(Iterable<Card> hand, int score);

  /**
   * Displays the result of the game.
   *
   * @param dealerIsWinner True if the dealer is the winner, false otherwise.
   */
  void displayGameOver(boolean dealerIsWinner);

  /**
   * Displays an error message to the player.
   *
   * @param message The error message to display.
   */
  void displayErrorMessage(String message);

  /**
   * Displays a prompt to the player.
   *
   * @param prompt The prompt message to display.
   */
  void displayPrompt(String prompt);

  /**
   * Displays a summary of the game statistics.
   *
   * @param playerWins The number of times the player has won.
   * @param dealerWins The number of times the dealer has won.
   */
  void displaySummary(int playerWins, int dealerWins);

  /**
   * Pauses briefly to make the game more exciting.
   */
  void pause();

  /**
   * Updates the view when notified by an observable, typically indicating a
   * change in the game state such as a new card being dealt.
   */
  @Override
  void update();

  /**
   * handle invalid command received.
   */
  void handleInvalidCommand(Command command);

  /**
   * Prompts the player to either replay the game or quit.
   * return true if the player wants to replay, false if they want to quit.
   */
  boolean promptForReplay();
}

