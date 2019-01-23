public class SensorTest_lb {

  public static void main(String[] args) {
    TwoWheelRobot roboter = new TwoWheelRobot();
    int color;
    int lc = 0;

    roboter.drive();

    while (true) {
      color = roboter.lichtsensor.sampleLight();
      System.out.println(color);
      if (color < 50) {
        lc++;
        Helfer.delayProgramm(0.1);
        if (lc >= 3) {
          roboter.stop();
          Helfer.delayProgramm(5.0);
          break;
        }
      }
    }
  }
}
