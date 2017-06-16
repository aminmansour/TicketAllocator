import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Amans on 15/06/2017.
 * Allocator which produces the arbitrary events and can retrieve the closest events
 * from a specific location point.
 */
public class Allocator {

    private ArrayList<Event> events;
    private EventDistanceComparator distanceComparator;
    private Random numGenerator;

    public Allocator() {
        events = new ArrayList<Event>();
        distanceComparator = new EventDistanceComparator();
        numGenerator = new Random();
    }

    /**
     * randomly generate seeded data by creating arbitrary events of a fixed number
     * and placing them in random locations on the board
     *
     * @param eventsToGenerate total amount of events to randomly generate
     */
    public void generateEvents(int eventsToGenerate) {
        for (int i = 0; i < eventsToGenerate; ++i) {
            int xPos = numGenerator.nextInt(21) - 10;
            int yPos = numGenerator.nextInt(21) - 10;
            int ticketAllocation = (numGenerator.nextInt(20) + 1) * 5;
            Event event = new Event(ticketAllocation, xPos, yPos);
            events.add(event);
        }

    }

    /**
     * Retrieves the closest events from a given location inputted
     *
     * @param posX  x-position to start from as the location point
     * @param posY  y-position to start from as the location point
     * @param range the amount of events to look for from the starting point
     * @return the collection of events in order of distance from the starting location.
     */
    public List<Event> determineClosestEvents(int posX, int posY, int range) {
        distanceComparator.setNewHomeLocation(posX, posY);
        events.sort(distanceComparator);
        return events.subList(0, range);

    }
}
