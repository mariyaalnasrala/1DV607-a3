package view;

import java.io.IOException;
import model.Card;

/**
 * EnglishView provides an English implementation of the View interface,
 * handling all player interactions and displaying game messages in English.
 */
public class EnglishView implements View {

  @Override
  public void displayWelcomeMessage() {
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  @Override
  public Command getInput() {
    try {
      System.out.print("Enter your command (p = play, h = hit, s = stand, q = quit): ");
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      switch (c) {
        case 'p':
          return Command.PLAY;
        case 'h':
          return Command.HIT;
        case 's':
          return Command.STAND;
        case 'q':
          return Command.QUIT;
        default:
          return Command.INVALID;
      }
    } catch (IOException e) {
      System.out.println("Error reading input: " + e.getMessage());
      return Command.INVALID;
    }
  }

  @Override
  public void displayCard(Card card) {
    System.out.println(card.getValue() + " of " + card.getColor());
  }

  @Override
  public void displayDealerHand(Iterable<Card> hand, int score) {
    System.out.println("Dealer has:");
    for (Card card : hand) {
      displayCard(card);
    }
    System.out.println("Score: " + score + "\n");
  }

  @Override
  public void displayPlayerHand(Iterable<Card> hand, int score) {
    System.out.println("Player has:");
    for (Card card : hand) {
      displayCard(card);
    }
    System.out.println("Score: " + score + "\n");
  }

  @Override
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Game Over:");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }
  }

  @Override
  public void displayErrorMessage(String message) {
    System.out.println("Error: " + message);
  }

  @Override
  public void displayPrompt(String prompt) {
    System.out.println(prompt);
  }

  @Override
  public void displaySummary(int playerWins, int dealerWins) {
    System.out.println("\nGame Summary:");
    System.out.println("Player Wins: " + playerWins);
    System.out.println("Dealer Wins: " + dealerWins);
    System.out.println("Thank you for playing!");
  }

  @Override
  public void pause() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public void update() {
    pause();
    System.out.println("A new card has been dealt, updating the game...");
  }

  /**
   * handle invaild command.
   */

  @Override
  public void handleInvalidCommand(Command command) {
    if (command == Command.PLAY) {
      displayErrorMessage("Cannot start a new game while playing. Use 'h', 's', or 'q'.");
    } else if (command == Command.INVALID) {
      displayErrorMessage("Invalid command. Please use 'h', 's', or 'q'.");
    } else {
      displayErrorMessage("Unknown command.");
    }
  }


  @Override
  public void cardDealt() {
    update();
  }

  @Override
  public void gameOver() {
    System.out.println("The game has ended.");
  }


  @Override
  public boolean promptForReplay() {
    displayPrompt("Press 'p' to play again or 'q' to quit.");
    Command postGameCommand = getInput();
    return postGameCommand == Command.PLAY;
  }
}
