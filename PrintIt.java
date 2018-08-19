/**
* The PrintIt program loads data from a file 'data.tar-1' into a BST 
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;



public class PrintIt
{
    /**
    *The dataIn() method is the method responsible for loading data to the BST
    *@return BST This returns the BST
    */
    public static BinarySearchTree<String> dataIn()
    {
        Scanner inputStream = null;
        PrintWriter outputStream = null;
	//BinaryTree<String> BT = new BinaryTree<String>();
        BinarySearchTree<String> BST = new BinarySearchTree<String>();
        
        try
        {
            inputStream = new Scanner(new FileInputStream("data.tar-1"));
        }
        
        catch(FileNotFoundException e)
        {
	    System.out.println("No fie found");
            System.exit(0);
        }
        String line = null;
        int count = 0;
		Instant start = Instant.now();
        while(inputStream.hasNextLine())
        {
        	count++;
	if(count != 1000){
            line = inputStream.nextLine();
            BST.insert(line.substring(line.lastIndexOf("|")+1),line);
	    //System.out.println(line.substring(line.lastIndexOf("|")+1));
            }
	else
		break;
	    //System.out.println(line);
            
        }
	Instant end = Instant.now();
	Duration timeElapsed = Duration.between(start, end);
	System.out.println("Time taken for InsertBST : "+ timeElapsed.toMillis() +" milliseconds");
        inputStream.close();
	return BST;
    }
  //public static void main(String[] args){
	//dataIn().inOrder(); //Returns BST by function dataIn 
        
	
    //}

}
