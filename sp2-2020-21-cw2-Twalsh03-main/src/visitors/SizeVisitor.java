package visitors;
import treasures.Treasure;


/**
 * Counts how many times the visit method has been called. Useful for
 * determining the number of entries in a container data structure.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 *
 */
public class SizeVisitor implements Visitor {

    /**
     *  Contains the the amount of times visit has been called.
     */
    private int sizeTotal;

    public SizeVisitor(){
    }
    @Override
    public Treasure visit(Treasure t) {
        sizeTotal++;
        return t;
    }

    /**
     * Returns the size of the visited data structure according to the
     * number of times the visit method has been called.
     *
     * @return the size of the visited data structure according to the
     *  number of times the visit method has been called.
     */
    public int getSize() {
        return sizeTotal;
    }

}
