package seminar4;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int row, int col)
    {
        super(message + " in row " + row + " colomn " + col);
    }
}
