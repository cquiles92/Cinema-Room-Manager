
class ArrayOperations {
    public static void printTheThirdRow(int[][] twoDimArray) {
        final int thirdRow = 2;
        for (int i = 0; i < twoDimArray[thirdRow].length; i++) {
            System.out.print(twoDimArray[thirdRow][i] + " ");
        }
    }
}