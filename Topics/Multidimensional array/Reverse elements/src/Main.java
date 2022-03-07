
class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int left = 0, right = twoDimArray[i].length - 1; left < twoDimArray[i].length / 2; left++, right--) {
                int swap = twoDimArray[i][left];
                twoDimArray[i][left] = twoDimArray[i][right];
                twoDimArray[i][right] = swap;
            }
        }
    }
}