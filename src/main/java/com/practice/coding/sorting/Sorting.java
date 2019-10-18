package com.practice.coding.sorting;

import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		int a[] = { 5, 1, 6, 2, 4, 3 };

		bubbleSort(a);
		System.out.println("Bubble Sort: " + Arrays.toString(a));

		int b[] = { 5, 1, 6, 2, 4, 3 };
		insertionSort(b);
		System.out.println("Insertion Sort: " + Arrays.toString(b));

		int c[] = { 5, 1, 6, 2, 4, 3 };
		selectionSort(c);
		System.out.println("Selection Sort: " + Arrays.toString(c));
	}

	public static void bubbleSort(int a[]) {
		int i, j, temp;
		for (i = 0; i < 6; i++) {
			boolean flag = false; // taking a flag variable
			//-i because we want to skip sorted path to be looped
			for (j = 0; j < 6 - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = true; // setting flag as true, if swapping occurs
				}
			}
			if (!flag) // breaking out of for loop if no swapping takes place
			{
				break;
			}
		}
	}

	public static void insertionSort(int a[]) {
		int i, j, key;
		for (i = 1; i < 6; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && key < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public static void selectionSort(int a[]) {

		int i, j, min, temp;
		for (i = 0; i < a.length - 1; i++) {
			min = i; // setting min as i
			for (j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) // if element at j is less than element at  min position
				{
					min = j; // then set min as j
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
}
