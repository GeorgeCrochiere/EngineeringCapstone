package CapstoneMainPackage;

import java.util.Scanner;

public class MainStart {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		
		Encoder1 e1 = new Encoder1();
		ConvertEncode ce = new ConvertEncode();
		RecieveCode rc = new RecieveCode();
		SendCode sc = new SendCode();
		
		//Decoder1 d1 = new Decoder1();
		//ConvertDecode cd = new ConvertDecode();
		
		Scanner scan = new Scanner(System.in);
		
		//System.out.println("Please input the rate at which pulses will be send (delay in ms): ");
		double delayTime = 3;
		
		System.out.println("Please Select Mode: (Input or Output)");
		String modeType = scan.nextLine();
		String continuous = "Y";
		
		//System.out.println(ce.LettersToNumbers(e1.Encoding1("test")));
		//System.out.println(d1.Decoding1(cd.NumbersToLetters("0111011101111010011011000110011101100011011001000111100001100001011001100110101001101010011110100111011001110101011001100111000101101001011101010110010001111001")));
		
		while(continuous.equals("Y") || continuous.equals("y")) {
			if (modeType.equals("Output") || modeType.equals("output")) {
				
				System.out.println("What would you like to send");
				String inputRawText = scan.nextLine();
				//sc.SendingLight(ce.LettersToNumbers(e2.Encoding2(e1.Encoding1(inputRawText))));
				sc.SendingLight(ce.LettersToNumbers(inputRawText), delayTime);
				
				System.out.println("Would you like to send another message? [Y/N] ");
				continuous = scan.nextLine();
			}
			else if (modeType.equals("Input") || modeType.equals("input")) {
				rc.RecievingLight(delayTime);
				
				System.out.println("Would you like to continue? [Y/N] ");
				continuous = scan.nextLine();
			}
			else {
				System.out.println("Sorry, that option is invalid.");
				System.out.println("Please Select Mode: (Input or Output)");
				modeType = scan.nextLine();
			}
		}
		
	}

}
