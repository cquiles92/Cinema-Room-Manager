import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int[][] input = createArray();
        int[] location = location(input);
        System.out.println(location[0] + " " + location[1]);
    }

    public static int[][] createArray() {
        int numOfRows;
        int numOfElements;
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");

        numOfRows = Integer.valueOf(dimensions[0]);
        numOfElements = Integer.valueOf(dimensions[1]);
        int[][] array = new int[numOfRows][numOfElements];
        for (int i = 0; i < numOfRows; i++) {
            String[] inputs = scanner.nextLine().split(" ");
            for (int j = 0; j < numOfElements; j++) {
                array[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        return array;
    }

    public static int[] location(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int[] coordinates = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    coordinates[0] = i;
                    coordinates[1] = j;
                }
            }
        }
        return coordinates;
    }
}