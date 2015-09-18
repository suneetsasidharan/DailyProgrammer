/**
 * 
 */

/**
 * @author Suneet
 *
 */
public class SieveofEratosthenes {

	public static void main(String[] args) {
		numbers[] inputArray = new numbers[101];
		for(int i=0; i < 101; i++){
			inputArray[i] = new numbers(i, false, false);			
		}

		for (numbers n:inputArray){
			if(n.num == 1 || n.num == 0){
				System.out.println("0/1 is neither Prime nor Composite");
			}
			else if(n.num == 2){
				n.isPrime = true;
			}
			else if(n.num < 101){
				if(n.CheckPrime(n.num)){
					n.isPrime = true;
					int multiplier = 2;
					while(multiplier*n.num < inputArray.length){
						inputArray[multiplier*n.num].isCrossed = true;
						multiplier++;
					}
				}
			}
		}
		
		for (numbers n:inputArray){
			if(n.isPrime){
				System.out.println(n.num);
			}			
		}
	}

	static public class numbers{
		int num;
		boolean isPrime = false;
		boolean isCrossed = false;

		public numbers(int numb, boolean primeFlag, boolean crossedFlag){
			num = numb;
			isPrime = primeFlag;
			isCrossed = crossedFlag;
		}

		public boolean CheckPrime(int n) {
			int temp = n-1;
			while(temp>=2){
				if(n%temp == 0){
					return false;
				}
				temp--;
			}
			return true;
		}
	}
}

