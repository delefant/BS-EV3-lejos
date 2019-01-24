public class AutonomerTWR extends TwoWheelRobot {

  public LichtSensor lichtsensor;

  AutonomerTWR() {
    super();
    assemble();
  }

  public void assemble() {
    lichtsensor = new LichtSensor("S1");
  }

  public int getLicht() {
    return this.lichtsensor.sampleLight();
  }

}
