import java.util.Iterator;

/**
 * This class is the iterator for the image structure.
 * @author Ayaan Modak
 * @param <T> the type of items the array will hold.
 */
public class ImageIterator<T extends Comparable<T>> implements Iterator<Node<T>>
{
    /**
     * A node that stores the current object.
     */
    private Node<T> currNode = new Node<T>();
    /**
     * The default direction to iterate through.
     */
    private Direction iterDirection = Direction.HORIZONTAL;

    /**
     * Default constructor for the image iterator.
     * @param image the image object which will be iterated through.
     */
    public ImageIterator(Image<T> image){
        currNode.setRight(image.getHead());

        /*public ImageIterator(){
            currNode = getHead();
        }*/
    }

    /**
     * Default constructor for the image iterator.
     * @param image the image object which will be iterated through.
     * @param direction the direction to iterate through the the image.
     */
    public ImageIterator(Image<T> image, Direction direction){
        
        if(direction == Direction.VERTICAL) {
            currNode.setDown(image.getHead());
        }
        else {
            currNode.setRight(image.getHead());
        }
        iterDirection = direction;
    }

    /**
     * Returns if there is another object after the current one.
     * @return whether or not there is a next object.
     */
    public boolean hasNext(){
        if(iterDirection == Direction.HORIZONTAL){
            if(currNode.getRight() == null){
                if(currNode.getDown() == null){
                    return false;
                } else {
                    return true;
                }
            }
            else {
                return true;
            }
        } 

        else {
            if(currNode.getDown() == null){
                if(currNode.getRight() == null){
                    return false;
                } else {
                    return true;
                }
            }
            else {
                return true;
            }
        }
    }

    /**
     * Returns the next node in the iteration.
     * Next node differs based on direction.
     * @return the next node.
     */
    public Node<T> next(){
        if(iterDirection == Direction.HORIZONTAL){
            if(currNode.getRight() != null){
                currNode = currNode.getRight();
            }
            else {
                while(currNode.getLeft() != null){
                    currNode = currNode.getLeft();
                }
                currNode = currNode.getDown();
            }
        } else {
            if(currNode.getDown() != null){
                currNode = currNode.getDown();
            }
            else {
                while(currNode.getUp() != null){
                    currNode = currNode.getUp();
                }
                currNode = currNode.getRight();
            }
        }

        return currNode;  
    }
}
