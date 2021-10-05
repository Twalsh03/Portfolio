import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Outline {


  static Predicate<String> pred = (s1)  -> {
    if (s1.contains("e"))
      return true;
    else
      return false;
  };


  public static void main(String... args) { // varargs alternative to String[]

    //1.
    List<String> wsa = new ArrayList<String>();
    wsa.add("One");
    wsa.add("Two");
    wsa.add("Three");
    wsa.add("Four");
    wsa.add("Five");

    System.out.println("List to be sorted: "+ wsa);
    System.out.println("\n");
    //sort array using just lambdas ( By length )
    wsa.sort((o1, o2) -> o1.length() - o2.length());
    System.out.println( "Sorted by length: "+ wsa);

    //sort array using just lambdas ( By reverse length )
    wsa.sort((o1, o2) -> o2.length() - o1.length());

    System.out.println( "Sorted by reverse length: "+ wsa);

    wsa.sort((o1, o2) -> o2.length() - o1.length());

    //sort array using just lambdas ( By First char )
    wsa.sort((o1, o2) -> o1.charAt(0) - o2.charAt(0));
    System.out.println( "Sorted by first char: "+ wsa);


    //sort array using just lambdas ( By - containing 'e')
    wsa.sort((o1, o2) -> {
      if (o1.contains("e"))
      return -1;
      else
        return 1;
      });
    System.out.println( "Sorted by containing 'e': "+ wsa);






    /*

    Sorted using Streams - Commented out

    String[] worksheetArray ={"One", "Two", "Three", "Four", "Five"};

    //Array sorting Comparator methods
    Comparator<String> byLength = (aName, bName) -> aName.length()- bName.length();
    Comparator<String> ReverseByLength = (aName, bName) ->  bName.length()- aName.length();
    Comparator<String> byFirstChar = (aName, bName) -> aName.charAt(0)- bName.charAt(0);
    Comparator<String> byContainsE = (aName, bName) ->   { if(aName.contains("e")){ return -1;
                                                          }
                                                          else return 1;
                                                          };

    System.out.println("sorted by Length:");

    //use Streams to sort ( using Comparator ) and print the array
    Arrays.stream(worksheetArray).sorted(byLength).forEach(System.out::println);
    System.out.println(" \n");

    System.out.println("sorted by Length in reverse:");
    Arrays.stream(worksheetArray).sorted(ReverseByLength).forEach(System.out::println);
    System.out.println("\n");
    System.out.println("sorted by first char:");
    Arrays.stream(worksheetArray).sorted(byFirstChar).forEach(System.out::println);
    System.out.println("\n");

    System.out.println("sorted by 'containingE':");
    Arrays.stream(worksheetArray).sorted(byContainsE).forEach(System.out::println);
    */





  }

}
