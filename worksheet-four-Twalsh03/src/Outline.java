import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Software Programming 3 - Birkbeck
 * Worksheet 4
 *
 * @author  Thomas Walsh
 */
public class Outline {
  public static void main(String... args) { // varargs alternative to String[]

    //1.
    //Convert to Stream
    //filter MEAT dishes
    //limit to just 2 dishes
    Stream<Dish> meatStream = Dish.menu
            .stream()
            .filter(d -> d.getType() == Dish.Type.MEAT)
            .limit(2);
    //collect Elements of the Stream and print them
    //EXPECTED - [pork, beef]
    System.out.println("Output of Stream to just two MEAT dishes: ");
    System.out.println(meatStream.collect(Collectors.toList()));
    System.out.println("\n");

    //2.
    //map every object to int 1
    //reduce/fold every object to a single int (total objects)
    int countStream = Dish.menu
            .stream()
            .map(d -> 1)
            .reduce((a, b) -> a + b)
            .get();

    System.out.println("Output of counting elements within List using Streams: ");
    System.out.println(countStream);
    System.out.println("\n");

    //3.
    List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
    //square each number using map()
    //collect each element to list
    List<Integer> sqrtnum = num
            .stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
    System.out.println("Original List: "+   num);
    System.out.println("Output of Stream to Square each element within 'num' list: ");
    System.out.println(sqrtnum);
    System.out.println("\n");

    //4.
    /*
     * Use of Flatmap() to 'flatten' two arrays into a single array
     * within flatmap(), elements of pair1 List are passed into
     * a lamda where they are mapped into a new integer array
     * and paired with elements of pair2 List via a new Integer [].
     *
     * After each new pair is created, they are collected and placed into
     * 'PairedList'.
     *
     *  n  = elements of 'pair1'
     *  m = elements of 'pair2'
     */
    List<Integer> pair1 = Arrays.asList(1, 2, 3);
    List<Integer> pair2 = Arrays.asList(3, 4);

    List<Integer[]> pairedList = pair1
            .stream()
            .flatMap(n -> pair2
                    .stream()
                    .map(m -> new Integer[]{n, m}))
            .collect(Collectors.toList());

    //Print each pair within PairedList
    System.out.println("Result of using flatmap and Streams to pair two Arrays: ");
    pairedList.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    System.out.println("\n");

    //5.

     //Extending the above answer with an additional filter
     // to filter the pairs where the sum of both elements
     // are divisible by 3.

    List<Integer[]> PairedListDiv3 = pair1
            .stream()
            .flatMap(n -> pair2
                    .stream()
                    .map(m -> new Integer[]{n, m}))

            //as the stream now contains an Int[], sum the elements,
            //filter the pairs that are divisible by 3
            .filter(x -> (x[0] + x[1]) %3 ==0)
            .collect(Collectors.toList());

    System.out.println("Result filtering the previous array: ");
    PairedListDiv3.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

  }

}
