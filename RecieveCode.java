package CapstoneMainPackage;

import java.util.ArrayList;
import com.pi4j.io.gpio.*;

public class RecieveCode {

	public void RecievingLight(double delay) throws InterruptedException {
		
		ConvertDecode cd = new ConvertDecode();
		Decoder1 d1 = new Decoder1();
		AccurateTiming ac = new AccurateTiming();
		
		final GpioController gpioIn = GpioFactory.getInstance();
		final GpioPinDigitalInput inputSensor = gpioIn.provisionDigitalInputPin(RaspiPin.GPIO_27, PinPullResistance.PULL_DOWN);
		
		ArrayList<String> data = new ArrayList<String>();
		
		inputSensor.setShutdownOptions(true);
		boolean continueLoop = true;
		boolean writeDataCheck = false;
		int endZeroCounter = 0;
		
		while(continueLoop) {
			if (inputSensor.getState() == PinState.LOW) {
				System.out.println("Starting:...");
				continueLoop = false;
				writeDataCheck = true;
				ac.delayTiming(delay/3);
				//Thread.sleep(delay/3);
				while(writeDataCheck) {
					if (inputSensor.getState() == PinState.LOW) {
						System.out.print("1");
						data.add("1");
						endZeroCounter = 0;
						ac.delayTiming(delay);
						//Thread.sleep(delay);
					} else {
						System.out.print("0");
						data.add("0");
						endZeroCounter++;
						ac.delayTiming(delay);
						//Thread.sleep(delay);
					}
					if (endZeroCounter > 15) {
						writeDataCheck = false;
						System.out.println(" ");
						System.out.println("Message Recieved...");
						String finalResult = data.toString();
						finalResult = finalResult.replaceAll(", ", "");
						finalResult = finalResult.replaceAll("\\[", "");
						finalResult = finalResult.replaceAll("\\]", "");
						String binaryAsLetters = cd.NumbersToLetters(finalResult);
						String lettersDecoded = d1.Decoding1(binaryAsLetters);
						System.out.println(lettersDecoded);
						gpioIn.unprovisionPin(inputSensor);
						gpioIn.shutdown();
					}
				}
			}

			ac.delayTiming(1);
			//Thread.sleep(1);
		}	
	}
	
}
