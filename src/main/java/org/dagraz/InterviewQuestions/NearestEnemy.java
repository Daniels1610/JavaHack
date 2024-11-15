package org.dagraz.InterviewQuestions;

/* NEAREST ENEMY
Haga que la función ArrayChallenge(arr) tome el arreglo de números almacenados en arr y
desde la posición en el arreglo donde está un 1, devuelva la cantidad de espacios hacia
la izquierda o hacia la derecha que debe moverse para alcanzar al enemigo más cercano,
los enemigos estarán representados por el número 2. Por ejemplo: si arr es [0, 0, 1, 0,
0, 2, 0, 2] entonces sus programa debería devolver 3 porque el enemigo más cercano (2)
está a 3 espacios del 1. El arreglo puede contener múltiples 0 y 2, pero solo un 1. Es
posible que no contenga ningún 2 en absoluto, donde en ese caso su programa debería de
volver un 0.

EJEMPLOS:
Input: {1, 0, 0, 0, 2, 2, 2}
Output: 4

Input: {2, 0, 0, 0, 2, 2, 1, 0}
Output: 4 */

public class NearestEnemy {

    public int nearest_enemy(int[] arr, int n) {
        int ally_idx = 0, lenemy_idx = 0, renemy_idx = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {ally_idx = i; break;}
            else if (arr[i] == 2) {lenemy_idx = i;}
        }

        for (int i = ally_idx; i < n; i++) {
            if (arr[i] == 2) {renemy_idx = i;}
        }

        return Math.min(Math.abs(lenemy_idx - ally_idx), Math.abs(renemy_idx - ally_idx));
    }

    public static void main(String[] args) {
        NearestEnemy s = new NearestEnemy();
        int[] A = {2, 0, 1, 0, 0, 2, 0, 2};
        System.out.println(s.nearest_enemy(A, A.length));
    }
}
