import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = scanner.nextInt();
        int numberOfElements = scanner.nextInt();
        scanner.nextLine();

        int[][] inputArray = new int[numberOfRows][numberOfElements];
        for (int i = 0; i < numberOfRows; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            for (int j = 0; j < numberOfElements; j++) {
                inputArray[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int columnA = scanner.nextInt();
        int columnB = scanner.nextInt();

        print2DArray(swapColumns(inputArray, columnA, columnB));
    }


    public static int[][] swapColumns(int[][] arr, int pos1, int pos2) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][pos1];
            arr[i][pos1] = arr[i][pos2];
            arr[i][pos2] = temp;
        }
        return arr;
    }

    public static void print2DArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}