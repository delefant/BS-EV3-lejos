public class UltraschallTest {

  public static void main(String[] args) {
    AutonomerTWR roboter = new AutonomerTWR();

    while(true){
      roboter.drive();
      if(roboter.getDistance() <= 5){
        roboter.stop();
        roboter.turn('l', 90);
        roboter.curve('r', 20.00, 180);
        roboter.turn('l', 90);
      }
    }
  }

}
