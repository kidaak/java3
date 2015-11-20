package service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
	//
	// public static Integer[] getLottozahlen(int anz, int max){
	// List<Integer> numbers = new ArrayList<>();
	// Integer[] result = new Integer[anz];
	// int counter =0;
	//
	// Random r = new Random();
	// while(numbers.size()< anz){
	// int rnd = r.nextInt(max)+1;
	// if(!numbers.contains(rnd)){
	// numbers.add(rnd);
	// result[counter]= rnd;
	// counter++;
	// }
	// }
	//
	// return result;
	//
	// }

//	public static Integer[] getLottozahlen(int anz, int max) {
//		Map<Integer, Integer> numbers = new HashMap<>();
//		Integer[] result = new Integer[anz];
//		
//		Random r = new Random();
//		while (numbers.size() < anz) {
//			int rnd = r.nextInt(max) + 1;
//			numbers.put(rnd, rnd);
//			
//		}
//		int counter = 0;
//		for (Integer integer : numbers.values()) {
//			result[counter]= integer;
//			counter++;
//		}
//		return result;
//	}

	public  Integer[] getLottozahlen(int anz, int max) {
		if(anz>max){
			throw new IllegalArgumentException();
		}
		Random r = new Random();
		Set<Integer> zahlen = new HashSet<>();
		while(zahlen.size()<anz){
			zahlen.add(r.nextInt(max)+1);
		}
		return zahlen.toArray(new Integer[anz]);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	//System.out.println(Arrays.toString(getLottozahlen(50, 45)));
	}

}
