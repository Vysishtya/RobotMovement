import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class InfiniteTerrain {
    private Map<Integer, Position> robotPositions; // To store robot ID & positions
    private Set<String> occupiedPositions; // To store occupied positions

    public InfiniteTerrain() {
        this.robotPositions = new HashMap<>();
        this.occupiedPositions = new HashSet<>();
    }

    // To add a new robot at initial position
    public void addRobot(int id) {
        if (robotPositions.containsKey(id)) {
            System.out.println("Robot ID already exists!");
            return;
        }

        Position startPos = new Position(0, 0);
        robotPositions.put(id, startPos);
        occupiedPositions.add("0,0");
        System.out.println("Robot " + id + " placed at (0,0).");
    }

    // Robot movements
    public void moveRobot(int id, String command) {
        if (!robotPositions.containsKey(id)) {
            System.out.println("Robot not found!");
            return;
        }

        char direction = command.charAt(0);
        int steps = Integer.parseInt(command.substring(1));

        Position currentPos = robotPositions.get(id);
        int x = currentPos.x, y = currentPos.y;
        occupiedPositions.remove(x + "," + y);

        for (int i = 0; i < steps; i++) {
            int newX = x, newY = y;

            if (direction == 'N') newY++;
            else if (direction == 'S') newY--;
            else if (direction == 'E') newX++;
            else if (direction == 'W') newX--;

            //  To check if the new position is occupied by another robot
            if (occupiedPositions.contains(newX + "," + newY)) {
                System.out.println("Robot " + id + " stopped at (" + x + "," + y + ") due to another robot.");
                break;
            }

            x = newX;
            y = newY;
        }

        // Updating robot position
        robotPositions.put(id, new Position(x, y));
        occupiedPositions.add(x + "," + y);
        System.out.println("Robot " + id + " moved to (" + x + "," + y + ").");
    }

    //  for displaying all robot locations
    public void displayRobotLocations() {
        System.out.println("\nRobot Locations:");
        for (Map.Entry<Integer, Position> entry : robotPositions.entrySet()) {
            System.out.println("Robot " + entry.getKey() + " → (" + entry.getValue().x + "," + entry.getValue().y + ")");
        }
    }
}

// Position class to store (x, y) coordinates
class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
