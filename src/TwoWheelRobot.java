import lejos.hardware.port.Port;

public class TwoWheelRobot {

  private double speed;
  private EV3Brick baustein;
  private Motor motA;
  private Motor motB;
  private Port portB;
  private Port portC;

  public TwoWheelRobot() {
    this.setSpeed(1.0);
    this.assemble();
  }

  private void assemble() {
    baustein = new EV3Brick();
    motA = new Motor();
    motB = new Motor();
    portB = baustein.getPort("B");
    portC = baustein.getPort("C");

    motA.connect(portB);
    motB.connect(portC);
  }

  public double getSpeed() {
    return this.speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public void stop() {
    motA.stop();
    motB.stop();
  }

  public void drive() {
    motA.start(this.speed);
    motB.start(this.speed);
  }

  public void driveLeft(double speed) {
    motB.start(speed);
  }

  public void driveRight(double speed) {
    motA.start(speed);
  }

  public void drive(double revs) {
    motA.start(this.speed);
    motB.start(this.speed);

    Helfer.delayProgramm(revs);
    motA.stop();
    motB.stop();
  }

  private double calculateBogenmass(int angle, double radius) {
    return (angle / 360.0) * 2.0 * Math.PI * radius;
  }

  public void turn(Character direction) {
    switch (direction) {
      case 'l':
        motB.start(this.speed);
        break;
      case 'r':
        motA.start(this.speed);
        break;
    }
  }

  public void turn(Character direction, int angle) {
    switch (direction) {
      case 'l':
        motB.start(1.0);
        Helfer.delayProgramm(
            calculateBogenmass(angle, Helfer.SPURWEITE) / (Math.PI * Helfer.DURCHMESSER));
        motB.stop();
        break;
      case 'r':
        motA.start(1.0);
        Helfer.delayProgramm(
            calculateBogenmass(angle, Helfer.SPURWEITE) / (Math.PI * Helfer.DURCHMESSER));
        motA.stop();
        break;
    }
  }

  private double calcCurve(int angle, double radius) {
    double bm_aussen = calculateBogenmass(angle, radius);
    double bm_innen = calculateBogenmass(angle, radius - Helfer.SPURWEITE);
    return bm_innen / bm_aussen;
  }

  public void curve(Character direction, double radius, int angle) {
    switch (direction) {
      case 'r':
        motA.start(1.0);
        motB.start(calcCurve(angle, radius));
        Helfer.delayProgramm(calculateBogenmass(angle, radius) / (Math.PI * Helfer.DURCHMESSER));
        motA.stop();
        motB.stop();
        break;
      case 'l':
        motB.start(1.0);
        motA.start(calcCurve(angle, radius));
        Helfer.delayProgramm(calculateBogenmass(angle, radius) / (Math.PI * Helfer.DURCHMESSER));
        motA.stop();
        motB.stop();
        break;
    }

  }
}
