package cypher;

public class Client {
	
	static String c = "IfzAuifsfAipxAbsfAzpv.";

	public static void main(String[] args) {
		System.out.println(Cypher.encrypt("Hey there how are you?", 1));
		Cypher.decrypt("IfzAuifsfA!@#AxibxibA/AibtiANBBBBB", 1);
		
		System.out.println(Cypher.decrypt(c, (Cryptanalysis.bruteForce(c))));

	}

}
