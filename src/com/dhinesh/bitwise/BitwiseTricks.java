package com.dhinesh.bitwise;


public class BitwiseTricks {
	
	private static int[] value = new int[100];
	static {
		for(int i=0; i<100; i++) {
			value[i] = -1;
		}
		for(int i=48; i<58; i++) {
			value[i] = i-48;
		}
		for(int i=65; i<91; i++) {
			value[i] = i-65 + 10;
		}
	}
	public static int countBits(int n) { // alternatively n&(n-1)
		int counter = 0;
		for(counter = 0; n > 0; n >>=1) {
			counter += n&1;
		}
		return counter;
	}
	
	public static int multiplyby7(int n) {
		return (n<<3)-n;
	}
	
	public static String baseAddition(String a, String b, int base) {
		StringBuilder sb = new StringBuilder();
		//To be continued
		return null;
	}

	public static void main(String[] args) {
		System.out.println(countBits(Integer.MAX_VALUE));
		System.out.println(multiplyby7(5));
	}
}
