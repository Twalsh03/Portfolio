package reflection;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.Class;
import java.lang.reflect.Modifier;

/**
 * @author Thomas Walsh
 *This class is used to reflect on the implementaion of a java class using reflection
 */

public class reflection {

    public reflection() {}

    /**
     * @param reflectionArg  - this is the scanner input from introspcetion
     *
     * @throws ClassNotFoundException - if class deos not exists, thor exception
     */

    public static void reflectMeth(String  reflectionArg) throws ClassNotFoundException {

        //get class to reflect
        Class reflectedClass = Class.forName(reflectionArg);

        //get the class name, interfaces, methods of loaded class
        String className = reflectedClass.getName();
        Class<?>[] classInterfaces = reflectedClass.getInterfaces();
        Method[] classMethods = reflectedClass.getMethods();
        Constructor<?>[] classConstructor = reflectedClass.getConstructors();
        Field[] classFields = reflectedClass.getFields();



        //class name to be reflected
        System.out.println("Class name: " + className+"\n");

        //print constructors of class
        for (Constructor<?> constructor : classConstructor) {
            System.out.println("Class constructors: " + constructor.getName()+"\n");
        }


        //print class methods
        for (Method method : classMethods) {
            System.out.println("Class Method: " + method.getName());
            System.out.println(method.getName() + " has " + Modifier.toString(method.getModifiers()) + " modifiers" + "\n");
        }
        //print class interfaces
        for (Class<?> interfaces : classInterfaces) {
            System.out.println("Class interfaces: " + interfaces.getName()+"\n");
        }

        //print class fields
        for (Field fields : classFields) {
            System.out.println("Class fields: " + fields.getName()+"\n");
        }
    }
}

