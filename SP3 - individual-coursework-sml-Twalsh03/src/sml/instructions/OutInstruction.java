package sml.instructions;

import sml.Instruction;
import sml.Machine;

import java.lang.reflect.Field;


/**
 * This class represents the Out instruction from the language.
 *
 * @author Thomas Walsh
 */
public final class OutInstruction extends Instruction {
   private int register;
   private int value;

   public OutInstruction(String label, String op){
       super(label, op);
   }

   public OutInstruction(String lab,  int reg) {
       this(lab, "out");
       this.register = reg;

   }


    /**
     * Execute the instruction, probably modifying the registers.
     *
     */

    /**
     * Execute the instruction, probably modifying the registers.
     *
     * @param m the machine under which the instruction executes
     */
    @Override
    public void execute(Machine m) {

    }



    /**
     * String representation of the instruction
     *
     * @return representation of the operands and result
     */
    @Override
    public String toString() {

        return super.toString() + " of register " + register + " is " + value;
    }
}
