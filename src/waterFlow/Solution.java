package waterFlow;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	private HashMap<Character,String> pMap;
	private HashSet<String> pSet;
	
	public boolean matchPattern(String pattern, String s) {
		pMap = new HashMap<Character,String>();
		pSet = new HashSet<String>();
		return matchHelper(pattern,0,s,0);
	}
	
	private boolean matchHelper(String pattern, int p_index, String s, int s_index) {
		if (p_index == pattern.length()) {
			if (s_index == s.length())
				return true;
			else
				return false;
		}
		
		if (s_index == s.length())
			return false;
		
		if (pMap.containsKey(pattern.charAt(p_index))) {
			String target = pMap.get(pattern.charAt(p_index));
			if (s_index + target.length() > s.length())
				return false;
			if (!s.substring(s_index, s_index+target.length()).equals(target))
				return false;
			return matchHelper(pattern,p_index+1,s,s_index+target.length());
		} else {
			boolean flag = false;
			for (int i=1;s_index+i<=s.length();i++) {
				String target = s.substring(s_index,s_index+i);
				if (pSet.contains(target))
					continue;
				pMap.put(pattern.charAt(p_index), target);
				pSet.add(target);
				if (matchHelper(pattern,p_index+1,s,s_index+i)) {
					flag = true;
					break;
				}
				pMap.remove(pattern.charAt(p_index));
				pSet.remove(target);
			}
			return flag;
		}
	}
	
	public int findShortestPath(int[][] map, int start_x, int start_y, int dest_x, int dest_y) {
		// bfs
		boolean[][] visited = new boolean[map.length][map[0].length];
		for (int i=0;i<visited.length;i++)
			Arrays.fill(visited[0], false);
		Deque<Point> s = new LinkedList<Point>();
		s.addLast(new Point(start_x,start_y,0));
		while (!s.isEmpty()) {
			Point p = s.removeFirst();
			if (p.x == dest_x && p.y == dest_y)
				return p.depth;
			
			for (int i=0;i<2;i++) {
				for (int j=0;j<2;j++) {
					int multi = 1;
					for (int k=0;k<j;k++)
						multi *= -1;
					int next_row = p.x + i * multi;
					int next_col = p.y + (1-i) * multi;
					if (next_row<0 || next_col<0 || next_row>=map.length || next_col>=map[0].length) 
						continue;
					if (visited[next_row][next_col] || map[next_row][next_col] == 0)
						continue;
					s.addLast(new Point(next_row,next_col,p.depth+1));
				}
			}
		}
		return -1;
	}
	
	class Point {
		int x;
		int y;
		int depth;
		Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	
	public boolean[][] findMontain(int[][] map) {
		boolean[][] pacific = new boolean[map.length][map[0].length];
		for (int i=0;i<pacific.length;i++) {
			Arrays.fill(pacific[i], false);
		}
		for (int i=0;i<pacific.length;i++) 
			mhelper(i,0,map,pacific);
		for (int i=0;i<pacific[0].length;i++)
			mhelper(0,i,map,pacific);
		
		// all points connect to pacific have been labeled
		
		boolean[][] altalantic = new boolean[map.length][map[0].length];
		for (int i=0;i<altalantic.length;i++) {
			Arrays.fill(altalantic[i], false);
		}
		for (int i=0;i<pacific.length;i++) 
			mhelper(i,pacific[0].length-1,map,altalantic);
		for (int i=0;i<pacific[0].length;i++)
			mhelper(pacific.length-1,i,map,altalantic);
		
		for (int i=0;i<pacific.length;i++) {
			for (int j=0;j<pacific.length;j++) {
				pacific[i][j] = pacific[i][j] && altalantic[i][j];
				System.out.print((pacific[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
		return pacific;
	}
	
	private void mhelper(int row, int col, int[][] map, boolean[][] pacific) {
		if (pacific[row][col])
			return;
		pacific[row][col] = true;
		for (int i=0;i<2;i++)
			for (int j=0;j<2;j++) {
				int multi = 1;
				for (int k=0;k<j;k++)
					multi *= -1;
				int next_row = row + i * multi;
				int next_col = col + (1-i) * multi;
				if (next_row < 0 || next_col < 0 || next_row >= map.length || next_col >= map.length
						|| map[next_row][next_col]<map[row][col])
					continue;
				else {
					mhelper(next_row,next_col,map,pacific);
				}
			}
	}
	
	public int binarySearch(int[] a, int target) {
		int left = 0;
		int right = a.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (a[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		} 
		if (a[left] == target)
			return left;
		else if (a[right] == target)
			return right;
		return -1;
	}

	
	public static int[] getMaxOfWindow(int[] a, int size) {
		int[] result = new int[a.length-size+1];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=0;i<size;i++) {
			while (!list.isEmpty() && a[list.getLast()] < a[i])
				list.removeLast();
			list.addLast(i);
		}
		
		for (int i=size;i<=a.length;i++) {
			result[i-size] = a[list.getFirst()];
			if (i == a.length)
				break;
			while (!list.isEmpty() && a[list.getLast()] < a[i])
				list.removeLast();
			list.addLast(i);
			if (list.getFirst() < i-size+1)
				list.removeFirst();
		}
		
		return result;
	}
	
	public static void adjust(int[] a) {
		boolean flag = true;
		for (int i=0;i<a.length-1;i++) {
			if (flag) {
				if (a[i] > a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			} else {
				if (a[i] < a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			flag = !flag;
		}
	}
	
	public static Integer binarySearchClosest(int[] a, int target) {
		if (0 == a.length)
			return null;
		int left = 0;
		int right = a.length - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (target == a[mid])
				return a[mid];
			else if (target < a[mid])
				right = mid;
			else
				left = mid;
		}
		
		if (Math.abs(a[left] - target) < Math.abs(a[right] - target))
			return a[left];
		else
			return a[right];
	}
	
	private static int maxRadius;
	
	public static int getRadius(TreeNode node) {
		maxRadius = 0;
		getHeight(node);
		return maxRadius;
	}
	
	private static int getHeight(TreeNode node) {
		if (null == node)
			return 0;
		int height_left = getHeight(node.left);
		int height_right = getHeight(node.right);
		maxRadius = Math.max(maxRadius, height_left+height_right+1);
		return Math.max(height_left, height_right) + 1;
	}
	
	
	public static int findH(int[] A) {
		if (0 == A.length)
			return 0;
		
		int[] c = new int[A.length+1];
		Arrays.fill(c,0);
		for (int i=0;i<A.length;i++) {
			if (A[i]<0)
				continue;
			else if (A[i]>A.length) 
				c[A.length]++;
			else 
				c[A[i]]++;
		}
		
		int sum=0;
		for (int i=A.length;i>=0;i--) {
			sum += c[i];
			if (i <= sum)
				return i;
		}
		return 0;
	}
	
	public static class Person {
		public int height;
		public int before;
		public Person(int a,int b) {
			height = a;
			before = b;
		}
	}
	
	public static int[] queueUp(int[] A, int[] B) {
		int[] result = new int[A.length];
		Arrays.fill(result, -1);
		
		ArrayList<Person> list = new ArrayList<Person>();
		for (int i=0;i<A.length;i++) {
			list.add(new Person(A[i],B[i]));
		}
		
		Collections.sort(list,new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.height - p2.height;
			}
		});
		
		for (int i=0;i<list.size();i++) {
			//result[list.get(i).before] = list.get(i).height;
			int before = list.get(i).before;
			int height = list.get(i).height;
			int j;
			for (j=0;j<result.length;j++) {
				if (0 == before)
					break;
				if (result[j] == -1)
					before--;
			}
			while (result[j] != -1)
				j++;
			result[j] = height;
			
		}
		return result;
	}
}
