package cypher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Attempts to break Caesar Cipher
 * @author oliver
 *
 */
public class Cryptanalysis {

	//try all possible shifts compare strings to dict
	public static int bruteForce(String cryptoText){
		ArrayList<String> attempts = new ArrayList<>();
		ArrayList<Integer> keys = new ArrayList<>();
		
		for(int i=0; i<Cypher.alphabet.length() ; i++) {
			String attempt = Cypher.decrypt(cryptoText, i);
			
			
			//if over threashold then add to keys
			System.out.println(CheckAPI(attempt));
			if(CheckAPI(attempt)> 0.5) {
				attempts.add(attempt);
				keys.add(i);
				return i;
			}
			
			//insert test here if over threshhold save
			
		}
		
		//api check
		
		
		//manual check
//		for (int i=0; i<attempts.size(); i++) {
//			System.out.println("key: " + keys.get(i) + "| decryption: " + attempts.get(i));
//		}
		
		return -1;
		
	}
	//to check can see how many words are in dictionary
	
	
	//check frequencies of characters and compare to expected frequencies. 
	public static void frequencyAnalysis(String cryptoText) {
		//1. make a map of each alphabet char and its freq
		//2. one with most freq try shift to 'e' or space, if not then try next one?
		ArrayList<Integer> frequecyList = new ArrayList<>();
		//init freqlist size
		for (int i=0; i<Cypher.alphabet.length(); i++) {
			frequecyList.add(0);
		}
		//most common e, 
		//try most common assuming e, if not try next most assumung e etc
		for (int i=0; i<cryptoText.length(); i++) {
			if(cryptoText.charAt(i) == Cypher.alphabet.charAt(i)) {
				frequecyList.set(i, frequecyList.get(i) + 1);
			}
			
			//rank
			
		}
		
		
		
		
	}
	
	public static double CheckAPI(String attempt) {
		//break down to words in an array, pass each into api and collect double of percent correct
		String[] words = attempt.split(" ");
		double matchCount=0;
		for (String word: words) {
			if(checkWord(word) == true) {
				matchCount ++;
			}
			
		}
		
		
		return matchCount/((double)(words.length));
	}
	
	public static boolean checkWord(String word)
    {
         word = word.toLowerCase();
                
         String app_id="7885cef5";
         String app_key="cd5681738ddefffce6127b3ff26802b7";
         try
         {
            URL url = new  URL("https://od-api.oxforddictionaries.com:443/api/v1/entries/en" + "/" + word);       
            HttpsURLConnection urlConnection=(HttpsURLConnection) url.openConnection();            
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);      
            // read the output from the server
            BufferedReader reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line=null;
            if ((line=reader.readLine()) !=null)
                return true;
        }
        catch (Exception e)
        {
            //            Do nothing
        }
        return false;
    }
	
}
