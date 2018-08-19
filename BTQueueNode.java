/**
* The BTQueueNode creats a node 
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/

public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
