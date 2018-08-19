/**
* The AVLTree contains all the methods that are to manage the dataStructures. 
* Insertion deletion balance factor ... 
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   /**
   * balanceFactor gives height difference between two nodes 
   *@param node node local variable
   * @return Returns balance factor 
   */
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }

   /**
   * fixHeight fixes the heights for an unbalanced node
   *@param node node local variable
   */
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**
   * rotateRight rotates node to the right where there is imbalance
   * @return returns to connect imbalanced node to parent node/root
   *@param p avl node local vaiable initialised
   */
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   /**
   * rotateLeft rotates node to the left where there is imbalance
   *@param q avl node local vaiable initialised
   * @return returns to connect imbalanced node to parent node/root
   */

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   /**
   * balance balances a Node 
   *@param p avl node local vaiable initialised
   * @return returns balanced node
   */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   /**
   * Inserts each node left or right according to equality 
   *@param k key for fullname
   *@param d data for full entry
   * @return returns by calling balance() to balance tree
   */

   public void insert ( dataType k, dataType d )
   {
      root = insert (k, d, root);
   }
   public BinaryTreeNode<dataType> insert ( dataType k, dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (k, d, null, null);
      if (k.compareTo (node.key) <= 0)
         node.left = insert (k, d, node.left);
      else
         node.right = insert (k, d, node.right);
      return balance (node);
   }

   /**
   * delete removes a node from a tree
   *@param d data for full entry
   * @return calls balance() to rebalance tree
   */
   
   public void delete ( dataType k )
   {
      root = delete (k, root);
   }   
   public BinaryTreeNode<dataType> delete ( dataType k,  BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (k.compareTo (node.key) < 0)
         node.left = delete (k,  node.left);
      else if (k.compareTo (node.key) > 0)
         node.right = delete (k,  node.right);
      else
      {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   /**
   * findMin finds minimum node
   * @param node initialises Bst node
   * @return returns minimum node
   */
   
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }
   /**
   * removeMin removes minimum node 
   * @param node initialises node
   * @return returns by calling balance() to balance tree
   */
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   /**
   * find finds/searches for a node
   *@param k key for fullname
   *@param d data for full entry
   * @return returns requested node
   */

   public BinaryTreeNode<dataType> find ( dataType k, dataType d )
   {
      if (root == null)
         return null;
      else
         return find (k, d, root);
   }
   public BinaryTreeNode<dataType> find ( dataType k, dataType d, BinaryTreeNode<dataType> node )
   {
      if (k.compareTo (node.key) == 0) 
         return node;
      else if (k.compareTo (node.key) < 0)
         return (node.left == null) ? null : find (k, d, node.left);
      else
         return (node.right == null) ? null : find (k, d, node.right);
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<dataType> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
   //public String toString(){

   	//return find().node;
   //}
}

