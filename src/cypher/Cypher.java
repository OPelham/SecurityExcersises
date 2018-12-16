package cypher;

public class Cypher {
//	static char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static String alphabet = "abcdefghijklmnopqrstuvwxyz"; // ABCDEFGHIJKLMNOPQRSTUVQXYZ

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
			int newCharPos = (currentCharPos + k) % 26;
			char newChar = alphabet.charAt(newCharPos);
			c += newChar;
		}
		
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
					System.out.println("found match");
				}
			}
			
			int newCharPos = -1;
			if((currentCharPos - k) < 0) {
				currentCharPos += 26;
				newCharPos = (currentCharPos - k);
				
				
			} else {
				newCharPos = (currentCharPos - k) % 26;
			}
			
			char newChar = alphabet.charAt(newCharPos);
			p += newChar;
			
		}
		
		
		
		return p;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Cypher.encrypt("hello there", 1));
		System.out.println(Cypher.decrypt("ifmmpauifsf", 1));
	}
}
