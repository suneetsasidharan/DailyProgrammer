import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* DP E223
 * https://www.reddit.com/r/dailyprogrammer/comments/3d4fwj/20150713_challenge_223_easy_garland_words/
 */

class Garlandia{
	public int garland(String inputString){
		int degree = 0;
		if (inputString.length() <=0){
			return -1;
		}
		else{
			for(int i=1; i<inputString.length(); i++){				
				if(i==0 && inputString.charAt(0) == inputString.charAt(inputString.length()-1)){
					degree++;
				}				
			else if (inputString.substring(0, i).equalsIgnoreCase(inputString.substring(inputString.length()-i))){
					degree = i;
				}				
			}
			
			return degree;
		}
	}
	
}

public class GarlandWords {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputString = "onion";
		Garlandia x = new Garlandia();		
		System.out.println(x.garland(inputString));
		
		//bonus
		int max = 0;
        List<String> longestGarlands = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Suneet/workspace/CodingPrac/src/enable1.txt"));
        String line;
        while((line = br.readLine()) != null) {
            int i = x.garland(line);
            if(i > max) {
            	longestGarlands.clear();
                max = i;
            }
            if (i == max) {
                longestGarlands.add(line + " - " + i);
            }
        }
        br.close();
        System.out.println("Word(s) with largest degree:");
        for(String b : longestGarlands) {
            System.out.println(b);
        }
		
	}
}
