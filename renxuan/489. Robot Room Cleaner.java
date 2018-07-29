interface Robot {
	// returns true if next cell is open and robot moves into the cell.
	// returns false if next cell is obstacle and robot stays on the current cell. 
	boolean move();

	// Robot will stay on the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees. 
	void turnLeft();
	void turnRight();

	// Clean the current cell.
	void clean();
}

class Solution {
	public void cleanRoom(Robot robot) {
		Set<List<Integer>> visited = new HashSet<>();
		dfs(robot, visited, 0, 0);
	}

	private void dfs(Robot robot, Set<List<Integer>> visited, int row, int col) {
		if(visited.contains(Arrays.asList(row, col))) return;
		robot.clean();
		visited.add(Arrays.asList(row, col));
		if (moveUp(robot)) {
            dfs(robot, visited, row - 1, col);
            moveDown(robot);
        }
        if (moveDown(robot)) {
            dfs(robot, visited, row + 1, col);
            moveUp(robot);
        }
        if (moveLeft(robot)) {
            dfs(robot, visited, row, col - 1);
            moveRight(robot);
        }
        if (moveRight(robot)) {
            dfs(robot, visited, row, col + 1);
            moveLeft(robot);
        }
	}

	boolean moveUp(Robot robot) {
        return robot.move();
    }
    
    boolean moveDown(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        boolean ok = robot.move();
        robot.turnLeft();
        robot.turnLeft();
        return ok;
    }
    
    boolean moveLeft(Robot robot) {
        robot.turnLeft();
        boolean ok = robot.move();
        robot.turnRight();
        return ok;
    }
    
    boolean moveRight(Robot robot) {
        robot.turnRight();
        boolean ok = robot.move();
        robot.turnLeft();
        return ok;
    }
}
