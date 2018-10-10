public class SolvingAMaze {
	private char[][] input;
	private int[][] output;
	private int startX;
	private int startY;

	public SolvingAMaze(char[][] input) {
		if (input != null && input.length != 0) {

			// Set up input and output arrays
			this.input = input;
			output = new int[input.length * input[0].length][2];

			// Initialize all the elements of output array into -1
			for (int i = 0; i < output.length; i++) {
				for (int j = 0; j < output[0].length; j++) {
					output[i][j] = -1;
				}
			}

			// Find the coordinate of start point
			int[] start = findStartPosition();
			if (start != null) {
				startX = start[0];
				startY = start[1];
			}
		}
	}

	// Find the start position
	private int[] findStartPosition() {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i][j] == 'S') {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	// Recursively find the path
	private boolean findPath(int x, int y) {

		// If (x,y outside maze) return false
		if (x < 0 || y < 0 || x > input.length-1 || y > input[0].length-1) {
			return false;
		}

		// If (x,y is goal) return true
		if (input[x][y] == 'G') {
			markPosition(x, y);
			return true;
		}

		// If (x,y not open) return false
		if (input[x][y] == '#') {
			return false;
		}

		if (input[x][y] != '+') {
			// Mark x,y as part of solution pat
			markPosition(x, y);

			// If (findPath(North of x,y) == true) return true
			if (findPath(x, y + 1)) {
				return true;
			}

			// If (findPath(East of x,y) == true) return true
			if (findPath(x + 1, y)) {
				return true;
			}

			// If (findPath(South of x,y) == true) return true
			if (findPath(x, y - 1)) {
				return true;
			}

			// If (findPath(West of x,y) == true) return true
			if (findPath(x - 1, y)) {
				return true;
			}


			// Unmark x,y as part of solution path
			unmarkPosition(x, y);
		}

		return false;
	}

	// Mark the position (x, y) as part of the path
	private void markPosition(int x, int y) {
		if (input[x][y] != 'S' && input[x][y] != 'G') {
			input[x][y] = '+';
		}

		for (int i = 0; i < output.length; i++) {
			if (output[i][0] == -1) {
				output[i][0] = x;
				output[i][1] = y;
				break;
			}
		}
	}

	// Unmark the position (x, y) from the path
	private void unmarkPosition(int x, int y) {
		input[x][y] = 'x';
		try {
			for (int i = 0; i < output.length; i++) {
				if (output[i][0] == -1 && i != 0) {
					output[i - 1][0] = -1;
					output[i - 1][1] = -1;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Start to find the mouse
	protected int[][] findMouse() {
		if (findPath(startX, startY)) {
			return output;
		} else {
			return null;
		}
	}

}
