package com.dynamicprogramming;

public class Fibonacci {
	public static int f(int n, int[] a) {
		if (n <= 1) {

			return n;
		}
		if (a[n] != -1) {
			return a[n];
		}

		return a[n] = f(n - 1, a) + f(n - 2, a);
	}
	public static void main(String[] args) {
		int n = 4;

//		int[] a = new int[n + 1];
//		Arrays.fill(a, -1);
//		System.out.println(f(n, a));
		int prev = 0;
		int prev2 = 1;
		for (int i = 2; i <= n; i++) {
			int cur = prev + prev2;
			prev2 = prev;
			prev = cur;
		}
		System.out.println(prev);
	}

}
