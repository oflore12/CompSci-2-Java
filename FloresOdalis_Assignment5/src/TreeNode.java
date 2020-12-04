/**
 * The external Tree Node for Linked Trees
 * @author Odalis R. Flores
 * @param <T>
 */
public class TreeNode <T> {
	
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	
	protected T data;
	
	/**
	 * Create a new TreeNode with left and right child set to null 
	 * and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.leftChild=null;
		this.rightChild=null;
	}
	
	/**
	 * Used for making deep copies
	 * @param node to make copy of 
	 */
	@SuppressWarnings("unchecked")
	public TreeNode(TreeNode<String> node) {
		this.leftChild= new TreeNode<>(node.leftChild);
		this.rightChild= new TreeNode<>(node.rightChild);
		this.data = (T) node.data;
	}
	/**
	 * Sets the data
	 * @param data
	 * @returns the data
	 */
	public T setData(T data) {
		return data;
	}
	/**
	 * Returns the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}
	/**
	 * Sets the left child
	 * @param leftChild the left child for current root
	 */
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild=leftChild;
		
	}
	/**
	 * Gets the left child for current root
	 * @return the left child
	 */
	public TreeNode<T> getLeftChild(){
		return leftChild;
	}
	/**
	 * sets the right child
	 * @param rightChild the right child for current root
	 */
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild=rightChild;
	}
	/**
	 * gets the right child for current root
	 * @return right child of current root
	 */
	public TreeNode<T> getRightChild(){
		return rightChild;
	}
}
