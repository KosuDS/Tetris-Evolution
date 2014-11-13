package com.mygdx.test;

import java.util.Scanner;

public class InvertBinAlf {
	
	private final static String[] normalAlphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	private final static String[] binAlphabet = {"00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001", "11010"};
	
	private final static String space = "-";
	private final static String dot = ".";
	
	private int findIndex(String[] array, String value){
		for (int index = 0; index < array.length; index++) {
			if (array[index].equals(value)) return index;
		}
		
		return -1;
	}
	
	private String normalToBin(String source){
		String[] splitSource = source.split("");

		String result = "";
		for (int index = 0; index < splitSource.length; index++) {
			String sign = splitSource[index];
			
			if (sign.equals(" ")){
				result += space;
			
			} else {
				result += binAlphabet[findIndex(normalAlphabet, sign)];
				
				if (index < splitSource.length - 1 && index + 1 < splitSource.length && !splitSource[index + 1].equals(space)) result += dot;;
			}
			
		}
		
		return result;
	}
	
	private String binToNormal(String source){
		String[] splitSource = source.split(space);
		
		String result = "";
		for (int index = 0; index < splitSource.length; index++) {
			
			if (splitSource[index].contains(dot)){
				String[] splitWords = splitSource[index].split("\\" + dot);
				
				for (int indexSplitWords = 0; indexSplitWords < splitWords.length; indexSplitWords++) {
					String sign = splitWords[index];
					
					result += normalAlphabet[findIndex(binAlphabet, splitSource[index])];
				}
				
			} else {
				String splitWord = splitSource[index];
				
				result += normalAlphabet[findIndex(binAlphabet, splitSource[index])];
			}

			result += " ";
		}
		
		return result;
	}
	
	public InvertBinAlf(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Jeœli chcesz coœ zakodowaæ wybierz 1.");
		System.out.println("Jeœli chcesz coœ zakodowaæ wybierz 2.");
		
		String select = scanner.nextLine();
		
		switch (Integer.valueOf(select)){
			case 1: 
				String sourceNormal = scanner.nextLine();
				System.out.println(normalToBin(sourceNormal));
				
				break;
				
			case 2: 
				String sourceBin = scanner.nextLine();
				System.out.println(binToNormal(sourceBin));
				
				break;
				
		}
	}
	
	public static void main(String[] args){
		new InvertBinAlf();
	}
}
