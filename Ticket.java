/**
 * Created by Amans on 15/06/2017.
 * Represents a ticket which gives access to a event and holds a price.
 */
public class Ticket {
    private double price;

    public Ticket(double price) {
        this.price = price;
    }

    /**
     * @return gets the price of ticket
     */
    public double getPrice() {
        return price;
    }
}
