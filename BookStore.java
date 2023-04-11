
package bookstoree;
import java.io.Serializable;
import java.util.*;
public class BookStore implements Serializable {
static Scanner input = new Scanner(System.in);
    private String location;
    private int nbBook;
    private String[] sections;
    private int nbS;
    
    public BookStore (String loc ,int n  , int size ) { 
        
        location = loc;
        sections = new String[size];
        nbS = 0;
        boolean flag = true;
        while(flag){
            try{
                 if(n < 0 || n > 5000)
                    throw new InvalidNumberOfBook();
                    else
                    nbBook = n;
           
            flag = false;
            
        }
        catch(InvalidNumberOfBook m){
            
            System.out.println(m.getMessage());
            System.out.println("Please re-enter again ");
            n = input.nextInt();
        }
        
    }
    }
    public String toString() { 
       String str ="Location of Book store: "+location + " |Number of Books : "+nbBook + "\n";
       str = str + "****ALL SECTIONS INFO ****"+"\n";
       for(int i = 0 ; i <nbS ; i++)
           str = str+sections[i] +"\n";
        str = str +"Number of Sections : "+ nbS+ "\n";
        return str;
    }
    
    public boolean addSections (String s ) {
        if(nbS<sections.length){
            sections[nbS++] =s;
            return true;
        }
        return false;
    }

    public String getLocation() {
        return location;
    }

    public int getNbBook() {
        return nbBook;
    }

    public String[] getSections() {
        return sections;
    }

    public int getNbS() {
        return nbS;
    }
    
    
    
}
