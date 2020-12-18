package CapstoneMainPackage;

public class AccurateTiming {

	public void delayTiming(double delay) {
		
		long startTime = System.nanoTime();
		long endTime = startTime + (long)(delay * 1000000);
		boolean timingCheck = true;
		
		while(timingCheck) {
			long currentTime = System.nanoTime();
			if(currentTime >= endTime) {
				timingCheck = false;
			}
		}
		
	}
	
}
