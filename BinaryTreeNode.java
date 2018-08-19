
/**
* The BinaryTreeNode program creats each node in a tree
* @author  Anele Chila
* @version 1.0
* @since   2017-04-24
*/


/**
*This method initialises each node
*@return left/right recursively returns left or right node of each parent node
*/
public class BinaryTreeNode<dataType>
{
   dataType data;
   dataType key;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;

/**
*This method initialises each node
*@return left/right recursively returns left or right node of each parent node
*/
   
   public BinaryTreeNode ( dataType k ,dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
   	  key = k;
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   BinaryTreeNode<dataType> getLeft () { return left; }
   BinaryTreeNode<dataType> getRight () { return right; }
}
