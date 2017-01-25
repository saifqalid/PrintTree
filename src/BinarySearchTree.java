/*
 *  Java Program to Implement Binary Search Tree
 *  Created by 	700640516 (Purna)
 *  			700643292 ()
 *  			700631837 ()
 *  			700648083 ()
 *  
 */
 
import java.util.ArrayList;
import java.util.Scanner;
 
 
  /* Class BinarySearchTree */
 public class BinarySearchTree
 {
     public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST(); 
        ArrayList<Integer> aList=new ArrayList<>();
       
        char ch;
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 :
            	aList.clear();
                System.out.println("Enter integer element to insert");
                bst.insert( scan.nextInt() );     
                BTreePrinter.printNode(bst.getRoot());
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete");
                bst.delete( scan.nextInt() );     
                BTreePrinter.printNode(bst.getRoot());
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search");
                int find = scan.nextInt();
                if(bst.search(find))
                	System.out.println("Element found ");
                else
                	System.out.println("Element not found ");
                break;                                          
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            //display tree
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
        
    }
     
    
  
 }