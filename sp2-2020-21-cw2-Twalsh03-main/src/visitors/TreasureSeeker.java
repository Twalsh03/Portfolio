package visitors;
import core.HasName;
import treasures.MysteriousNote;
import treasures.Treasure;

import java.util.ArrayList;

/**
 * A TreasureSeeker is an adventurous person with a name who collects treasures
 * of positive value as long as a specified desired value has not been reached.
 * Leaves a mysterious note whenever they take a treasure in a visit. Implemented
 * as a Visitor to ensure independence from the concrete data structure(s) in
 * which the Treasures can be found.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class TreasureSeeker implements Visitor, HasName {

    /**
     *  The name of the treasure seeker
     */
    private final String name;

    /**
     *  The desired value the treasure seeker is seeking.
     */
    private long desiredValue;


    /**
     *  Array of Treasures collected by the Treasure Seeker.
     */
    private final ArrayList<Treasure> collectedTreasures ;



    /**
     * Constructs a new TreasureSeeker object with specified name and
     * desiredValue.
     *
     * @param name         The name of the TreasureSeeker. Must not be null.
     * @param desiredValue The value that this TreasureSeeker currently still desires.
     */
    public TreasureSeeker(String name, long desiredValue) {
        this.name = name;
        this.desiredValue = desiredValue;
        collectedTreasures = new ArrayList<>();
    }

    @Override
    public boolean wantsMoreVisits() {
        return desiredValue >= 0;
    }

    @Override
    public Treasure visit(Treasure t) {

        /**
         * If the value of the treasure is higher than 0, remove the value of the
         * value of the treasure (t) from the desired value of the Treasure Seeker and
         * return a Mysterious Note with he treasure seekers name.
         */

        if (t.getValue() > 0) {
            Treasure note = new MysteriousNote(getName());
            desiredValue -= t.getValue();
            collectedTreasures.add(t);
            return note;
        } else {
            wantsMoreVisits();
        }

        return t;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the value that this TreasureSeeker currently desires.
     *
     * @return the value that this TreasureSeeker currently desires
     */
    public long getDesiredValue() {
        return desiredValue;
    }

    @Override
    public String toString() {
        return "Treasure Seeker "+name+" has "+collectedTreasures +" and currently seeks a value of " + desiredValue;
    }
}