package training;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Kerlek irj be egy muveletsort!");

		String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println(line);
		String[] oparetions = line.split("[0-9]+");
		System.out.println(Arrays.toString(oparetions));
		String[] numbers = line.split("[" + Pattern.quote("+-*/") + "]");
		System.out.println(Arrays.toString(numbers));

		int[] numbersConverted = convert(numbers);

		System.out.println(Arrays.toString(numbersConverted));

		int result = calculate(oparetions, numbersConverted);
		System.out.println(result);
	}

	private static int[] convert(String[] numbers) {
		int[] numbersConverted = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbersConverted[i] = Integer.valueOf(numbers[i]);
		}
		return numbersConverted;
	}

	private static int calculate(String[] oparetions, int[] numbers) {
		
		int length = oparetions.length;
		int index=1;
		while( index<length){
			if ("*".equals(oparetions[index])){
				numbers[index-1]= numbers[index-1]*numbers[index];
				remove(numbers, length, index);
				
				remove(oparetions, length, index);
				
				length--;
			}else 	if ("/".equals(oparetions[index])){
				numbers[index-1]= numbers[index-1]/numbers[index];
				remove(numbers, length, index);
				
				remove(oparetions, length, index);
				
				
				length--;
			}else {
			    index++;
			}
			
		}
		index =1;
			while( index<length){
				if ("+".equals(oparetions[index])){
					numbers[index-1]= numbers[index-1]+numbers[index];
					remove(numbers, length, index);
					
					remove(oparetions, length, index);
				
					length--;
				}else 	if ("-".equals(oparetions[index])){
					numbers[index-1]= numbers[index-1]-numbers[index];
					remove(numbers, length, index);
					
					remove(oparetions, length, index);
				
					length--;
				}else {
				    index++;
				}
		}	
		
	
		return numbers[0];
	}

	private static void remove(int[] numbers, int length, int index) {
		for(int j=index;j<length -1; j++){
			numbers[j]= numbers[j+1];
			
		}
	}
		private static void remove(String[] numbers, int length, int index) {
			for(int j=index;j<length -1; j++){
				numbers[j]= numbers[j+1];
				
			}
	}
}
