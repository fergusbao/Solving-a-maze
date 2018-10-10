public class MyTester {

	public static void main(String[] args) {

		// One of the maze samples
		String inputString = "S#####.....##.#####.####...#.G##...#";
		char[][] maze = new char[6][6];
		int[][] output;

		// Convert the maze into a 2d array
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = inputString.charAt(maze[0].length * i + j);
			}
		}

		// Print the original maze
		System.out.println("\nThis is the original maze:\n");
		for (char[] row: maze) {
			for (char ele: row) {
				System.out.print(ele);
			}
			System.out.println();
		}
		System.out.println();

		// Start to find the mouse
		SolvingAMaze solvingAMaze = new SolvingAMaze(maze);
		output = solvingAMaze.findMouse();

		if (output == null) {
			System.out.println("There is no such path!");
			return;
		}

		// Print the path graphs
		System.out.println("The path is made up of these '+'s in the graph below.\n");
		for (char[] row: maze) {
			for (char ele: row) {
				System.out.print(ele);
			}
			System.out.println();
		}
		System.out.println("\n'+' is the marked positions as the part of the path.");
		System.out.println("'x' is the unmarked positions.\n");

		// Print the path's coordinates
		System.out.println("Here is the coordinates which constitute the path,");
		for (int i = 0; i < output.length-1; i++) {
			if (output[i][0] != -1) {
				System.out.print("(" + output[i][0] + ", " + output[i][1] + ")");
			}

			if (output[i+1][0] != -1) {
				System.out.print("->");
			}
		}
		System.out.println();
	}
}
