package cypher;

public class Cypher {
//	static char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static String alphabet = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVQXYZ,.;:?'!1234567890$&"; // ABCDEFGHIJKLMNOPQRSTUVQXYZ

	public static String encrypt(String p, int k) {
		
		String c = "";
		
		for (int i=0; i< p.length(); i++) {
			char currentChar = p.charAt(i);
			int currentCharPos = -1;
			for (int j=0; j<alphabet.length(); j++) {
				if (currentChar == alphabet.charAt(j)) {
					currentCharPos = j;
				}
			}
			int newCharPos = (currentCharPos + k) % alphabet.length();
			char newChar = alphabet.charAt(newCharPos);
			c += newChar;
		}
		
		System.out.println(c);
		return c;
	}
	
	public static String decrypt(String c, int k) {
		
		String p = "";
		
		for (int i=0; i< c.length(); i++) {
			char currentChar = c.charAt(i);
			int currentCharPos = -1;
			for (int j=0; j<alphabet.length(); j++) {
				if (currentChar == alphabet.charAt(j)) {
					currentCharPos = j;
				}
			}
			
			int newCharPos = -1;
			if((currentCharPos - k) < 0) {
				currentCharPos += alphabet.length();
				newCharPos = (currentCharPos - k);
				
				
			} else {
				newCharPos = (currentCharPos - k) % alphabet.length();
			}
			
			char newChar = alphabet.charAt(newCharPos);
			p += newChar;
			
		}
		
		
		System.out.println(p);
		return p;
		
	}
	
	public static void main(String[] args) {
		Cypher.encrypt("Hey there 123 whawha : hash MAAAAA", 1);
		Cypher.decrypt("IfzAuifsfA234AxibxibA?AibtiANBBBBB", 1);
	}
}
