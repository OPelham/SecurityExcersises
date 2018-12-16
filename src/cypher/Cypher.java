package cypher;

public class Cypher {
	static char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	public static String encrypt(String p, int k) {
		
		String c = "";
		
		for (int i=0; i< p.length(); i++) {
			char currentChar = p.charAt(i);
			int currentCharPos = -1;
			for (int j=0; j<alpha.length; j++) {
				if (currentChar == alpha[j]) {
					currentCharPos = j;
					System.out.println("found match");
				}
			}
			int newCharPos = (currentCharPos + k) % 25;
			char newChar = alpha[newCharPos];
			c += newChar;
		}
		
		return c;
	}
	
	public String decrypt(String c, int k) {
		
		String p = "";
		
		
		return c;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Cypher.encrypt("abc", 1));
	}
}
