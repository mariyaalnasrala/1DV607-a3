package model;

/**
 * Represents an immutable common playing card that can be either visible or hidden (face down).
 */
public class Card {

  /**
   * Represents the four playing card colors, as well as a hidden color.
   */
  public enum Color {
    Hearts, Spades, Diamonds, Clubs, Count, Hidden
  }

  /**
   * Represents the 13 card values, as well as a hidden value.
   */
  public enum Value {
    Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Knight, Queen, King, Ace, Count, Hidden
  }

  /**
   * Represents a mutable playing card that can be shown or hidden.
   */
  public static class Mutable extends Card {
    /**
     * Initializing constructor that creates a mutable card, initially hidden.
     *
     * @param color The color of the card.
     * @param value The value of the card.
     */
    public Mutable(Color color, Value value) {
      super(color, value);
    }

    /**
     * Changes the visibility state of the card.
     *
     * @param show True if the card should be shown, false if it should be hidden.
     */
    public void show(boolean show) {
      isHidden = !show;
    }
  }

  private Color color;
  private Value value;
  protected boolean isHidden;

  /**
   * Initializing constructor that creates a hidden card.
   *
   * @param color The color of the card.
   * @param value The value of the card.
   */
  public Card(Color color, Value value) {
    this.value = value;
    this.color = color;
    isHidden = true;
  }

  /**
   * Returns the color of the card or hidden if the card is face down.
   *
   * @return The card color, or Hidden if the card is face down.
   */
  public Color getColor() {
    if (isHidden) {
      return Color.Hidden;
    }
    return color;
  }

  /**
   * Returns the value of the card or hidden if the card is face down.
   *
   * @return The card value, or Hidden if the card is face down.
   */
  public Value getValue() {
    if (isHidden) {
      return Value.Hidden;
    }
    return value;
  }
}