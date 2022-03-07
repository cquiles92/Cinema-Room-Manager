import java.util.Scanner;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int[] sizeOfCinema = getDimensions();
        int[][] cinema = createArray(sizeOfCinema);
        determineK(cinema);
    }

    public static int[] getDimensions() {
        String[] inputs = SCANNER.nextLine().split(" ");
        return new int[]{Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])};
    }

    public static int[][] createArray(int[] dimensions) {
        int rows = dimensions[0];
        int seats = dimensions[1];
        int[][] cinema = new int[rows][seats];

        for (int i = 0; i < rows; i++) {
            String[] inputs = SCANNER.nextLine().split(" ");
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        return cinema;
    }

    public static void determineK(int[][] array) {
        int k = Integer.parseInt(SCANNER.nextLine());
        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == k) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}