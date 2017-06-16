import java.util.Comparator;

/**
 * Created by Amans on 15/06/2017.
 * Comparator which will be used to sort a collection of events in order of distance
 * from a location point.
 */
public class EventDistanceComparator implements Comparator<Event> {
    private int xFrom;
    private int yFrom;


    /**
     * Allows for new home location to be specified which will be used to compare two
     * events in the comparator
     *
     * @param posX the new starting x-position
     * @param posY the new starting y-position
     */
    public void setNewHomeLocation(int posX, int posY) {
        xFrom = posX;
        yFrom = posY;
    }

    /**
     * Compares two events by calculating the manhattan distance to each from the starting home
     * location currently set and gives preference over the smaller distance event.
     *
     * @param event1 arbitrary first event
     * @param event2 arbitrary second event
     * @return 1 if the distance from event 1 and starting point is less then event 2 from starting point
     * , -1 otherwise.
     */
    @Override
    public int compare(Event event1, Event event2) {
        int distancegeFromEvent1 = getManhattanDistance(xFrom, yFrom, event1.getX(), event1.getY());
        int distancegeFromEvent2 = getManhattanDistance(xFrom, yFrom, event2.getX(), event2.getY());
        if (distancegeFromEvent1 > distancegeFromEvent2) {
            return 1;
        } else {
            return -1;
        }
    }


    private int getManhattanDistance(int xFrom, int yFrom, int xTo, int yTo) {
        return Math.abs(xFrom - xTo) + Math.abs(yFrom - yTo);
    }
}

