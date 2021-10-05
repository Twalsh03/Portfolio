package treasures;

import core.HasName;

import java.util.Arrays;

/**
 * A FancyTrove is a Trove that has a name. Much of the value of a FancyTrove
 * comes from its name (it is presumably a famous treasure box). Thus, the
 * value of a FancyTrove is the sum of the values of the component Treasures
 * plus a specific factor (currently 100) multiplied by the number of
 * characters of the FancyTrove's name.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class FancyTrove extends Trove implements HasName {
    /**
     *  Name of fancy Trove
     */
    private final String name;

    /**
     *  Array of Treasures contained in the FancyTrove
     */
    private final Treasure[] contents;

    /**
     *  Total Value of the FancyTrove
     */
    private final long fancyValue;



    /** Internal constant used for determining the value of a FancyTrove. */
    private static final long VALUE_FACTOR = 100L;

    /**
     * Constructs a new Trove with the Treasure objects specified by
     * contents.
     *
     * @param contents
     *            The Treasures to store in this FancyTrove. Must not be null
     *            nor contain null. The caller of the constructor is allowed
     *            to make changes to the parameter array after the constructor
     *            call, and this FancyTrove object (and its internal
     *            representation) will not be affected by this.
     * @param name
     *            The name of the FancyTrove. Must not be null.
     */
    public FancyTrove(Treasure[] contents, String name) {
        super(contents);
        this.contents = new Treasure[contents.length];
        fancyValue = getValue() +(name.length() * VALUE_FACTOR);
        this.name = name;
    }

    @Override
    public long getValue() {

        return fancyValue;
    }

    @Override
    public String getName() {
        return name;

    }

    @Override
    public String toString(){
            return "FancyTrove"+"("+fancyValue+") of "+Arrays.toString(contents) +" "+ "named "+name;
        }
}
