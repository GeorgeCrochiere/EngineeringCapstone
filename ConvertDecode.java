package CapstoneMainPackage;

public class ConvertDecode {

	public String NumbersToLetters(String binaryInput) {
		
		String result = "";
		String finalResult = "";
		
		for(int j = 0; j < binaryInput.length(); j++) {

			String tempCharSet = binaryInput.substring(j, j+1);
			while((binaryInput.substring(j+1, j+2)).equals(tempCharSet.substring(0,1))) {
				tempCharSet = tempCharSet + binaryInput.substring(j+1, j+2);
				j++;
				if ((tempCharSet.length() > 10) || (j > binaryInput.length()-2)) {
					break;
				}
			}
			
			if (tempCharSet.contains("1")) {
				if (tempCharSet.length() <= 3) {
					result = result + ".";
				} else {
					result = result + "-";
				}
			} else if (tempCharSet.contains("0")) {
				if (tempCharSet.length() > 4) {
					result = result + " ";
				}
			}
			
		}
		
		System.out.println(result);
		
		String[] morseCodeCombinations = result.split(" ");
		
		for (int k = 0; k < morseCodeCombinations.length; k++) {
			
			String currentLetter = morseCodeCombinations[k];
				
			if (currentLetter.equals(".-")) {
				finalResult = finalResult + "a";
			}if (currentLetter.equals("-...")) {
				finalResult = finalResult + "b";
			}if (currentLetter.equals("-.-.")) {
				finalResult = finalResult + "c";
			}if (currentLetter.equals("-..")) {
				finalResult = finalResult + "d";
			}if (currentLetter.equals(".")) {
				finalResult = finalResult + "e";
			}if (currentLetter.equals("..-.")) {
				finalResult = finalResult + "f";
			}if (currentLetter.equals("--.")) {
				finalResult = finalResult + "g";
			}if (currentLetter.equals("....")) {
				finalResult = finalResult + "h";
			}if (currentLetter.equals("..")) {
				finalResult = finalResult + "i";
			}if (currentLetter.equals(".---")) {
				finalResult = finalResult + "j";
			}if (currentLetter.equals("-.-")) {
				finalResult = finalResult + "k";
			}if (currentLetter.equals(".-..")) {
				finalResult = finalResult + "l";
			}if (currentLetter.equals("--")) {
				finalResult = finalResult + "m";
			}if (currentLetter.equals("-.")) {
				finalResult = finalResult + "n";
			}if (currentLetter.equals("---")) {
				finalResult = finalResult + "o";
			}if (currentLetter.equals(".--.")) {
				finalResult = finalResult + "p";
			}if (currentLetter.equals("--.-")) {
				finalResult = finalResult + "q";
			}if (currentLetter.equals(".-.")) {
				finalResult = finalResult + "r";
			}if (currentLetter.equals("...")) {
				finalResult = finalResult + "s";
			}if (currentLetter.equals("-")) {
				finalResult = finalResult + "t";
			}if (currentLetter.equals("..-")) {
				finalResult = finalResult + "u";
			}if (currentLetter.equals("...-")) {
				finalResult = finalResult + "v";
			}if (currentLetter.equals(".--")) {
				finalResult = finalResult + "w";
			}if (currentLetter.equals("-..-")) {
				finalResult = finalResult + "x";
			}if (currentLetter.equals("-.--")) {
				finalResult = finalResult + "y";
			}if (currentLetter.equals("--..")) {
				finalResult = finalResult + "z";
			}
			
			currentLetter = " ";
			
		}
		
		System.out.println(finalResult);
		return finalResult;
		
	}
	
}
