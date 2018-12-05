public class SensorTest_lb {
    public static void main(String[] args) {
        TwoWheelRobot roboter = new TwoWheelRobot();
        int color;

        roboter.drive();

        while(true) {
            color = roboter.lichtsensor.sampleLight();
            if(color < 50){
                roboter.stop();
                break;
            }
        }
    }
}
