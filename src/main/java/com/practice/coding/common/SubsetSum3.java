package com.practice.coding.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SubsetSum3 {
	public int count = 0;

	void solve(int[] d, int sum) {
		int m = 0, n = d.length;
		int[] x = {}; // arrays of 0 or 1 which represents selected or not
						// selected integer in array d
		Deque q = new ArrayDeque(); // create an empty
																// queue for
																// storing array
																// x
		q.add(x);
		System.out.println("Set of " + Arrays.toString(d));

		while (!q.isEmpty()) {
			x = (int[]) q.poll();
			m = x.length; // dequeue the first array x from queue
			int s = sum(d, x); // sum of selected number in array d

			if (s > sum) {
				continue;
			} // bound, if s is more than sum, we dont have to select more
				// integer in array d
			else {
				if (m == n) // finish when determine to select or not select all
							// integer in array d
				{
					if (s == sum) // this is subset of array d which has sum
									// equal to "sum" value
					{
						count += 1;
						print(d, x);
					}
				} else {

					int[] x0 = Arrays.copyOf(x, m + 1);
					int[] x1 = Arrays.copyOf(x, m + 1);
					// create new x array, has one more space than array x
					x0[m] = 0;
					x1[m] = 1;
					// x0 last index represent not selection of integer in array
					// d at index m
					// x1 last index represent selection of integer in array d
					// at index m
					m += 1;

					q.add(x0);
					q.add(x1);
				}
			}
		}
		System.out.println("for sum = " + sum);
	}

	// calculate sum of selected integer in array d
	int sum(int[] d, int[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 1)
				sum += d[i];
		}
		return sum;
	}

	void print(int[] d, int[] x) {
		String s = "";
		System.out.print("Subset " + count + " : [");
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 1)
				s = s.concat(String.valueOf(d[i]) + ",");
		}
		if (s.endsWith(","))
			s = s.substring(0, s.length() - 1);
		System.out.println(s + "]");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		int[] d = {1,2,3,4,5};
		int sum = 5;

		SubsetSum3 s = new SubsetSum3();
		s.solve(d, sum);

	}

}