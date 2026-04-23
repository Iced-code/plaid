/**
 * This class represents a doubly linked node.
 * @author Ayaan Modak
 * @param <T> the type of items the array will hold.
 */

public final class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
    /**
     * Data in node.
     */
    private T data;
    /**
     * Node up pointer.
     */
    private Node<T> up;
    /**
     * Node down pointer.
     */
    private Node<T> down;
    /**
     * Node right pointer.
     */
    private Node<T> right;
    /**
     * Node left pointer.
     */
    private Node<T> left;

    /**
     * Default constructor for node.
     */
    public Node(){
        this.data = null;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
    }
    /**
     * Overloaded constructor for node. Takes in a value.
     * @param value data for the new node.
     */
    public Node(T value){
        this.data = value;
        this.up = null;
        this.down = null;
        this.right = null;
        this.left = null;
    }
    
    /**
     * Returns data in node.
     * @return data in node.
     */
    public T getValue(){
        return data;
    }
    /**
     * Returns the node that the current node points up to.
     * @return the node the current node points up to.
     */
    public Node<T> getUp(){
        return up;
    }
    /**
     * Returns the node that the current node points down to.
     * @return the node the current node points down to.
     */
    public Node<T> getDown(){
        return down;
    }
    /**
     * Returns the node that the current node points right to.
     * @return the node the current node points right to.
     */
    public Node<T> getRight(){
        return right;
    }
    /**
     * Returns the node that the current node points left to.
     * @return the node the current node points left to.
     */
    public Node<T> getLeft(){
        return left;
    }

    /**
     * Sets new data in the current node.
     * @param value the new data.
     */
    public void setValue(T value){
        data = value;
    }
    /**
     * Sets new node for current node to point up to.
     * @param p the new upper node.
     */
    public void setUp(Node<T> p){
        up = p;
    }
    /**
     * Sets new node for current node to point down to.
     * @param p the new down node.
     */
    public void setDown(Node<T> p){
        down = p;
    }
    /**
     * Sets new node for current node to point right to.
     * @param p the new right node.
     */
    public void setRight(Node<T> p){
        right = p;
    }
    /**
     * Sets new node for current node to point left to.
     * @param p the new left node.
     */
    public void setLeft(Node<T> p){
        left = p;
    }

    /**
     * Returns an integer based on whether the inputed object was bigger, smaller, or equal.
     * @param o node object that is being compared.
     * @return integer based on whether the inputed object was bigger, smaller, or equal.
     */    
    public int compareTo(Node<T> o) {
        if(o == null){
            throw new RuntimeException("Object invalid.");
        }
        return getValue().compareTo(o.getValue());
    }

}
