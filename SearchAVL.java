import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;

/**
* The SearchIt application searchs for an entry based on a full name. 
* Application reads in a list of queries from a query file,
* searchs for each one and output "Not found" or the full entry for each query. 
*The data file will be loaded only once.
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/

public class SearchAVL
{
    /**
    *This is the main method which implements InsertAVL class which inserts data into a AVL TREE
    *It then uses other method from the AVL TREE to manage data
    *@param args This is unsed
    */
    public static void main(String[] args)
    {


	AVLTree<String> avl = new AVLTree<String>();
        avl = InsertAVL.dataIn();




        Scanner inputStream = null;
        PrintWriter outputStream = null;
	//BinarySearchTree<String> BT = new BinarySearchTree<String>();
        //BinarySearchTree<String> BST = new BinarySearchTree<String>();
        
        try
        {
            inputStream = new Scanner(new FileInputStream("QueryFile"));
        }
        
        catch(FileNotFoundException e)
        {
            System.exit(0);
        }
        String lne = null;
        int count = 0;
        Instant start = Instant.now();
        while(inputStream.hasNextLine())
        {
            //count++;
            //if(count != 50){
            lne = inputStream.nextLine();
            //avl.delete(lne);
            BinaryTreeNode<String> entry = avl.find(lne,lne);
	    if (entry != null)
		System.out.println(entry.data);
	    else 
		System.out.println("Not found");
        //}
        //else
        //    break;
	

	    //System.out.println(line.substring(line.lastIndexOf("|")+1));
            
	    //System.out.println(line);
            
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken for deleteAVL: "+ timeElapsed.toMillis() +" milliseconds");
        //System.out.println("Time taken for SearchAVL : "+ timeElapsed.toMillis() +" milliseconds");
        inputStream.close();

    }
}
