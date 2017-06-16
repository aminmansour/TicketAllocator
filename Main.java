import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //set of data variables
        String location = "";
        int xLocation = 0;
        int yLocation = 0;


        //Will randomaly generate events
        Allocator allocator = new Allocator();
        allocator.generateEvents(10);

        program:
        while (true) {

            while (true) {
                //instruction 1
                System.out.println("Please enter your location, x position followed by y seperated by a \",\"  i.e 2,3 or \"EXIT\" to" +
                        " exit the program");

                //user input
                location = scan.next();

                //checks if exit command has been entered
                if ("exit".equals(location.toLowerCase())) {
                    break program;
                }

                //checks if number
                if (!location.matches("-?\\d+,-?\\d+")) {
                    System.out.println("This is a invalid format. Enter as shown : x,y");
                    continue;
                }

                xLocation = Integer.parseInt(location.substring(0, location.indexOf(",")));
                yLocation = Integer.parseInt(location.substring(location.indexOf(",") + 1, location.length()));

                //checks if in range
                if (xLocation > 10 || xLocation < -10 || yLocation > 10 || yLocation < -10) {
                    System.out.println("Not in range of world. Enter as shown : x,y");
                    continue;
                }

                //if pass checks then continue on
                break;
            }

            //results
            System.out.println("The results of the search :");
            List<Event> result = allocator.determineClosestEvents(xLocation, yLocation, 5);


            DecimalFormat moneyFormat = new DecimalFormat("00.00");
            DecimalFormat idFormat = new DecimalFormat("000");

            //print closest events from starting location in order
            for (Event e : result) {
                int distance = Math.abs(xLocation - e.getX()) + Math.abs(yLocation - e.getY());
                System.out.println("Event " + idFormat.format(e.getId()) + " - $" + moneyFormat.format(e.getCheapestTicket())
                        + ", Distance " + distance);
            }
        }
    }
}
