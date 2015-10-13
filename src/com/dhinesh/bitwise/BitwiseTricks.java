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
		int remainder = 0;
		StringBuilder builder = new StringBuilder();
		int aIndex = a.length()-1, bIndex = b.length()-1;
		while( aIndex >= 0 && bIndex >= 0) {
			int sum = a.charAt(aIndex)-48 + b.charAt(bIndex)-48 + remainder;
			builder.append(sum%base);
			remainder = sum / base;
			aIndex--;
			bIndex--;
		}
		while( aIndex >= 0) {
				int sum = a.charAt(aIndex)-48 + remainder;
				builder.append(sum%base);
				remainder = sum / base;
				aIndex--;
		}
		while( bIndex >= 0) {
				int sum = b.charAt(bIndex)-48 + remainder;
				builder.append(sum%base);
				remainder = sum / base;
				bIndex--;
		}
		
		builder.append(remainder);
		
		return builder.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(countBits(Integer.MAX_VALUE));
		System.out.println(multiplyby7(5));
		System.out.println(baseAddition("123", "213", 4));
	}
}
