package CapstoneMainPackage;

public class ConvertEncode {

	public String LettersToNumbers(String sendingString) {
		
		String numResultAsString = "";
		char[] StringAsChars = sendingString.toCharArray();
		
		for(int i = 0; i < StringAsChars.length; i++) {
			String binaryValue = Integer.toBinaryString(StringAsChars[i]);
			if (binaryValue.length() < 8) {
				binaryValue = "0" + binaryValue;
			}
			numResultAsString = numResultAsString + binaryValue + " ";
		}
		
		return numResultAsString;
		
	}
	
}
