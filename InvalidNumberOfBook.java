
package bookstoree;

public class InvalidNumberOfBook extends RuntimeException{
    
    public InvalidNumberOfBook() {
        super("Invalid Number of Books , the number should be [1,5000] ");
    }
    public InvalidNumberOfBook(String msg) {
        super(msg);
    }
}
