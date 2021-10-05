package sml.instructions;

import sml.Instruction;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstructionFactory {

    public InstructionFactory(){
    }


    public Instruction getInstance(String label,int r ,int s1, int s2) throws NoSuchMethodException, IllegalAccessException,
                                                                                InvocationTargetException, InstantiationException {

        Constructor<?> InstructionConstructor = null;

        if (label.equals("add")) {
            InstructionConstructor = AddInstruction.class.getConstructor(String.class, int.class, int.class, int.class);

        }else if (label.equals("sub")){
            InstructionConstructor = SubInstruction.class.getConstructor(String.class, int.class, int.class, int.class);

        }else if(label.equals("div")){

            InstructionConstructor = DivInstruction.class.getConstructor(String.class, int.class, int.class, int.class);

        }else if(label.equals("mul")) {
            InstructionConstructor = MulInstruction.class.getConstructor(String.class, int.class, int.class, int.class);
        }
        if(label.equals("lin")) {
            InstructionConstructor = LinInstruction.class.getConstructor(String.class, int.class, int.class);
            return (Instruction) InstructionConstructor.newInstance(label, r, s1);

        }else if(label.equals("out")) {
            return new OutInstruction(label, r);
        }
            return (Instruction) InstructionConstructor.newInstance(label, r, s1,s2);




    }

}
