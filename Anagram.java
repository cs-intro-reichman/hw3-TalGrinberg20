/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		//System.out.println(Anagram.preProcess("Hello World!").equals("hello world"));

		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	//Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String firsString = preProcess(str1);
		String anagramString = preProcess(str2);
		for (int i = 0; i < firsString.length(); i++) {
			if(anagramString.indexOf((int)firsString.charAt(i))== -1){
				return false;	
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String processedString = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>=65 && str.charAt(i)<=90) {
			processedString = processedString + (char) (str.charAt(i) + 32);
			}
		else if (str.charAt(i)>=97 && str.charAt(i)<=122){
			processedString = processedString + (char) (str.charAt(i));
		}
		
		else if (str.charAt(i) == 32) {	
		processedString = processedString + (char) (str.charAt(i));
		}
		}
		return processedString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String processedString = preProcess(str);
		String randomString = "";
		int position;
		for (int i = 0; processedString.length() != 0; i++) {
			position = (int) (processedString.length() * Math.random());
			randomString = randomString + (char) (processedString.charAt(position));
			processedString = processedString.substring(0, position) + processedString.substring(position+1);
		}
		return randomString;
	}
}
