public class SensorTest_lb {
    public static void main(String[] args) {
        TwoWheelRobot roboter = new TwoWheelRobot();
        int color;

        roboter.drive();

        while(true) {
            color = roboter.lichtsensor.sampleLight();
            System.out.println(color);
            if(color < 20){
                roboter.stop();
                Helfer.delayProgramm(10.0);
                break;
            }
        }
    }
}
