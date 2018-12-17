package cypher;

public class Client {

	public static void main(String[] args) {
		Cypher.encrypt("Hey there 123 whawha : hash MAAAAA", 1);
		Cypher.decrypt("IfzAuifsfA!@#AxibxibA/AibtiANBBBBB", 1);
		
		Cryptanalysis.bruteForce("IfzAuifsfA!@#AxibxibA/AibtiANBBBBB");

	}

}
