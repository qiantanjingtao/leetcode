import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Point {
	int i;
	int j;

	public Point(int i, int j){
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		return i + j;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Point person = (Point) obj;
		return i == person.i && j == person.j;
	}
}

public class ClockPrint {
	Map<Point, Integer> m = new HashMap<>();
	ArrayList a = new ArrayList();
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		if(matrix.length == 0) {
			a = null;
			return a;
		}
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		for (int i = 0; i < rowLength && colLength - i - 1>=0; i++) {
			right(matrix, i);
			down(matrix, colLength - i - 1);
			left(matrix, rowLength - i - 1);
			up(matrix, rowLength - i - 1);
		}
		System.out.print(a);
		return a;
	}


	public ArrayList<Integer> right(int[][] matrix, int row) {
		int length = matrix[0].length;
		for (int i = 0; i < length; i++) {
			Point p = new Point(row, i);
			if (m.containsKey(p)) {
				continue;
			} else {
				m.put(p, 1);
				a.add(matrix[row][i]);
			}
		}
		return a;
	}

	public ArrayList<Integer> down(int[][] matrix, int col) {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			Point p = new Point(i, col);
			if (m.containsKey(p)) {
				continue;
			} else {
				m.put(p, 1);
				a.add(matrix[i][col]);
			}
		}
		return a;
	}

	public ArrayList<Integer> left(int[][] matrix, int row) {
		int length = matrix[0].length;
		for (int i = length - 1; i >= 0; i--) {
			Point p = new Point(row, i);
			if (m.containsKey(p)) {
				continue;
			} else {
				m.put(p, 1);
				a.add(matrix[row][i]);
			}
		}
		return a;
	}

	public ArrayList<Integer> up(int[][] matrix, int col) {
		int length = matrix[0].length;
		for (int i = length - 1; i >= 0; i--) {
			Point p = new Point(i, col);
			if (m.containsKey(p)) {
				continue;
			} else {
				m.put(p, 1);
				a.add(matrix[i][col]);
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[5][2];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[1][0] = 3;
		matrix[1][1] = 4;
		matrix[2][0] = 5;
		matrix[2][1] = 6;
		matrix[3][0] = 7;
		matrix[3][1] = 8;
		matrix[4][0] = 9;
		matrix[4][1] = 10;
		ClockPrint cp = new ClockPrint();
		cp.printMatrix(matrix);
	}
}

