package com.practice.coding.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Solution2 {

	private static int[] xMoves = { 0, 1, 0, -1 };
	private static int[] yMoves = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Solution2 landScappingProblem = new Solution2();

		// List<List<Integer>> field = Arrays.asList(Arrays.asList(1, 1, 0, 2),
		// Arrays.asList(3, 1, 1, 1));
		// List<List<Integer>> path = landScappingProblem.path2WithRoute(field,
		// Arrays.asList(0, 0), Arrays.asList(0, 3), 2, 4);
		// List<List<Integer>> path2 = landScappingProblem.path2WithRoute(field,
		// Arrays.asList(0, 3), Arrays.asList(1, 0), 2, 4);

		// List<List<Integer>> field = Arrays.asList(Arrays.asList(1, 0),
		// Arrays.asList(3, 2));
		// List<List<Integer>> path = landScappingProblem.path(field,
		// Arrays.asList(0, 0), Arrays.asList(1, 1), 2, 2);

		// System.out.println(path);
		// System.out.println(path2);

		List<List<Integer>> field2 = Arrays.asList(Arrays.asList(1, 1, 0, 2), 
												   Arrays.asList(3, 1, 1, 1));

		// System.out.println(landScappingProblem.path2WithRoute(field2,
		// Arrays.asList(0,0), Arrays.asList(0, 3), 6, 6));
		// System.out.println(landScappingProblem.path2WithRoute(field2,
		// Arrays.asList(0,3), Arrays.asList(3, 4), 6, 6));
		// System.out.println(landScappingProblem.path2WithRoute(field2,
		// Arrays.asList(3,4), Arrays.asList(5, 0), 6, 6));

		System.out.println(landScappingProblem.levelFieldTime(2, 4, field2));

	}

	int path(List<List<Integer>> field, List<Integer> sourcePoint, List<Integer> destinationPoint, int tolRows,
			int totColumns) {
		List<List<Boolean>> visitedList = visitedList(field);

		List<List<Integer>> distance = new ArrayList<>();
		for (int i = 0; i < tolRows; i++) {
			Integer temp[] = new Integer[totColumns];
			for (int j = 0; j < temp.length; j++) {
				temp[j] = 0;
			}
			distance.add(Arrays.asList(temp));
		}

		List<List<Integer>> result = new ArrayList<>();

		int minDistance = Integer.MAX_VALUE;

		int destinationValue = getValue(field, destinationPoint);

		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(sourcePoint.get(0), sourcePoint.get(1)));
		visitedList.get(sourcePoint.get(0)).set(sourcePoint.get(1), Boolean.TRUE);

		while (!queue.isEmpty()) {
			List<Integer> pointInQueue = queue.poll();
			int distanceOfParent = getValue(distance, pointInQueue);

			if (getValue(field, pointInQueue) == destinationValue) {
				result.add(pointInQueue);
				field.get(pointInQueue.get(0)).set(pointInQueue.get(1), 1);
				minDistance = distanceOfParent + destinationValue;
				System.out.println(minDistance);
				return minDistance;
			}

			result.add(pointInQueue);

			int x = pointInQueue.get(0);
			int y = pointInQueue.get(1);

			for (int i = 0; i < 4; i++) {
				int newX = x + xMoves[i];
				int newY = y + yMoves[i];

				if ((newX >= 0 && newX < tolRows) && (newY >= 0 && newY < totColumns)) {

					int newValue = field.get(newX).get(newY);
					if ((newValue == 1 || newValue == destinationValue)
							&& visitedList.get(newX).get(newY).equals(Boolean.FALSE)) {
						queue.add(Arrays.asList(newX, newY));
						distance.get(newX).set(newY, distanceOfParent + 1);
						visitedList.get(newX).set(newY, Boolean.TRUE);
					}
				}

			}
		}
		return -1;
	}

	int levelFieldTime(int numOfRows, int numOfCOlumns, List<List<Integer>> field) {
		int time = 0;
		Map<Integer, List<Integer>> treesPositions = treesPositionsMap(field);
		List<Integer> source = Arrays.asList(0, 0);
		for (Map.Entry<Integer, List<Integer>> entry : treesPositions.entrySet()) {
			time += path(field, source, entry.getValue(), numOfRows, numOfCOlumns);
			if (time < 0) {
				return -1;
			}
			source = entry.getValue();
		}

		return time;
	}

	private Map<Integer, List<Integer>> treesPositionsMap(List<List<Integer>> field) {
		Map<Integer, List<Integer>> treesPositionMap = new TreeMap<>();

		for (int i = 0; i < field.size(); i++) {
			List<Integer> innerList = field.get(i);
			for (int j = 0; j < innerList.size(); j++) {
				int fieldValue = field.get(i).get(j);
				if (fieldValue > 1) {
					treesPositionMap.put(fieldValue, Arrays.asList(i, j));
				}
			}
		}

		return treesPositionMap;
	}

	private int getValue(List<List<Integer>> field, List<Integer> point) {
		int x = point.get(0).intValue();
		int y = point.get(1).intValue();

		return field.get(x).get(y);
	}

	private List<List<Boolean>> visitedList(List<List<Integer>> field) {
		List<List<Boolean>> visitedList = new ArrayList<>();
		for (List<Integer> innerList : field) {
			List<Boolean> booleanInnerList = new ArrayList<>();
			for (int i = 0; i < innerList.size(); i++) {
				booleanInnerList.add(Boolean.FALSE);
			}
			visitedList.add(booleanInnerList);
		}
		return visitedList;
	}

}
