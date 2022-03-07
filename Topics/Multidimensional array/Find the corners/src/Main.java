
class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int[][] corners = new int[2][2];
        corners[0][0] = twoDimArray[0][0];
        corners[0][1] = twoDimArray[0][twoDimArray[0].length - 1];
        corners[1][0] = twoDimArray[twoDimArray.length - 1][0];
        corners[1][1] = twoDimArray[twoDimArray.length - 1][twoDimArray[twoDimArray.length - 1].length - 1];
        for (int[] arr : corners) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
