import java.util.Objects;

/**
 * Driver class for the ShoppingBasket class of Coursework Assignment 1
 * in the Software and Programming II module at BBK in 2020/21.
 *
 * @author Carsten Fuhs
 */
public class Coursework1Main {

    /* The following is a tiny "home-grown" testing framework.
     * We will see a more advanced framework, JUnit, later in the module.
     */

    /** Index value for the next test. */
    private static int testNo = 1;

    /** Number of passed tests. */
    private static int passes = 0;

    /** Number of failed tests. */
    private static int fails = 0;

    /** Output for successful test. */
    private static final String YEA = "OK    "; //"PASSED";

    /** Output for unsuccessful test. */
    private static final String NAY = "FAILED";

    /**
     * Acceptable distance from expected value for double values,
     * should be slightly above 0.
     */
    private static final double DELTA = 1e-9;

    /**
     * Tests two int values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testIntEqual(String description, int expected, int actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two long values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testLongEqual(String description, long expected, long actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two double values for equality (up to a small "delta").
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testDoubleEqual(String description, double expected, double actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected - DELTA <= actual && actual <= expected + DELTA);
        // small rounding errors are ok
    }

    /**
     * Tests two Objects for equality. Works for Object and all its subclasses
     * (String, Product, ...).
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testObjectEqual(String description, Object expected, Object actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            Objects.equals(expected, actual));
        // Objects.equals is graceful on null
    }

    /**
     * Helper method for the side effects of the tests for different data types
     * (here already converted to Strings): screen output and increment of
     * static counter variables.
     *
     * @param description  description of the test to be printed
     * @param expected  String representation of the expected value
     * @param actual  String representation of the actual value
     * @param result  true: test has passed; false: test has failed
     */
    private static void sideEffectsForTest(String description, String expected, String actual, boolean result) {
        String output;
        if (result) {
            passes++;
            output = YEA;
        } else {
            fails++;
            output = NAY;
        }
        //System.out.println("Test " + testNo + ": " + description
        //    + ", expected: " + expected + ", actual: " + actual
        //    + " ===> " + output);
        System.out.println(output + " - Test " + testNo + ": " + description
            + ", expected: " + expected + ", actual: " + actual);
        testNo++;
    }

    /* The code to test our ShoppingBasket in particular starts here. */

    /**
     * Constants for use in the tests.
     */
    private static final Product PRODUCT1 = new Product("Pen", 750, 40);
    private static final Product PRODUCT2 = new Product("Stamp", 80, 2);
    private static final Product PRODUCT3 = new Product("Car", 2000000, 1500000);
    private static final Product PRODUCT4 = new Product("Soda", 200, 600);
    private static final Product PRODUCT5 = new Product("Towel", 800, 300);
    private static final Product PRODUCT6 = new Product("Lemonade", 200, 600);
    private static final Product PRODUCT7 = new Product("Soda", 200, 1100);
    private static final Product PRODUCT8 = new Product("Book", 990, 200);

    /* Methods to create suitably constructed and modified ShoppingBasket objects. */

    /**
     * @return an empty ShoppingBasket
     */
    private static ShoppingBasket makeEmptyShoppingBasket() {
        return new ShoppingBasket();
    }

    /**
     * @return a ShoppingBasket to which PRODUCT1 has been added
     */
    private static ShoppingBasket makeAddOneProductShoppingBasket() {
        ShoppingBasket k = makeEmptyShoppingBasket();
        k.add(PRODUCT1);
        return k;
    }

    /**
     * @return a ShoppingBasket to which PRODUCT8 has been added twice
     */
    private static ShoppingBasket makeAddTwoProductSameShoppingBasket() {
        ShoppingBasket k = makeEmptyShoppingBasket();
        k.add(PRODUCT8);
        k.add(PRODUCT8);
        return k;
    }

    /**
     * @return a ShoppingBasket to which PRODUCT8, null, PRODUCT8 have been added
     */
    private static ShoppingBasket makeAddTwoProductSameAndNullShoppingBasket() {
        ShoppingBasket k = makeEmptyShoppingBasket();
        k.add(PRODUCT8);
        k.add(null);
        k.add(PRODUCT8);
        return k;
    }

    /**
     * @return a ShoppingBasket to which PRODUCT1, null, PRODUCT2 have been added
     */
    private static ShoppingBasket makeAddTwoProductAndNullShoppingBasket() {
        ShoppingBasket k = makeEmptyShoppingBasket();
        k.add(PRODUCT1);
        k.add(null);
        k.add(PRODUCT2);
        return k;
    }

    /**
     * @return a ShoppingBasket on which addAll was invoked with PRODUCT1, null, PRODUCT2
     */
    private static ShoppingBasket makeAddAllTwoProductAndNullShoppingBasket() {
        ShoppingBasket k = makeEmptyShoppingBasket();
        Product[] products = { PRODUCT1, null, PRODUCT2 };
        k.addAll(products);
        return k;
    }

    /**
     * @return a ShoppingBasket constructed with PRODUCT1, null, PRODUCT2 in the argument
     *  array
     */
    private static ShoppingBasket makeConstructorTwoProductAndNullShoppingBasket() {
        Product[] products = { PRODUCT1, null, PRODUCT2 };
        ShoppingBasket k = new ShoppingBasket(products);
        return k;
    }

    /**
     * @return a ShoppingBasket with both constructor arguments and a call to add()
     */
    private static ShoppingBasket makeConstructorAddTwoProductAndNullShoppingBasket() {
        Product[] products = { PRODUCT1, null };
        ShoppingBasket k = new ShoppingBasket(products);
        k.add(PRODUCT2);
        return k;
    }

    /**
     * @return a ShoppingBasket with one Product passed in the constructor where the
     *  array passed to the constructor is later modified (which should not
     *  affect the ShoppingBasket object)
     */
    private static ShoppingBasket makeConstructorOneProductArraySideEffectShoppingBasket() {
        Product[] products = { PRODUCT1 };
        ShoppingBasket k = new ShoppingBasket(products);
        products[0] = null; // the ShoppingBasket object should still contain PRODUCT1!
        return k;
    }

    /**
     * @return a ShoppingBasket on which the keepOnlyProductsWith() mutator has been
     *  called to remove some products
     */
    private static ShoppingBasket makeKeepShoppingBasket() {
        Product[] products = { PRODUCT3, null, PRODUCT4, PRODUCT5, PRODUCT6, PRODUCT7, PRODUCT8, null, null, PRODUCT8  };
        ShoppingBasket k = new ShoppingBasket(products);
        k.add(PRODUCT2);
        k.keepOnlyProductsWith(400);
        return k;
    }

    /**
     * @return an array with two ShoppingBaskets: the first one has PRODUCT1, PRODUCT2,
     *  and the second one has PRODUCT3
     */
    private static ShoppingBasket[] makeTwoShoppingBaskets() {
        return new ShoppingBasket[] { new ShoppingBasket(new Product[] { PRODUCT1, PRODUCT2 }),
                                      new ShoppingBasket(new Product[] { PRODUCT3 })};
    }

    /**
     * Main method that drives the tests.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        ShoppingBasket basket;
        basket = makeEmptyShoppingBasket();
        testObjectEqual("toString", "[]", basket.toString()); // 1
        basket = makeEmptyShoppingBasket();
        testObjectEqual("toShipment", null, basket.toShipment(100)); // 2
        basket = makeEmptyShoppingBasket();
        testIntEqual("numberOfProducts", 0, basket.numberOfProducts()); // 3
        basket = makeEmptyShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(120).numberOfProducts()); // 4
        basket = makeEmptyShoppingBasket();
        testLongEqual("totalPriceInPence", 0, basket.totalPriceInPence()); // 5
        basket = makeEmptyShoppingBasket();
        testDoubleEqual("averagePriceInPence", -1.0, basket.averagePriceInPence()); // 6

        basket = makeAddOneProductShoppingBasket();
        testObjectEqual("toString", "[" + PRODUCT1 + "]", basket.toString()); // 7
        basket = makeAddOneProductShoppingBasket();
        testObjectEqual("toShipment", PRODUCT1, basket.toShipment(100).getFlattenedContents()[0]); // 8
        basket = makeAddOneProductShoppingBasket();
        testIntEqual("numberOfProducts", 1, basket.numberOfProducts()); // 9
        basket = makeAddOneProductShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(120).numberOfProducts()); // 10
        basket = makeAddOneProductShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(1000).numberOfProducts()); // 11
        basket = makeAddOneProductShoppingBasket();
        testLongEqual("totalPriceInPence", 750, basket.totalPriceInPence()); // 12
        basket = makeAddOneProductShoppingBasket();
        testDoubleEqual("averagePriceInPence", 750, basket.averagePriceInPence()); // 13

        basket = makeAddTwoProductSameShoppingBasket();
        testObjectEqual("toString", "[" + PRODUCT8 + ", " + PRODUCT8 + "]", basket.toString()); // 14
        basket = makeAddTwoProductSameShoppingBasket();
        testIntEqual("toShipment", 2, basket.toShipment(1000).numberOfProducts()); // 15
        basket = makeAddTwoProductSameShoppingBasket();
        testIntEqual("numberOfProducts", 2, basket.numberOfProducts()); // 16
        basket = makeAddTwoProductSameShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 2, basket.makeNewShoppingBasketWith(120).numberOfProducts()); // 17
        basket = makeAddTwoProductSameShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(13000).numberOfProducts()); // 18
        basket = makeAddTwoProductSameShoppingBasket();
        testLongEqual("totalPriceInPence", 1980, basket.totalPriceInPence()); // 19
        basket = makeAddTwoProductSameShoppingBasket();
        testDoubleEqual("averagePriceInPence", 990, basket.averagePriceInPence()); // 20

        basket = makeAddTwoProductSameAndNullShoppingBasket();
        testObjectEqual("toString", "[" + PRODUCT8 + ", " + PRODUCT8 + "]", basket.toString()); // 21

        basket = makeAddTwoProductAndNullShoppingBasket();
        testIntEqual("toShipment", 2, basket.toShipment(3000).numberOfProducts()); // 22
        basket = makeAddTwoProductAndNullShoppingBasket();
        testIntEqual("numberOfProducts", 2, basket.numberOfProducts()); // 23
        basket = makeAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 2, basket.makeNewShoppingBasketWith(20).numberOfProducts()); // 24
        basket = makeAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(100).numberOfProducts()); // 25
        basket = makeAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(750).numberOfProducts()); // 26
        basket = makeAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(3200).numberOfProducts()); // 27
        basket = makeAddTwoProductAndNullShoppingBasket();
        testLongEqual("totalPriceInPence", 830, basket.totalPriceInPence()); // 28
        basket = makeAddTwoProductAndNullShoppingBasket();
        testDoubleEqual("averagePriceInPence", 415, basket.averagePriceInPence()); // 29

        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testIntEqual("toShipment", 1, basket.toShipment(50).numberOfParcels()); // 30
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testIntEqual("numberOfProducts", 2, basket.numberOfProducts()); // 31
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 2, basket.makeNewShoppingBasketWith(20).numberOfProducts()); // 32
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(100).numberOfProducts()); // 33
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(750).numberOfProducts()); // 34
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(3200).numberOfProducts()); // 35
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testLongEqual("totalPriceInPence", 830, basket.totalPriceInPence()); // 36
        basket = makeAddAllTwoProductAndNullShoppingBasket();
        testDoubleEqual("averagePriceInPence", 415, basket.averagePriceInPence()); // 37

        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testIntEqual("toShipment", 2, basket.toShipment(40).numberOfParcels()); // 38
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testIntEqual("numberOfProducts", 2, basket.numberOfProducts()); // 39
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 2, basket.makeNewShoppingBasketWith(20).numberOfProducts()); // 40
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(100).numberOfProducts()); // 41
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(750).numberOfProducts()); // 42
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(3200).numberOfProducts()); // 43
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testLongEqual("totalPriceInPence", 830, basket.totalPriceInPence()); // 44
        basket = makeConstructorTwoProductAndNullShoppingBasket();
        testDoubleEqual("averagePriceInPence", 415, basket.averagePriceInPence()); // 45

        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("toShipment", 2, basket.toShipment(100).numberOfProducts()); // 46
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("numberOfProducts", 2, basket.numberOfProducts()); // 47
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 2, basket.makeNewShoppingBasketWith(20).numberOfProducts()); // 48
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(100).numberOfProducts()); // 49
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(750).numberOfProducts()); // 50
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(3200).numberOfProducts()); // 51
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testIntEqual("totalPriceInPence", 830, basket.totalPriceInPence()); // 52
        basket = makeConstructorAddTwoProductAndNullShoppingBasket();
        testDoubleEqual("averagePriceInPence", 415, basket.averagePriceInPence()); // 53

        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testObjectEqual("toString", "[" + PRODUCT1 + "]", basket.toString()); // 54
        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testObjectEqual("toShipment", null, basket.toShipment(1)); // 55
        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testIntEqual("numberOfProducts", 1, basket.numberOfProducts()); // 56
        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 1, basket.makeNewShoppingBasketWith(120).numberOfProducts()); // 57
        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 0, basket.makeNewShoppingBasketWith(1000).numberOfProducts()); // 58
        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testLongEqual("totalPriceInPence", 750, basket.totalPriceInPence()); // 59
        basket = makeConstructorOneProductArraySideEffectShoppingBasket();
        testDoubleEqual("averagePriceInPence", 750, basket.averagePriceInPence()); // 60


        basket = makeKeepShoppingBasket();
        testIntEqual("numberOfProducts", 4, basket.numberOfProducts()); // 61
        basket = makeKeepShoppingBasket();
        testIntEqual("makeNewShoppingBasketWith", 3, basket.makeNewShoppingBasketWith(940).numberOfProducts()); // 62
        basket = makeKeepShoppingBasket();
        testLongEqual("totalPriceInPence", 2002780, basket.totalPriceInPence()); // 63
        basket = makeKeepShoppingBasket();
        testDoubleEqual("averagePriceInPence", 500695, basket.averagePriceInPence()); // 64

        testObjectEqual("mostValuedShoppingBasket", null, ShoppingBasket.mostValuedShoppingBasket(new ShoppingBasket[0])); // 65

        ShoppingBasket[] stores = makeTwoShoppingBaskets();
        testIntEqual("mostValuedShoppingBasket", 2000000, ShoppingBasket.mostValuedShoppingBasket(stores).totalPriceInPence()); // 66

        System.out.println();
        System.out.println(YEA + ": " + passes);
        System.out.println(NAY + ": " + fails);
    }

    /*

OK     - Test 1: toString, expected: [], actual: []
OK     - Test 2: toShipment, expected: null, actual: null
OK     - Test 3: numberOfProducts, expected: 0, actual: 0
OK     - Test 4: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 5: totalPriceInPence, expected: 0, actual: 0
OK     - Test 6: averagePriceInPence, expected: -1.0, actual: -1.0
OK     - Test 7: toString, expected: [(Pen, 750p, 40g)], actual: [(Pen, 750p, 40g)]
OK     - Test 8: toShipment, expected: (Pen, 750p, 40g), actual: (Pen, 750p, 40g)
OK     - Test 9: numberOfProducts, expected: 1, actual: 1
OK     - Test 10: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 11: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 12: totalPriceInPence, expected: 750, actual: 750
OK     - Test 13: averagePriceInPence, expected: 750.0, actual: 750.0
OK     - Test 14: toString, expected: [(Book, 990p, 200g), (Book, 990p, 200g)], actual: [(Book, 990p, 200g), (Book, 990p, 200g)]
OK     - Test 15: toShipment, expected: 2, actual: 2
OK     - Test 16: numberOfProducts, expected: 2, actual: 2
OK     - Test 17: makeNewShoppingBasketWith, expected: 2, actual: 2
OK     - Test 18: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 19: totalPriceInPence, expected: 1980, actual: 1980
OK     - Test 20: averagePriceInPence, expected: 990.0, actual: 990.0
OK     - Test 21: toString, expected: [(Book, 990p, 200g), (Book, 990p, 200g)], actual: [(Book, 990p, 200g), (Book, 990p, 200g)]
OK     - Test 22: toShipment, expected: 2, actual: 2
OK     - Test 23: numberOfProducts, expected: 2, actual: 2
OK     - Test 24: makeNewShoppingBasketWith, expected: 2, actual: 2
OK     - Test 25: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 26: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 27: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 28: totalPriceInPence, expected: 830, actual: 830
OK     - Test 29: averagePriceInPence, expected: 415.0, actual: 415.0
OK     - Test 30: toShipment, expected: 1, actual: 1
OK     - Test 31: numberOfProducts, expected: 2, actual: 2
OK     - Test 32: makeNewShoppingBasketWith, expected: 2, actual: 2
OK     - Test 33: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 34: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 35: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 36: totalPriceInPence, expected: 830, actual: 830
OK     - Test 37: averagePriceInPence, expected: 415.0, actual: 415.0
OK     - Test 38: toShipment, expected: 2, actual: 2
OK     - Test 39: numberOfProducts, expected: 2, actual: 2
OK     - Test 40: makeNewShoppingBasketWith, expected: 2, actual: 2
OK     - Test 41: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 42: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 43: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 44: totalPriceInPence, expected: 830, actual: 830
OK     - Test 45: averagePriceInPence, expected: 415.0, actual: 415.0
OK     - Test 46: toShipment, expected: 2, actual: 2
OK     - Test 47: numberOfProducts, expected: 2, actual: 2
OK     - Test 48: makeNewShoppingBasketWith, expected: 2, actual: 2
OK     - Test 49: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 50: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 51: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 52: totalPriceInPence, expected: 830, actual: 830
OK     - Test 53: averagePriceInPence, expected: 415.0, actual: 415.0
OK     - Test 54: toString, expected: [(Pen, 750p, 40g)], actual: [(Pen, 750p, 40g)]
OK     - Test 55: toShipment, expected: null, actual: null
OK     - Test 56: numberOfProducts, expected: 1, actual: 1
OK     - Test 57: makeNewShoppingBasketWith, expected: 1, actual: 1
OK     - Test 58: makeNewShoppingBasketWith, expected: 0, actual: 0
OK     - Test 59: totalPriceInPence, expected: 750, actual: 750
OK     - Test 60: averagePriceInPence, expected: 750.0, actual: 750.0
OK     - Test 61: numberOfProducts, expected: 4, actual: 4
OK     - Test 62: makeNewShoppingBasketWith, expected: 3, actual: 3
OK     - Test 63: totalPriceInPence, expected: 2002780, actual: 2002780
OK     - Test 64: averagePriceInPence, expected: 500695.0, actual: 500695.0
OK     - Test 65: mostValuedShoppingBasket, expected: null, actual: null
OK     - Test 66: mostValuedShoppingBasket, expected: 2000000, actual: 2000000

OK    : 66
FAILED: 0

     */
}
