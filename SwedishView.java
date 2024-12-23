package view;

import java.io.IOException;
import model.Card;

/**
 * SwedishView provides a Swedish implementation of the View interface,
 * handling all player interactions and displaying game messages in Swedish.
 */
public class SwedishView implements View {

  @Override
  public void displayWelcomeMessage() {
    System.out.println("Hej Black Jack Världen");
    System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
  }

  @Override
  public Command getInput() {
    try {
      System.out.print("Ange kommando (p = spela, h = nytt kort, s = stanna, q = avsluta): ");
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
      System.out.println("Fel vid inläsning av indata: " + e.getMessage());
      return Command.INVALID;
    }
  }

  @Override
  public void displayCard(Card card) {
    System.out.println(card.getValue() + " av " + card.getColor());
  }

  @Override
  public void displayDealerHand(Iterable<Card> hand, int score) {
    System.out.println("Croupiern har:");
    for (Card card : hand) {
      displayCard(card);
    }
    System.out.println("Poäng: " + score + "\n");
  }

  @Override
  public void displayPlayerHand(Iterable<Card> hand, int score) {
    System.out.println("Spelaren har:");
    for (Card card : hand) {
      displayCard(card);
    }
    System.out.println("Poäng: " + score + "\n");
  }

  @Override
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut på spelet:");
    if (dealerIsWinner) {
      System.out.println("Croupiern vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  @Override
  public void displayErrorMessage(String message) {
    System.out.println("Fel: " + message);
  }

  @Override
  public void displayPrompt(String prompt) {
    System.out.println(prompt);
  }

  @Override
  public void displaySummary(int playerWins, int dealerWins) {
    System.out.println("\nSpelsammanfattning:");
    System.out.println("Spelarens vinster: " + playerWins);
    System.out.println("Croupierens vinster: " + dealerWins);
    System.out.println("Tack för att du spelade!");
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
    System.out.println("En ny kort har delats ut, uppdaterar spelet...");
  }

  @Override
  public void cardDealt() {
    update();
  }

  @Override
  public void gameOver() {
    displayGameOver(true);
  }

  @Override
  public void handleInvalidCommand(Command command) {
    if (command == Command.PLAY) {
      displayErrorMessage("Kan inte starta ett nytt spel medan du spelar. Använd 'h', 's' eller 'q'.");
    } else if (command == Command.INVALID) {
      displayErrorMessage("Ogiltigt kommando. Vänligen använd 'h', 's' eller 'q'.");
    } else {
      displayErrorMessage("Okänt kommando.");
    }
  }

  
  @Override
  public boolean promptForReplay() {
    displayPrompt("Tryck 'p' för att spela igen eller 'q' för att avsluta.");
    Command postGameCommand = getInput();
    return postGameCommand == Command.PLAY;
  }

}
