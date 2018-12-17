package cypher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Attempts to break Caesar Cipher
 * @author oliver
 *
 */
public class Cryptanalysis {

	//try all possible shifts compare strings to dict
	public static void bruteForce(String cryptoText){
		ArrayList<String> attempts = new ArrayList<>();
		ArrayList<Integer> keys = new ArrayList<>();
		
		for(int i=0; i<Cypher.alphabet.length(); i++) {
			attempts.add(Cypher.decrypt(cryptoText, i));
			keys.add(i);
			//insert test here if over threshhold save
		}
		
		//manual check
		for (int i=0; i<attempts.size(); i++) {
			System.out.println("key: " + keys.get(i) + "| decryption: " + attempts.get(i));
		}
		
	}
	//to check can see how many words are in dictionary
	
	
	//check frequencies of characters and compare to expected frequencies. 
	public static void frequencyAnalysis() {
		//1. make a map of each alphabet char and its freq
		//2. one with most freq try shift to 'e' or space, if not then try next one?
		Map<Character, Integer> frequecyMap = new HashMap<>();
		
		
		
		
	}
	
}
