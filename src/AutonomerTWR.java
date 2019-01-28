public class AutonomerTWR extends TwoWheelRobot {

  public LichtSensor lichtsensor;

  AutonomerTWR() {
    super();
    lichtsensor = new LichtSensor("S1");
  }

  public int getLicht() {
    return this.lichtsensor.sampleLight();
  }

  public void followLine(){
    while (true) {
      System.out.println(this.getLicht());

      if (this.getLicht() > 25 && this.getLicht() < 45) {
        this.driveLeft(0.25);
        this.driveRight(0.25);
      } else if (this.getLicht() > 45 && this.getLicht() < 55) {
        this.driveLeft(0.25);
        this.driveRight(0.15);
      } else if (this.getLicht() > 55) {
        this.driveLeft(0.25);
        this.driveRight(0.0);
      } else if (this.getLicht() < 25 && this.getLicht() > 15) {
        this.driveLeft(0.15);
        this.driveRight(0.25);
      } else if (this.getLicht() < 15) {
        this.driveLeft(0.0);
        this.driveRight(0.25);
      }
    }
  }

  public int countLines(){
    this.setSpeed(0.5);
    int counter = 0;

    this.drive();
    while(true){
      System.out.println(counter);

      if(this.getLicht() < 55){
        counter++;
        Helfer.delayProgramm(0.2);
        if(counter >= 3){
          this.stop();
          return counter;
        }
      }
    }
  }

  public void twerk(){
    double richtung = 1.0;
    double gegenrichtung = -1.0;
    while(true){
      Helfer.delayProgramm(0.1);
      this.stop();
      if(richtung < 0){
        richtung += 2.0;
        gegenrichtung -= 2.0;
      } else {
        richtung -= 2.0;
        gegenrichtung += 2.0;
      }
      this.driveLeft(richtung);
      this.driveRight(gegenrichtung);
    }
  }
}
