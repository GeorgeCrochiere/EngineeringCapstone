package CapstoneMainPackage;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.*;

public class SendCode {
	
	public void SendingLight(String inputString) throws InterruptedException {
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput outPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "MyLaser", PinState.LOW);
		outPin.setShutdownOptions(true, PinState.LOW);
		
		int delay = 12;
		
		inputString = "11001011" + inputString;
		
		for(int m = 0; m < inputString.length(); m++) {
			char currentChar = inputString.charAt(m);
			if (currentChar == '1') {
				outPin.setState(PinState.HIGH);
				outPin.high();
				Thread.sleep(delay);
			} else if (currentChar == '0') {
				outPin.setState(PinState.LOW);
				outPin.low();
				Thread.sleep(delay);
			}
		}
		gpio.shutdown();
		gpio.unprovisionPin(outPin);
	}
	
}
