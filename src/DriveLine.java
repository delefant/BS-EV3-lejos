public class DriveLine {

  public static void main(String[] args) {
    AutonomerTWR roboter = new AutonomerTWR();
    int lc, error;
    double speedcorrector;

    while (true) {
      System.out.println(roboter.getLicht());

      lc = roboter.getLicht();
      error = lc - 2;
      speedcorrector = ((double)error / 100);

      //if (roboter.getLicht() > 25 && roboter.getLicht() < 45) {
      //  roboter.driveLeft(0.25);
      //  roboter.driveRight(0.25);
      //} else if (roboter.getLicht() > 45) {
      //  roboter.driveLeft(0.25);
      //  roboter.driveRight(0.1);
      //} else if (roboter.getLicht() < 15) {
      //  roboter.driveLeft(0.1);
      //  roboter.driveRight(0.25);
      //}

      if (roboter.getLicht() > 2 && roboter.getLicht() < 45) {
        roboter.driveLeft(0.25);
        roboter.driveRight(0.25);
      } else if (roboter.getLicht() > 45) {
        roboter.driveLeft(speedcorrector);
        roboter.driveRight(speedcorrector / 3);
      } else if (roboter.getLicht() < 2) {
        roboter.driveLeft(speedcorrector / 3);
        roboter.driveRight(speedcorrector);
      }
    }
  }
}
