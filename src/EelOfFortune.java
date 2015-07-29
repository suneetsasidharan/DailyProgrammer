import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* DP I223
 * https://www.reddit.com/r/dailyprogrammer/comments/3ddpms/20150715_challenge_223_intermediate_eel_of_fortune/
 * 
 */

class CensorFilter{
	public boolean IsOffensive(String input, String offense){
		StringBuilder onBoard = new StringBuilder();
		int i =0; 
		int j=0; 
		int k=0;
		
		if(input.isEmpty() || offense.isEmpty()){
			System.out.println("Empty string exception");
			return false;
		}
		
		if(input.equalsIgnoreCase(offense)){
			//System.out.println("True");
			return true;
		}		
		
		while(k<offense.length()){
			if(countOccurence(offense, offense.charAt(k)) != countOccurence(input, offense.charAt(k))){		
				return false;
			}
			k++;
		}
		
		while(i<offense.length() && j<input.length()){
				if(input.charAt(j) == offense.charAt(i)){
					onBoard.append(offense.charAt(i));
					i++;
				}
				j++;							
		}
		
		if (offense.equalsIgnoreCase(onBoard.toString())) {
			//System.out.println("True");
			return true;
			}
		else {
			//System.out.println("False");
			return false;
		}
		//System.out.println(onBoard.toString());
	}
	
	public int countOccurence(String input, char c){
		int count =0;
		for(int i =0; i<input.length(); i++)
			if(input.charAt(i) == c)
				count++;
		return count;
	}
}


public class EelOfFortune {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CensorFilter x = new CensorFilter();
		System.out.println(x.IsOffensive("synchronized", "snond"));
		System.out.println(x.IsOffensive("misfunctioned", "snond"));
		System.out.println(x.IsOffensive("mispronounced", "snond"));
		System.out.println(x.IsOffensive("shotgunned", "snond"));
		System.out.println(x.IsOffensive("snond", "snond"));
		
		//Optional challenge 1
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/Suneet/workspace/DailyProgrammer/src/enable1.txt"));
        String line; 
        String offensiveWord = "rrizi";
        int offenseCount = 0;     
        while((line = br.readLine()) != null) {
        	if(x.IsOffensive(line, offensiveWord)){
        		offenseCount++;
        	}
        }
        System.out.println("Number of occurences of "+offensiveWord+" in dictionary is "+offenseCount);
	}
}