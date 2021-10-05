import java.util.Arrays;

/**
 * A shipment consists of 1 or more parcels.
 * A parcel consists of 1 or more Products.
 * Objects of this class can currently only store the contents of a Shipment,
 * provide a String representation, and allow limited access to information
 * about the contents.
 *
 * Further functionality may be provided in a later version of class Shipment. 
 *
 * @author Carsten Fuhs
 * @version 0.1
 */
public class Shipment {

    /**
     * The contents of the shipment in several parcels.
     * Is not the null reference, does not contain the null reference,
     * and does not contain an array that contains the null reference.
     * Both contents and all of its entries have length at least 1.
     */ 
    private Product[][] contents;

    /**
     * Constructs a new Shipment with the contents passed as parameter.
     *
     * @param contents will be stored internally; must not be modified by the
     *  caller; may be null, but may not contain null nor contain an array that
     *  contains null  
     */
    public Shipment(Product[][] contents) {
        if (contents == null) {
            throw new IllegalArgumentException("Illegal null argument!");
        }
        if (contents.length == 0) {
            throw new IllegalArgumentException("Illegal length 0 array as parameter!");
        }
        else {
            for (Product[] parcel : contents) {
                if (parcel == null) {
                    throw new IllegalArgumentException("Illegal null entry in contents!");
                }
                if (parcel.length == 0) {
                    throw new IllegalArgumentException("Illegal length 0 array in contents!");
                }
                for (Product p : parcel) {
                    if (p == null) {
                        throw new IllegalArgumentException("Illegal null entry in an array in contents!");
                    }
                }
            }
            this.contents = contents;
        }
    }

    /**
     * Returns an array of the Products stored in this Shipment.
     *
     * @return an array of the Products stored in this Shipment
     */
    public Product[] getFlattenedContents() {
        Product[] result = new Product[this.numberOfProducts()];
        int resPos = 0;
        for (int i = 0; i < this.contents.length; i++) {
            for (int j = 0; j < this.contents[i].length; j++) {
                result[resPos] = this.contents[i][j];
                resPos++;
            }
        }
        return result;
    }

    /**
     * Returns the number of Products in this Shipment.
     * 
     * @return the number of Products in this Shipment.
     */
    public int numberOfProducts() {
        int result = 0;
        for (int i = 0; i < this.contents.length; i++) {
            result += this.contents[i].length;
        }
        return result;
    }

    /**
     * Returns the number of parcels in this Shipment.
     *
     * @return the number of parcels in this Shipment
     */
    public int numberOfParcels() {
        return this.contents.length;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.contents);
    }
}
