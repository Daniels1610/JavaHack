package org.dagraz.InterviewQuestions.MirrorProblem;

public class MirrorHitsCyclic {
    // Define directions as constants
    static final int TOP = 1;
    static final int RIGHT = 2;
    static final int BOTTOM = 3;
    static final int LEFT = 4;

    // Arrays to represent movement in each direction (TOP, RIGHT, BOTTOM, LEFT)
    static final int[] dx = {-1, 0, 1, 0};  // x movement for [TOP, RIGHT, BOTTOM, LEFT]
    static final int[] dy = {0, 1, 0, -1};  // y movement for [TOP, RIGHT, BOTTOM, LEFT]

    public int get_mirror_hits(int[][] mirror) {
        int[] laser_directions = {TOP, RIGHT, BOTTOM, LEFT};

        int curr_space = 0;
        int directionIndex = 1;  // Start with RIGHT direction (index 1)
        int lp_X = 0, lp_Y = 0;
        int mdim_X = mirror.length - 1, mdim_Y = mirror[0].length - 1;
        int hits = 0;

        while ((lp_X > -1 && lp_X <= mdim_X) && (lp_Y > -1 && lp_Y <= mdim_Y)) {
            curr_space = mirror[lp_X][lp_Y];
            System.out.printf("LASER POSITION: {%d, %d}%n", lp_X, lp_Y);
            System.out.printf("CURRENT SPACE: {%d}%n", curr_space);

            if (curr_space > 0) {
                hits++;
                // Update direction index based on mirror type
                // directionIndex = update_direction(curr_space, directionIndex);
                directionIndex = update_direction_alternative(curr_space, directionIndex, laser_directions.length);
            }

            // Update position using direction arrays
            lp_X += dx[directionIndex];
            lp_Y += dy[directionIndex];
        }
        return hits;
    }

    // Update direction index based on mirror type
    private int update_direction(int mirror_type, int directionIndex) {
        // Mirror type 1: / mirror
        // Mirror type 2: \ mirror
        if (mirror_type == 1) {
            switch (directionIndex) {
                case 0 -> {return RIGHT;}  // TOP -> RIGHT
                case 1 -> {return TOP;}  // RIGHT -> TOP
                case 2 -> {return LEFT;}  // BOTTOM -> LEFT
                case 3 -> {return BOTTOM;}  // LEFT -> BOTTOM
            }
        } else if (mirror_type == 2) {
            switch (directionIndex) {
                case 0 -> {return LEFT;}  // TOP -> LEFT
                case 1 -> {return BOTTOM;}  // RIGHT -> BOTTOM
                case 2 -> {return RIGHT;}  // BOTTOM -> RIGHT
                case 3 -> {return TOP;}  // LEFT -> TOP
            }
        }
        return directionIndex;
    }

    // Alternative implementation using circular array concept more explicitly
    public int update_direction_alternative(int mirror_type, int currentIndex, int ldn) {
        int newIndex;

        // Mirror type 1: / mirror
        if (mirror_type == 1) {
            if (currentIndex % 2 == 0) {  // TOP or BOTTOM
                newIndex = (currentIndex + 1) % ldn;
            } else {  // RIGHT or LEFT
                newIndex = (currentIndex - 1 + ldn) % ldn;
            }
        }
        // Mirror type 2: \ mirror
        else if (mirror_type == 2) {
            if (currentIndex % 2 == 0) {  // TOP or BOTTOM
                newIndex = (currentIndex + 3) % ldn;
            } else {  // RIGHT or LEFT
                newIndex = (currentIndex + 1) % ldn;
            }
        }
        else {
            newIndex = currentIndex;
        }

        return newIndex;
    }

    public static void main(String[] args) {
        MirrorHitsCyclic s = new MirrorHitsCyclic();

        int[][] m1 = {
                {0,0,2,0,1},
                {0,1,0,0,2},
                {0,2,0,0,2},
                {0,0,2,0,1},
                {0,0,2,0,1},
                {1,0,0,0,0}};

        int[][] m2 = {
                {0,0,0,2},
                {0,1,0,0},
                {0,0,0,1},
                {2,0,0,0}};

        System.out.println(s.get_mirror_hits(m2));

    }
}