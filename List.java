
package bookstoree;

public class List {
    private Node head;
    
    public List() {
        head = null;
    }
    public boolean isEmpty() { 
        return head == null;
    }
    public int size() {
        int cnt = 0 ; 
        if(isEmpty())
            return 0;
        Node current = head;
        while(current!= null) {
            cnt++;
            current = current.getNext();
        }
        return cnt;
    }
    public void insertAtFront(BookStore obj  ) {
        
        Node newNode = new Node(obj);
        newNode.setNext(head);
        head= newNode;
    }
    public void insertAtBack(BookStore obj) { 
        Node newNode = new Node(obj);
        if(isEmpty())
            head = newNode;
        else {
            Node current = head;
            while(current.getNext()!= null)
                current = current.getNext();
            
            current.setNext(newNode);
            
                    
        }
        
        
    }
    
    
    public BookStore removeFromFront() { 
       
        if(isEmpty())
            return null;
        
        Node current = head;
        head= head.getNext();
        return current.getData();
    }
    public BookStore removeFromBack() { 
        Node current = head;
        if(isEmpty())
            return null;
        
        if(head.getNext()== null)
        {
            head = null;
            return current.getData();
        }
        else{ 
            Node prev = null;
            while(current.getNext()!= null){
                prev = current;
                current = current.getNext();
            }
               
                prev.setNext(null);
                return current.getData();
    }
        
}
 
    
    
    
    
}
