/**
 * A Product has a name, a price in pence, and a weight in grammes.
 * Objects of this class are immutable: after an object of class
 * Product has been created, one cannot change the values of its
 * attributes. Thus, the class Product has no mutators.
 *
 * @author Carsten Fuhs
 * @version 1.0
 */
public class Product implements Comparable<Product> {

    /** The name of the Product. Always non-null after object creation. */
    private final String name;

    /** The price of a Product in pence. Must be at least 0. */
    private final long priceInPence;

    /** The weight of a Product in grammes. Must be at least 1. */
    private final int weightInGrammes;

    /**
     * Constructs a new Product with given name, priceInPence, and
     * weightInGrammes.
     *
     * @param name the name of the Product; must not be null
     * @param priceInPence the price of the Product in pence;
     *  must not be negative
     * @param weightInGrammes the weight of the Product in grammes;
     *  must not be negative
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if priceInPence or weightInGrammes
     *  is negative
     */
    public Product(String name, long priceInPence, int weightInGrammes) {
        if (name == null) {
            throw new NullPointerException("name must not be null!");
        }
        if (priceInPence < 0) {
            throw new IllegalArgumentException("Expected priceInPence >= 0, found "
                    + priceInPence);
        }
        if (weightInGrammes < 1) {
            throw new IllegalArgumentException("Expected weightInGrammes >= 0, found "
                    + weightInGrammes);
        }
        this.name = name;
        this.priceInPence = priceInPence;
        this.weightInGrammes = weightInGrammes;
    }

    /**
     * Returns the name of this Product.
     *
     * @return the name; always non-null
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the price in pence of this Product.
     *
     * @return the price in pence; always at least 0
     */
    public long getPriceInPence() {
        return this.priceInPence;
    }

    /**
     * Returns the weight in grammes of this Product.
     *
     * @return the weight in grammes; always at least 1
     */
    public int getWeightInGrammes() {
        return this.weightInGrammes;
    }

    /**
     * Returns a String representation of this Product with a "(", the name of
     * this Product, ", " (comma and space), the price in pence, "p, ", the
     * weight in grammes, and "g)".
     *
     * For example, if p is an Product with name "Pen", a price of 750 pence,
     * and a weight of 60 grammes, the call p.toString() would return
     * "(Pen, 750p, 60g)".
     *
     * @return a human-readable String representation of this Product
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "(" + this.name + ", " + this.priceInPence + "p, "
                + this.weightInGrammes + "g)";
    }

    /**
     * Returns the hash code of this Product. The hash code of an Product is
     * based on its name, its price in pence, and its weight in grammes.
     *
     * @return the hash code of this Product
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        // this implementation relies on the name attribute being non-null
        return prime * (prime * this.weightInGrammes + (int) this.priceInPence)
                + this.name.hashCode();
    }

    /**
     * Returns whether this Product and another object are equal. This is the
     * case if the other object is also an Product object with the same price
     * in pence and equal name.
     *
     * @param obj another object to be compared with
     * @return whether this Product and obj are equal
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        // this implementation relies on the name attribute being non-null
        return this.priceInPence == other.priceInPence
             && this.weightInGrammes == other.weightInGrammes
             && this.name.equals(other.name);
    }

    /**
     * Compares this Product to o. The comparison considers first the prices
     * (higher is greater), then, in case of a tie, the weights (higher is
     * greater), and, as a final tie-breaker, the names wrt their natural
     * ordering given by their compareTo() method.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *  is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     */
    @Override
    public int compareTo(Product o) {
        if (this.priceInPence > o.priceInPence) {
            return 1;
        }
        if (this.priceInPence < o.priceInPence) {
            return -1;
        }
        if (this.weightInGrammes > o.weightInGrammes) {
            return 1;
        }
        if (this.weightInGrammes < o.weightInGrammes) {
            return -1;
        }
        // this implementation relies on the name attribute being non-null
        return this.name.compareTo(o.name);
    }
}
