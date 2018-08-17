import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
     
/**
* The InsertAVL program loads data from a file 'data.tar-1' into a AVL 
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/

import java.time.Duration;
import java.time.Instant;

public class InsertAVL
{
    /**
    *The dataIn() method is the method responsible for loading data to the AVL TREE
    *@return avl This returns the avltree containing data
    */
    public static AVLTree<String> dataIn()
    {
        Scanner inputStream = null;
        PrintWriter outputStream = null;
	//BinaryTree<String> BT = new BinaryTree<String>();
        AVLTree<String> avl = new AVLTree<String>();
        
        try
        {
            inputStream = new Scanner(new FileInputStream("data.tar-1"));
        }
        
        catch(FileNotFoundException e)
        {
	    System.out.println("No fie found");
            System.exit(0);
        }
        //int count = 0;
        String line = null;
        int count = 0;
        Instant start = Instant.now();
        while(inputStream.hasNextLine())
        {
            count++;
            if(count != 9000 ){
            line = inputStream.nextLine();
            avl.insert(line.substring(line.lastIndexOf("|")+1),line);
	    //System.out.println(line.substring(line.lastIndexOf("|")+1));
            }
            else
                break;
	    	//System.out.println(line);
            
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken of InsertAVL: "+ timeElapsed.toMillis() +" milliseconds");
        inputStream.close();
	return avl;
    }
    //public String toString(){

		//return ;    	
    //} 
  //public static void main(String[] args){
	
        
	
   // }

}
