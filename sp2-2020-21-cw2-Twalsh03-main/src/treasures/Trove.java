package treasures;

import java.util.Arrays;


/**
 * A Trove is a Treasure that is composed of zero or more Treasures.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class Trove implements Treasure {
    /**
     *  Array of Treasures contained in the Trove.
     */
   private final Treasure[] contents;

    /**
     *  Total Value of the Trove.
     */
   private long troveTotal;


    /**
     * Constructs a new Trove with the Treasure objects specified by
     * contents.
     *
     * @param contents
     *            The Treasures to store in this Trove. Must not be null
     *            nor contain null. The caller of the constructor is allowed
     *            to make changes to the parameter array after the constructor
     *            call, and this Trove object (and its internal representation)
     *            will not be affected by this.
     */
    public Trove(Treasure[] contents) {

        if (contents == null) {
            throw new IllegalArgumentException("Illegal null argument: content");
        }
        this.contents = new Treasure[contents.length];
        System.arraycopy(contents, 0, this.contents, 0, contents.length);

    }


    /**
     * Returns the sum of the values of the component Treasures.
     *
     * @return the sum of the values of the component Treasures
     */
    @Override
    public long getValue() {
        troveTotal = 0;
        for (Treasure content : contents) {
            troveTotal += content.getValue();
        }
        return  troveTotal;
    }

    @Override
    public String toString() {
        return "Trove"+"("+troveTotal+") of "+Arrays.toString(contents);

    }
}
