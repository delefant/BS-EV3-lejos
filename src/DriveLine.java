public class DriveLine {

  public static void main(String[] args) {
    AutonomerTWR roboter = new AutonomerTWR();

    while (true) {
      System.out.println(roboter.getLicht());

      if (roboter.getLicht() > 25 && roboter.getLicht() < 50) {
        roboter.driveLeft(0.25);
        roboter.driveRight(0.25);
      } else if (roboter.getLicht() > 50) {
        roboter.driveLeft(0.25);
        roboter.driveRight(0.1);
      } else if (roboter.getLicht() < 15) {
        roboter.driveLeft(0.1);
        roboter.driveRight(0.25);
      }
    }
  }
}
