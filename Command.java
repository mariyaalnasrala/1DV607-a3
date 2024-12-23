package view;

/**
 * Enum representing the possible commands a player can issue during the game.
 */
public enum Command {
  /**
   * Command to start a new game.
   */
  PLAY("Start a new game"),

  /**
   * Command to request another card (hit).
   */
  HIT("Request another card"),

  /**
   * Command to hold the current hand (stand).
   */
  STAND("Hold current hand"),

  /**
   * Command to quit the game.
   */
  QUIT("Quit the game"),

  /**
   * Represents an invalid input command.
   */
  INVALID("Invalid command");

  private final String description;

  /**
   * Constructor for Command with a description.
   *
   * @param description The user-friendly description of the command.
   */
  Command(String description) {
    this.description = description;
  }

  /**
   * Gets a user-friendly description of the command.
   *
   * @return The description of the command.
   */
  public String getDescription() {
    return description;
  }
}
