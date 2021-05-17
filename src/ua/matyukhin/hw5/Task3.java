package ua.matyukhin.hw5;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] numbers = new int[10][10];
        fillArray(numbers);
//        System.out.println(Arrays.deepToString(numbers).replace("], ", "]\n"));
//        System.out.println(" ");
//        System.out.println(Arrays.deepToString(arraySwap(numbers)).replace("], ", "]\n"));
//        System.out.println(" ");
//        System.out.println(" ");
//        System.out.println(" ");
        System.out.println(Arrays.deepToString(numbers).replace("], ", "]\n"));
        System.out.println(" ");
        System.out.println(Arrays.deepToString(arraySwap(numbers)).replace("], ", "]\n"));
        System.out.println(" ");
        System.out.println(Arrays.deepToString(numbers).replace("], ", "]\n"));
    }

    private static int[][] arraySwap(int[][] numbers) {
        int temp = 0;
        int[][] workArray = new int[numbers.length][numbers.length];
        fillArray(workArray);
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < workArray.length; j++) {
                if (j >= i) {
                    temp = workArray[i][j];
                    workArray[i][j] = workArray[j][i];
                    workArray[j][i] = temp;
                }
            }
        }
        return workArray;
    }

    //Проще отслеживать работоспособность
    private static void fillArray(int[][] numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = counter;
                counter++;
            }
        }
    }
//    private static void fillArrayRandom(int[][] numbers) {
//        Random random = new Random();
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers[i].length; j++) {
//                int randomLength = random.nextInt(9);
//                numbers[i][j] = randomLength;
//            }
//        }
//    }
}
