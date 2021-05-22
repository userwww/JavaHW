package ua.matyukhin.modul1;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        System.out.println(horseAdventure(chessBoard));
    }

    private static boolean horseAdventure(int[][] cords) {
        int[][] navigationAllow = horseNavMesh(cords); //Заполняем все возможные эллементы куда конь может пойти.
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите координыты куда конь пойдет двухзначным числом: ");
        int secondInput = scan.nextInt();
        while (secondInput % 10 > 7 || secondInput > 78 || secondInput < 0) {
            System.out.println("Лимит не больше 77 и десятая доля не больше 7"); // маразматичная проверка из-за желания принимать координаты
            secondInput = scan.nextInt();                                        //одним числом,типа user friendly
        }
        int x = secondInput / 10;
        int y = secondInput % 10;
        return cords[x][y] == 1;
    }

    public static int[][] horseNavMesh(int[][] cords) { //определяет всевозможные ходы коня с заданой точки
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите координыта коня двухзначным числом: ");
        int firstInput = scan.nextInt();
        while (firstInput % 10 > 7 || firstInput > 78 || firstInput < 0) {
            System.out.println("Лимит не больше 77 и десятая доля не больше 7");
            firstInput = scan.nextInt();
        }
        int x = firstInput / 10;
        int y = firstInput % 10;
        cords[x][y] = 7;  //показывает положение коня на "доске"
        if (x > 1 && y > 0) {           //Индуский код
            cords[x - 2][y - 1] = 1;
        }
        if (x > 0 && y > 1) {
            cords[x - 1][y - 2] = 1;
        }
        if (x > 1 && y <= 6) {
            cords[x - 2][y + 1] = 1;
        }
        if (x > 0 && y <= 5) {
            cords[x - 1][y + 2] = 1;
        }
        if (x <= 6 && y > 1) {
            cords[x + 1][y - 2] = 1;
        }
        if (x <= 5 && y > 0) {
            cords[x + 2][y - 1] = 1;
        }
        if (x <= 6 && y <= 5) {
            cords[x + 1][y + 2] = 1;
        }
        if (x <= 5 && y <= 6) {
            cords[x + 2][y + 1] = 1;
        }
        System.out.println(Arrays.deepToString(cords).replace("],", "]\n"));
        return cords;
    }
}

