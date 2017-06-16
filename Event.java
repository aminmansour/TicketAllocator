import java.util.Random;

/**
 * Created by Amans on 15/06/2017.
 * Represents a event which holds a location with a globally unique id and a set of tickets of
 * varying prices
 */
public class Event {

    private static int nextIdAvailable = 1;

    private int id;
    private int posX;
    private int posY;
    private Ticket[] tickets;

    public Event(int ticketsToBeAllocated, int posX, int posY) {
        id = nextIdAvailable;
        nextIdAvailable++;
        this.posX = posX;
        this.posY = posY;
        allocateTickets(ticketsToBeAllocated);
    }

    //generates the ticket objects needed to be created for this event.
    private void allocateTickets(int ticketsToBeAllocated) {
        Random ticketPriceGenerator = new Random();
        tickets = new Ticket[ticketsToBeAllocated];
        for (int i = 0; i < ticketsToBeAllocated; i++) {
            double price = (ticketPriceGenerator.nextInt(240) * 0.5 + 1);
            tickets[i] = new Ticket(price);
        }
    }

    /**
     * @return The id of the event
     */
    public int getId() {
        return id;
    }

    /**
     * @return The y-position of event
     */
    public int getY() {
        return posY;
    }


    /**
     * @return The x-position of event
     */
    public int getX() {
        return posX;
    }

    /**
     * @return The amount of tickets available to be allocated to customers
     */
    public int getTicketsAvailable() {
        return tickets.length;
    }

    /**
     * @return Gets the smallest priced ticket in this particular event.
     */
    public double getCheapestTicket() {
        double smallestValue = Double.MAX_VALUE;
        for (Ticket t : tickets) {
            if (t.getPrice() < smallestValue) {
                smallestValue = t.getPrice();
            }
        }
        return smallestValue;
    }


}
