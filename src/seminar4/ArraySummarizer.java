package seminar4;

public class ArraySummarizer {

    private final String[][] arr;

    public ArraySummarizer(String[][] arr, int size) throws MyArraySizeException {
        this.arr = arr;
        check(size);
    }

    private void check(int size) throws MyArraySizeException {
        if (arr.length != size || arr[0].length != size) {
            throw new MyArraySizeException("Wrong size of array!");
        }
    }

    public int sum() throws MyArrayDataException {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    res += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Data error", i, j);
                }
            }
        }
        return res;
    }

}
