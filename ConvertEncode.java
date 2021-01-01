package CapstoneMainPackage;

public class ConvertEncode {

	public String LettersToNumbers(String sendingString) {
		
		String numResultAsString = "";
		String morseCodeAsString = "";
		char[] StringAsChars = sendingString.toCharArray();
		String end = "00000";
		
		for(int i = 0; i < StringAsChars.length; i++) {
			String individualLetter = String.valueOf(StringAsChars[i]);
			if (individualLetter.equals("a")) {
				morseCodeAsString = morseCodeAsString + ".- ";
			}if (individualLetter.equals("b")) {
				morseCodeAsString = morseCodeAsString + "-... ";
			}if (individualLetter.equals("c")) {
				morseCodeAsString = morseCodeAsString + "-.-. ";
			}if (individualLetter.equals("d")) {
				morseCodeAsString = morseCodeAsString + "-.. ";
			}if (individualLetter.equals("e")) {
				morseCodeAsString = morseCodeAsString + ". ";
			}if (individualLetter.equals("f")) {
				morseCodeAsString = morseCodeAsString + "..-. ";
			}if (individualLetter.equals("g")) {
				morseCodeAsString = morseCodeAsString + "--. ";
			}if (individualLetter.equals("h")) {
				morseCodeAsString = morseCodeAsString + ".... ";
			}if (individualLetter.equals("i")) {
				morseCodeAsString = morseCodeAsString + ".. ";
			}if (individualLetter.equals("j")) {
				morseCodeAsString = morseCodeAsString + ".--- ";
			}if (individualLetter.equals("k")) {
				morseCodeAsString = morseCodeAsString + "-.- ";
			}if (individualLetter.equals("l")) {
				morseCodeAsString = morseCodeAsString + ".-.. ";
			}if (individualLetter.equals("m")) {
				morseCodeAsString = morseCodeAsString + "-- ";
			}if (individualLetter.equals("n")) {
				morseCodeAsString = morseCodeAsString + "-. ";
			}if (individualLetter.equals("o")) {
				morseCodeAsString = morseCodeAsString + "--- ";
			}if (individualLetter.equals("p")) {
				morseCodeAsString = morseCodeAsString + ".--. ";
			}if (individualLetter.equals("q")) {
				morseCodeAsString = morseCodeAsString + "--.- ";
			}if (individualLetter.equals("r")) {
				morseCodeAsString = morseCodeAsString + ".-. ";
			}if (individualLetter.equals("s")) {
				morseCodeAsString = morseCodeAsString + "... ";
			}if (individualLetter.equals("t")) {
				morseCodeAsString = morseCodeAsString + "- ";
			}if (individualLetter.equals("u")) {
				morseCodeAsString = morseCodeAsString + "..- ";
			}if (individualLetter.equals("v")) {
				morseCodeAsString = morseCodeAsString + "...- ";
			}if (individualLetter.equals("w")) {
				morseCodeAsString = morseCodeAsString + ".-- ";
			}if (individualLetter.equals("x")) {
				morseCodeAsString = morseCodeAsString + "-..- ";
			}if (individualLetter.equals("y")) {
				morseCodeAsString = morseCodeAsString + "-.-- ";
			}if (individualLetter.equals("z")) {
				morseCodeAsString = morseCodeAsString + "--.. ";
			}
		}
		
		for (int j = 0; j < morseCodeAsString.length(); j++) {
			String currentCharacter = morseCodeAsString.substring(j, j+1);
			if (currentCharacter.equals(".")) {
				numResultAsString = numResultAsString + "11000";
			}if (currentCharacter.equals("-")) {
				numResultAsString = numResultAsString + "111111000";
			}if (currentCharacter.equals(" ")) {
				numResultAsString = numResultAsString + "00000";
			}
		}
		
		numResultAsString = numResultAsString + end;
		
		System.out.println(morseCodeAsString);
		System.out.println(numResultAsString);
		
		return numResultAsString;
		
	}
	
}
