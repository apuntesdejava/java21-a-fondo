class Robot {
    void Robot() {
        System.out.println("method");
    }
}

public class Demo {
    public static void main(String[] args) {
        Robot robot = new Robot();

        System.out.println("new Robot() no invoco Robot()");
        robot.Robot();
    }
}
