package com.practice.coding.sumofcontigous;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DequeMethod {

	// A Dequeue (Double ended queue) based method for printing maixmum element
	// of
	// all subarrays of size k
	static void printMax(int arr[], int n, int k) {
		// Create a Double Ended Queue, Qi that will store indexes of array
		// elements
		// The queue will store indexes of useful elements in every window and
		// it will
		// maintain decreasing order of values from front to rear in Qi, i.e.,
		// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
		Deque<Integer> Qi = new LinkedList<Integer>();

		/* Process first k (or first window) elements of array */
		int i;
		for (i = 0; i < k; ++i) {
			// For very element, the previous smaller elements are useless so
			// remove them from Qi
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
				System.out.println("Removing index of "+arr[Qi.peekLast()]);
				Qi.removeLast(); // Remove from rear
			}

			// Add new element at rear of queue
			Qi.addLast(i);
			System.out.println("Adding index of "+arr[Qi.peekLast()]);
		}
		System.out.println("Elements in Queue");
		Qi.stream().sorted(Collections.reverseOrder()).forEach(j->System.out.print("|"+arr[j]+"|"));
		System.out.println();

		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		for (; i < n; ++i) {
			// The element at the front of the queue is the largest element of
			// previous window, so print it
			System.out.println(arr[Qi.peek()]);

			// Remove the elements which are out of this window
			while ((!Qi.isEmpty()) && Qi.peek() <= i - k) {
				System.out.println("Removing index of First: "+arr[Qi.peekFirst()]);
				Qi.removeFirst();
			}

			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) {
				System.out.println("Removing index of Last: "+arr[Qi.peekLast()]);
				Qi.removeLast();
			}

			// Add current element at the rear of Qi
			Qi.addLast(i);
			System.out.println("Adding index of "+arr[Qi.peekLast()]);
			System.out.println("Elements in Queue");
			Qi.stream().sorted(Collections.reverseOrder()).forEach(j->System.out.print("|"+arr[j]+"|"));
			System.out.println("");

		}
		// Print the maximum element of last window
		System.out.print(arr[Qi.peek()]);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = {5, 7, 3, 2, 6};
		int k = 2;
		printMax(arr, arr.length, k);
	}
}
