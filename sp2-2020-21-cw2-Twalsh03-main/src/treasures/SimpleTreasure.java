package treasures;

/**
 * A SimpleTreasure is a Treasure with a fixed value.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class SimpleTreasure implements Treasure {

    /**
     * Value of current SimpleTreasure object
     */
    private final long value;

    /**
     * Constructs a new SimpleTreasure with the specified value.
     *
     * @param value
     *            The value to assign to the SimpleTreasure.
     */
    public SimpleTreasure(long value) {
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Simple Treasure"+ "("+value+")";
    }
}
