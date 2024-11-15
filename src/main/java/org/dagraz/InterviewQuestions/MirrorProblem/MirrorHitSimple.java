package org.dagraz.InterviewQuestions.MirrorProblem;

public class MirrorHitSimple {
    public int solve(int[][] mirror) {
        // Directions: TOP = 0, RIGHT = 1, BOTTOM = 2, LEFT = 3
        int direction = 0;  // Starting direction (TOP)
        int x = 0, y = 0;  // Starting position (top-left corner)
        int hits = 0;      // Counter for mirror hits

        // Arrays for movement in each direction
        int[] dx = {-1, 0, 1, 0};  // x movement for [TOP, RIGHT, BOTTOM, LEFT]
        int[] dy = {0, 1, 0, -1};  // y movement for [TOP, RIGHT, BOTTOM, LEFT]

        // Continue while laser is within grid bounds
        while (isInBounds(x, y, mirror)) {
            // If we hit a mirror, count it and change direction
            if (mirror[x][y] > 0) {
                hits++;
                direction = getNewDirection(mirror[x][y], direction);
            }

            // Move laser in current direction
            x += dx[direction];
            y += dy[direction];
        }

        return hits;
    }

    // Check if position is within grid bounds
    private boolean isInBounds(int x, int y, int[][] mirror) {
        return x >= 0 && x < mirror.length && y >= 0 && y < mirror[0].length;
    }

    // Get new direction after hitting a mirror
    private int getNewDirection(int mirrorType, int currentDir) {
        // Mirror type 1: /
        // Mirror type 2: \

        if (mirrorType == 1) {  // For / mirror
            switch (currentDir) {
                case 0 -> {return 1;}  // TOP -> RIGHT
                case 1 -> {return 0;}  // RIGHT -> TOP
                case 2 -> {return 3;}  // BOTTOM -> LEFT
                case 3 -> {return 2;}  // LEFT -> BOTTOM
            }
        }
        else if (mirrorType == 2) {  // For \ mirror
            switch (currentDir) {
                case 0 -> {return 3;}  // TOP -> LEFT
                case 1 -> {return 2;}  // RIGHT -> BOTTOM
                case 2 -> {return 1;}  // BOTTOM -> RIGHT
                case 3 -> {return 0;}  // LEFT -> TOP
            }
        }
        return currentDir;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] mirror = {
                {0, 2, 0},
                {1, 0, 0},
                {0, 0, 1}
        };

        MirrorHitSimple solver = new MirrorHitSimple();
        System.out.println("Number of mirror hits: " + solver.solve(mirror));
    }
}