import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int[][] result = rotateRight(input());
        printArray(result);
    }

    public static int[][] input() {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");
            int numOfRows = Integer.parseInt(input[0]);
            int numOfElements = Integer.parseInt(input[1]);

            int[][] array = new int[numOfRows][numOfElements];
            for (int i = 0; i < numOfRows; i++) {
                String[] parser = scanner.nextLine().split(" ");
                for (int j = 0; j < numOfElements; j++) {
                    array[i][j] = Integer.valueOf(parser[j]);
                }
            }
            return array;
        }
    }

    public static int[][] rotateRight(int[][] arr) {
        int[][] result = new int[arr[0].length][arr.length];
        int arrX = 0;
        for (int i = 0; i < arr[0].length; i++) {
            int arrY = arr.length - 1;
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[arrY--][arrX];
            }
            arrX++;
        }
        return result;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < arr[i].length; j++) {
                stringBuilder.append(arr[i][j]).append(" ");
            }
            System.out.println(stringBuilder);
        }
    }
}
