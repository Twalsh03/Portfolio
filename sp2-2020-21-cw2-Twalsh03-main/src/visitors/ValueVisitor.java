package visitors;

import treasures.Treasure;

/**
 * Visitor keeping a running total of the values of all Treasure objects
 * passed to the visit method.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class ValueVisitor implements Visitor {

    /**
     * Contains the total Value of the Maze's Treasures.
     */
    long totalValue;


    public ValueVisitor() {

    }

    @Override
    public Treasure visit(Treasure t) {
        totalValue += t.getValue();
        return t;
    }

    /**
     * Returns the total value of all Treasure objects that have been arguments
     * to the visit method.
     *
     * @return the total value of all Treasure objects that have been arguments
     * to the visit method
     */
    public long getValue() {

        return totalValue;
    }
}
