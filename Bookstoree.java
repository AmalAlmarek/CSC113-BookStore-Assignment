
package bookstoree;
import java.util.*;
import java.io.*;
import javax.swing.*;
        
public class Bookstoree {
static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
     
       JOptionPane.showMessageDialog(null, "Welcom to Riyadh BookStore");
       List BoSList = new List();
       
       boolean enter = true;
       int dx = 0 ;
       while(enter){
            while(dx<3){
                    try{
                    System.out.println("Please enter the Book Store Location : ");
                    String loc = input.next();
                    System.out.println("Please enter the Number of books in Book Store : ");
                    int num = input.nextInt();
                    System.out.println("Please enter the Book Store size : ");
                    int size = input.nextInt();

                    BookStore ri = new BookStore(loc,num,size);


                    System.out.println("Please enter how many sections you want to add for this Book Store ");
                    int numS = input.nextInt();
                    for(int i = 0 ; i <numS ; i++){
                    System.out.println("Enter name of the "+(i+1)+" section");
                    if(ri.addSections(input.next()))
                            System.out.println("Add done");
                    else
                            System.out.println("Section not added");
                    }
                    BoSList.insertAtBack(ri);
                    dx++;
                    enter = false;
                    }
                   
                    catch(InputMismatchException t ){
                    System.out.println("Enter only Integer Values ");
                    input.next();
                    }        
                }
            }
       
       
       
        try{
           
            Scanner scan = new Scanner(new File("NoreBookStore.txt"));
            
            while(scan.hasNext())
            {
                String lo = scan.next();
                int numB = scan.nextInt();
                int siz = scan.nextInt();
                
               BoSList.insertAtBack(new BookStore(lo,numB,siz));
               
            }
            scan.close();
                
            }
        
        catch(FileNotFoundException e ){
        System.out.println("Error while processing file ");
        }
        
        int len = BoSList.size();
        boolean found = false ;
        for( int i = 0 ; i <len ; i++){
        BookStore b = BoSList.removeFromFront();
        if(b.getLocation().equalsIgnoreCase("KSU"))
            found = true;
            else 
            BoSList.insertAtBack(b);
        }
        
        if(found == false )
            System.out.println("The KSU BookStore does not exist ");
        else
            System.out.println("KSU BookStore Found and Removed ");
                
       
        
        len = BoSList.size(); 
  
        for(int  j = 0 ; j<len ; j++){
        BookStore v = BoSList.removeFromFront();
        if(v.getNbBook() >= 1000 )
         v.addSections("Computer");
       
            BoSList.insertAtBack(v);
        }
        
        int k = 0;
        len = BoSList.size(); 
        BookStore[] rArray = new BookStore [len];
        for(int  p = 0 ; p<len ; p++){
        BookStore v = BoSList.removeFromFront();
        if(v.getNbBook() < 1000 ){
            rArray[k++] = v;
        }
            BoSList.insertAtBack(v);
        }
           
            
        System.out.println("The Number of Regular BookStores is : " +k);
        
        
        try{
            
            File file = new File("RegularBookstores.dat");
            if(file.exists())
                System.out.println("Exista");
            else
                System.out.println("does not exist");
                    
            FileOutputStream Fou = new FileOutputStream(file);
            ObjectOutputStream ob = new  ObjectOutputStream(Fou);
            
            ob.writeObject(rArray);
            
            ob.close();
            
        }
        catch(IOException t ){
        System.out.println("Error While Processing an Object file ");
            System.out.println(t.getStackTrace());
        } 
        
        
        len = BoSList.size(); 
        System.out.println("**** Printing All BookStore Information In Riyadh ****");
        for(int  j = 0 ; j<len ; j++){
        BookStore v = BoSList.removeFromFront();
        System.out.println(v.toString());
        BoSList.insertAtBack(v);
        }
            
            
    
}}
