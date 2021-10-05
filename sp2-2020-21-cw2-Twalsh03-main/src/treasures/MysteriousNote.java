package treasures;

import core.HasName;

/**
 * A MysteriousNote is a Treasure that has zero value and is left by someone
 * with a name.
 *
 * @author Carsten Fuhs
 * @author Thomas Walsh
 */
public class MysteriousNote implements Treasure, HasName {
    /**
     * Name of MysteriousNote author
     */
    private final String name;

    /**
     *  The value of the MysteriousNote
     */
    private final long value;
    /**
     * Constructs a MysteriousNote written by an author with the specified
     * name.
     *
     * @param name
     *            The name of the author of the mysterious note.
     *            Must not be null.
     */
    public MysteriousNote(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Illegal null argument: content");
        }
        this.name = name;
        value = 0;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName()+ " was here!";
    }
}
