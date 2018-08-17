// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**
* The BinaryTree program Creats a Tree 
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   public BinaryTree ()
   {
      root = null;
   }

   /**
   *getheight calculates height of tree
   *@return returns tree height
   */
   public int getHeight ()
   {
      return getHeight (root);
   }   
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   /**
   *getsize calcultes tree size
   *@return returns tree size
   */
   public int getSize ()
   {
      return getSize (root);
   }   
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   /**
   *visit prints out node.data the data in a node(full entry)
   */
   
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   /**
   *preOrder traverses tree from root to leaf then around by way of leaves
   */
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   /**
   *preOrder traverses tree from leaf to root around by way of leaf
   */
   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   /**
   *inOrder prints a tree in order
   */

   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   /**
   *levelorder prints tree by way order
   */

   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
