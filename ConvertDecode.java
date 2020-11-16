package CapstoneMainPackage;

public class ConvertDecode {

	public String NumbersToLetters(String binaryInput) {
		
		String result = "";
		
		for(int j = 0; j < binaryInput.length(); j+=8) {
			String oneLetterBinary = binaryInput.substring(j, j+8);
			int letter = Integer.parseInt(oneLetterBinary, 2);
			
			String[] letCode = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			int codeCorrelation = letter-97;
			result = result + letCode[codeCorrelation];
			
		}
		
		return result;
		
	}
	
}
