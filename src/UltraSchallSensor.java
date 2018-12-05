

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;


public class UltraSchallSensor {
	
		private EV3Brick baustein;
		private Port port;
		private EV3UltrasonicSensor sensor;
		private SampleProvider sp;
		
		public UltraSchallSensor(String portName) {
			baustein = new EV3Brick();
			port = baustein.getPort(portName);
			sensor = new EV3UltrasonicSensor(port);
			sp = sensor.getMode("Distance");
		}
		
		
		int sampleSonic (){
			float[] sample = new float[sp.sampleSize()];
			sp.fetchSample(sample, 0);
			int dist = (int)(sample[0] * 100 + 0.5);
			return (dist);
	    }
		
				
		public void closeSonic() {
			sensor.close();
		}
}
