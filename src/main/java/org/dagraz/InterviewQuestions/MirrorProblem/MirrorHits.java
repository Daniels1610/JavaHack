package org.dagraz.InterviewQuestions.MirrorProblem;

/* A square room has multiple mirrors pointing in different directions,
   a laser is fired and hits some mirrors before hitting a wall. There
   are two different directions a mirror can face. The problem will provide
   the information in a matrix of size N x N, the matrix will be of integers
   from 0 to 2, where 0 is an empty space and the number 1 and 2 are mirrors
   facing different directions, the laser will start in the position (0, 0),
   there will never be a mirror in that position.

   The answer is the number of times a laser hits a mirror before reaching
   the border of the matrix.

   Mirror position:

        1 /
        2 \

*/

import org.javatuples.Pair;

public class MirrorHits {

    public int get_mirror_hits(int[][] mirror) {
        /* LD1 : Top    (Idx = 0)
           LD2 : Right  (Idx = 1)
           LD3 : Bottom (Idx = 2)
           LD4 : Left   (Idx = 3)
        */

        int hits = 0;                                                       // Mirror hits counter
        int curr_space = 0;                                                 // Current Mirror Space
        int curr_direction = 1;                                             // Current Laser Direction
        int lp_X = 0, lp_Y = 0;                                             // Current Laser Position
        int mdim_X = mirror.length - 1, mdim_Y = mirror[0].length - 1;      // Mirror Dimensions


        // Checks if laser position is within mirror boundaries
        while (isInBounds(lp_X, lp_Y, mdim_X, mdim_Y)) {
            curr_space = mirror[lp_X][lp_Y];
            System.out.printf("LASER POSITION: {%d, %d}", lp_X, lp_Y); System.out.println();
            System.out.printf("CURRENT SPACE: {%d}", curr_space); System.out.println();
            if (curr_space > 0) {
                hits++;
                // Update laser direction
                curr_direction = update_direction(curr_space, curr_direction);;
            }

            // Update laser position
            Pair<Integer, Integer> updated_lposition = update_lp(curr_direction, lp_X, lp_Y);
            lp_X = updated_lposition.getValue0(); lp_Y = updated_lposition.getValue1();

        }
        return hits;
    }

    // Check if position is within grid bounds
    private boolean isInBounds(int x, int y, int mx, int my) {
        return x > -1 && x <= mx && y > -1 && y <= my;
    }


    // Update laser position
    private Pair<Integer,Integer> update_lp(int cd, int X, int Y) {
        if (cd == 0) {X--;}
        else if (cd == 1) {Y++;}
        else if (cd == 2) {X++;}
        else {Y--;}
        return new Pair<>(X,Y);
    }

    // Update laser direction
    private int update_direction(int mirror_type, int cd) {
        int com_dir = 0;
        if (mirror_type == 2) {
            if (cd == 0) {com_dir = 3;}
            else if (cd == 1)  {com_dir = 2;}
            else if (cd == 2) {com_dir = 1;}
        }
        else if (mirror_type == 1) {
            if (cd == 0) {com_dir = 1;}
            else if (cd == 2) {com_dir = 3;}
            else if (cd == 3) {com_dir = 2;}
        }

        return com_dir;
    }



    public static void main(String[] args) {
        MirrorHits s = new MirrorHits();
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

        System.out.println(s.get_mirror_hits(m1));

    }
}
