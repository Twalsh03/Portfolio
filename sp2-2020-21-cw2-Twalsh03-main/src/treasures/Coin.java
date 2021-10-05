package treasures;

import core.HasName;

/**
 * A Coin is a SimpleTreasure with a name for the specific coin.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class Coin extends SimpleTreasure implements HasName {
    /**
     *  Name of the Coin.
     */
    private final String name;


    /**
     * Constructs a new Coin with specified value and name.
     *
     * @param value
     *            The value of the Coin.
     * @param name
     *            The name of the Coin. Must not be null.
     */
    public Coin(long value, String name) {
        super(value);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Coin"+"("+getValue()+") named "+getName();
    }
}
