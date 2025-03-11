public class Main {
    public static void main(String[] args) {
        InfiniteTerrain terrain = new InfiniteTerrain();

        terrain.addRobot(1);
        terrain.addRobot(2);
        terrain.addRobot(3);
        terrain.addRobot(4);

        terrain.moveRobot(1, "E5");
        terrain.moveRobot(2, "E5");
        terrain.moveRobot(3, "E5");

        terrain.moveRobot(4,"N8");
        terrain.moveRobot(4,"S7");
        terrain.moveRobot(4,"E2");
        terrain.moveRobot(4,"W7");



        terrain.displayRobotLocations();
    }
}
