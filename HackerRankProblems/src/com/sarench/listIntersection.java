package com.sarench;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Result1 {

	/*
	 * Complete the 'getIntersection' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY groupA 2. INTEGER_ARRAY groupB
	 */

	public static List<Integer> getIntersection(List<Integer> groupA, List<Integer> groupB) {

		Set<Integer> aSet = new LinkedHashSet<Integer>(groupA.size());
		for (Integer x : groupA)
			aSet.add(x);

		Set<Integer> bSet = new LinkedHashSet<Integer>(groupB.size());
		for (Integer x : groupB)
			bSet.add(x);
		
		List<Integer> aList = new ArrayList<Integer>();
		for(int i : bSet) {
			if(aSet.contains(i)) {
				aList.add(i);
			}
		}
		
		return aList;
	}

}

public class listIntersection {
	public static void main(String[] args) throws IOException {

		List<Integer> groupA = Arrays.asList(1, 2, 2, 3, 4, 5);
		List<Integer> groupB = Arrays.asList(2, 3, 3, 6, 7);

		List<Integer> s = Result1.getIntersection(groupA, groupB);

	}
}
