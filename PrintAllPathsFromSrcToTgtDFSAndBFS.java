package depthForSearch_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class DFS_PrintAllPathsFromSrcToDesDirectedOrUnDirected {

	public static List<List<Integer>> dfsPrintAllPathsFromSrcToDesDirectedOrUnDirected(int[][] inputArr, int src,
			int dest) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		List<Integer> currList = new ArrayList<Integer>();

		for (int i = 0; i < inputArr.length; i++) {
			int currSrc = inputArr[i][0];
			int currDest = inputArr[i][1];
			if (!map.containsKey(currSrc)) {
				map.put(currSrc, new HashSet<Integer>());
			}
			map.get(currSrc).add(currDest);

		}
		currList.add(src);
		depthForSearch(map, resultList, currList, src, dest);
		return resultList;

	}

	public static List<Integer> bfsPrintAllPathsFromSrcToDesDirectedOrUnDirected(int[][] intputArr, int src, int dest) {
		/*
		 * NOTE: BFS is guaranteed to give shortest path regardless of the order in the
		 * which input is provided.
		 */

		List<Integer> resultList = new ArrayList<Integer>();
		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		List<Integer> currList = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < intputArr.length; i++) {
			int currSrc = intputArr[i][0];
			int currDest = intputArr[i][1];
			if (!map.containsKey(currSrc)) {
				map.put(currSrc, new HashSet<Integer>());
			}
			map.get(currSrc).add(currDest);
		}
		queue.offer(src);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			HashSet<Integer> adjList = map.get(curr);
			// It's important to check this condition, because we will
			// run into null pointer exception when iterating over adjList
			// of a vertex doesn't have any neighbors.
			if (adjList != null) {
				for (Integer neighbor : adjList) {
					if (!currList.contains(neighbor)) {
						parentMap.put(neighbor, curr);
						/*
						 * This is very important step. We need to stop the execution of traversal code
						 * i.e. both WHILE and FOR should stop immediately as soon as we come across
						 * "dest". Break makes sure FOR loop stops and clearing queue makes sure WHILE
						 * loop stops. If we don't stop WHILE loop then we would keep executing code for
						 * remaining elements in the queue and it's waste of resources and we don't want
						 * that. In addition, we might get incorrect result e.g. we were using BREAK
						 * without clearing queue and that point queue had [4] in it. And, in the next
						 * iteration of WHILE loop parentPath of "2" gets overwritten from 1 to 4. Thus,
						 * we got incorrect result.
						 */
						if (neighbor == dest) {
							queue.clear();
							break;
						}
						currList.add(neighbor);
						queue.offer(neighbor);
					}
				}
			}
		}
		while (parentMap.containsKey(dest)) {
			resultList.add(dest);
			dest = parentMap.get(dest);
		}
		resultList.add(src);
		return resultList;

	}

	public static void depthForSearch(Map<Integer, HashSet<Integer>> map, List<List<Integer>> resultList,
			List<Integer> currList, int src, int dest) {

		if (src == dest) {
			resultList.add(new ArrayList<Integer>(currList));
			return;
		}
		Set<Integer> adjList = map.get(src);
		// It's important to check this condition, because we will
		// run into null pointer exception when iterating over adjList
		// of a vertex doesn't have any neighbors.
		if (adjList != null) {
			for (int neighbor : adjList) {
				if (currList.contains(neighbor)) {
					continue;
				}
				currList.add(neighbor);
				depthForSearch(map, resultList, currList, neighbor, dest);
				currList.remove(currList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[][] inputArr = new int[][] { { 0, 3 }, { 3, 4 }, { 4, 2 }, { 0, 1 }, { 1, 2 } };
		List<List<Integer>> pathLists = dfsPrintAllPathsFromSrcToDesDirectedOrUnDirected(inputArr, 0, 2);
		System.out.println(pathLists);
		List<Integer> resultList = bfsPrintAllPathsFromSrcToDesDirectedOrUnDirected(inputArr, 0, 2);
		Collections.reverse(resultList);
		System.out.println(resultList);
	}

}
