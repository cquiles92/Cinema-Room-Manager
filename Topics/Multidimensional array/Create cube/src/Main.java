
class ArrayOperations {
    public static int[][][] createCube() {
        final int length = 3;
        final int width = 3;
        final int height = 3;
        int[][][] cube = new int[length][width][height];

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    cube[i][j][k] = count++;
                }
            }
            count = 0;
        }
        return cube;
    }
}