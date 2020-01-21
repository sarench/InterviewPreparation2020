package com.sarench;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBracket {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		try {
			int noOfEntries = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < noOfEntries; i++) {

				if (isBalancedString(sc.nextLine())) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
	}

	public static boolean isBalanced(String s) {
		if (s == null || s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (!stack.isEmpty()) {
					char latestOpenP = stack.pop();
					if (latestOpenP == '(' && c != ')') {
						return false;
					} else if (latestOpenP == '{' && c != '}') {
						return false;
					} else if (latestOpenP == '[' && c != ']') {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
	
	public static boolean isBalancedString(String inputStr) {
		if (inputStr == null || inputStr.length() % 2 != 0)
			return false;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < inputStr.length(); i++) {
			String oneChar = inputStr.substring(i, i + 1);
			if (oneChar == "(" || oneChar == "{" || oneChar == "[") {
				stack.push(oneChar);
			} else if (oneChar == ")" || oneChar == "}" || oneChar == "]") {
				if (!stack.isEmpty()) {
					String openBracketRecent = stack.pop();
					if (openBracketRecent == "(" && oneChar != ")") {
						return false;
					} else if (openBracketRecent == "{" && oneChar != "}") {
						return false;
					} else if (openBracketRecent == "[" && oneChar != "]") {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		return /*stack.isEmpty()*/ true;
	}
}
