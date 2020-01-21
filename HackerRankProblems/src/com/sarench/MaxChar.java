package com.sarench;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class Result {

	/*
	 * Complete the 'maximumOccurringCharacter' function below.
	 *
	 * The function is expected to return a CHARACTER. The function accepts STRING
	 * text as parameter.
	 */

	public static char maximumOccurringCharacter(String text) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		char maxChar = ' ';
		if (text != null && text.length() > 0) {
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				Integer count = map.get(c);
				if (count == null) {
					map.put(c, 1);
				} else {
					map.put(c, count + 1);
				}
			}
			
			
			int maxTemp=0;
			char tempChar;
			for(Map.Entry<Character, Integer> e :  map.entrySet()) {
				tempChar = e.getKey();
				if(e.getValue()>maxTemp) {
					maxTemp = e.getValue();
					maxChar=tempChar;
				}
			}
			
		}
		
		return maxChar;

	}
	
	

}

public class MaxChar {
	public static void main(String[] args) throws IOException {
		/*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String text = bufferedReader.readLine();
*/
		System.out.println(Result.maximumOccurringCharacter("assrrsar"));

		/*bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();*/
	}
}
