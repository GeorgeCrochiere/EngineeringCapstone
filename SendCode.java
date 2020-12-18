package CapstoneMainPackage;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.*;

public class SendCode {
	
	AccurateTiming ac = new AccurateTiming();
	
	public void SendingLight(String inputString, double delay) throws InterruptedException {
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput outPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "MyLaser", PinState.LOW);
		outPin.setShutdownOptions(true, PinState.LOW);
		
		inputString = inputString + "0000";
		
		for(int m = 0; m < inputString.length(); m++) {
			char currentChar = inputString.charAt(m);
			if (currentChar == '1') {
				outPin.setState(PinState.HIGH);
				outPin.high();
				ac.delayTiming(delay);
				//Thread.sleep(delay);
			} else if (currentChar == '0') {
				outPin.setState(PinState.LOW);
				outPin.low();
				ac.delayTiming(delay);
				//Thread.sleep(delay);
			}
		}
		gpio.shutdown();
		gpio.unprovisionPin(outPin);
	}
	
}
