import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(field[i], ".");
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //horizontal line in the middle
                if (i == size / 2) {
                    field[i][j] = "*";
                }
                //vertical line in the center
                if (j == size / 2) {
                    field[i][j] = "*";
                }
                //left diagonal
                if (i == j) {
                    field[i][j] = "*";
                }
                //right diagonal
                if (i == size - 1 - j) {
                    field[i][j] = "*";
                }
            }
        }

        for (String[] array : field) {
            for (String str : array) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}