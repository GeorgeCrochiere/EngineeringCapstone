package CapstoneMainPackage;

import java.util.Scanner;

public class MainStart {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		
		Encoder1 e1 = new Encoder1();
		ConvertEncode ce = new ConvertEncode();
		RecieveCode rc = new RecieveCode();
		SendCode sc = new SendCode();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please Select Mode: (Input or Output)");
		String modeType = scan.nextLine();
		String continuous = "Y";
		while(continuous.equals("Y") || continuous.equals("y")) {
			if (modeType.equals("Output") || modeType.equals("output")) {
				
				System.out.println("What would you like to send");
				String inputRawText = scan.nextLine();
				//sc.SendingLight(ce.LettersToNumbers(e2.Encoding2(e1.Encoding1(inputRawText))));
				sc.SendingLight(ce.LettersToNumbers(e1.Encoding1(inputRawText)));
				
				System.out.println("Would you like to send another message? [Y/N] ");
				continuous = scan.nextLine();
			}
			else if (modeType.equals("Input") || modeType.equals("input")) {
				rc.RecievingLight();
			}
			else {
				System.out.println("Sorry, that option is invalid.");
				System.out.println("Please Select Mode: (Input or Output)");
				modeType = scan.nextLine();
			}
		}
		
	}

}
