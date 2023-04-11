
package bookstoree;

public class Node {
   
    private BookStore data;
    private Node next;
    
    public Node(BookStore obj ) { 
        data = obj;
        next =null;
    }

    public BookStore getData() {
        return data;
    }

    public void setData(BookStore data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public String toString() { 
        return data.toString();
    }
            
}
