package ShellSort;

public class ShellSort {
	public static void main (String[] args) {
		int[] a = new int[] {7, 5, 4, 3, 2, 1};
		for (int i = 0; i < a.length; i ++)
			System.out.print(a[i]);
		shell(a);
		System.out.println();
		for (int i = 0; i < a.length; i ++)
			System.out.print(a[i]);		
	}
	
	public static void shell(int[] a) {
		int increment = a.length / 2;
		while (increment > 0) {
			for (int i = increment; i < a.length; i++) {
				int j = i;
				int temp = a[i];
				while (j >= increment && a[j - increment] > temp) {
					a[j] = a[j - increment];
					j = j - increment;
				}
				a[j] = temp;
			}
			increment = increment / 2;
		}
	}
}
