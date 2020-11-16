package CapstoneMainPackage;

import java.util.ArrayList;
import com.pi4j.io.gpio.*;

public class RecieveCode {

	public void RecievingLight() throws InterruptedException {
		
		ConvertDecode cd = new ConvertDecode();
		Decoder1 d1 = new Decoder1();
		
		final GpioController gpioIn = GpioFactory.getInstance();
		final GpioPinDigitalInput inputSensor = gpioIn.provisionDigitalInputPin(RaspiPin.GPIO_27, PinPullResistance.PULL_DOWN);
		
		ArrayList<String> data = new ArrayList<String>();
		String resultBinary = "";
		
		inputSensor.setShutdownOptions(true);
		boolean continueLoop = true;
		boolean writeDataCheck = false;
		
		int delay = 12;
		
		while(continueLoop) {
			if (inputSensor.getState() == PinState.LOW) {
				System.out.println("1:");
				continueLoop = false;
				writeDataCheck = true;
				while(writeDataCheck) {
					if (inputSensor.getState() == PinState.LOW) {
						System.out.print("1");
						data.add("1");
						Thread.sleep(delay);
					} else {
						System.out.print("0");
						data.add("0");
						Thread.sleep(delay);
					}
					if (data.size() >= 16 && (data.size())%8 == 0) {
						String testEnd = "";
						for (int u = 0; u < 8; u++) {
							testEnd = testEnd + data.get(((data.size()) + u - 8));
						}
						if (testEnd.equals("00000000") && (data.size())%8 == 0) {
							System.out.println(" ");
							System.out.println(data);
							writeDataCheck = false;
							System.out.println("Message Recieved...");
							for (int p = 8; p < (data.size())-8; p++) {
								resultBinary = resultBinary + data.get(p);
							}
						};
					} 
				}
				String binaryAsLetters = cd.NumbersToLetters(resultBinary);
				String lettersDecoded = d1.Decoding1(binaryAsLetters);
				System.out.println(resultBinary);
				System.out.println(binaryAsLetters);
				System.out.println(lettersDecoded);
				writeDataCheck = false;
			}

			Thread.sleep(1);
		}
		
	}
	
}
