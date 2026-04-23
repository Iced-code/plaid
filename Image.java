import java.util.Iterator;

/**
 * This class represents an image in the form of 2D doubly linked list.
 * @author Ayaan Modak
 * @param <T> the type of items the array will hold.
 */
public class Image<T extends Comparable<T>> implements Iterable<Node<T>>
{
    /**
     * The head node of the list.
     */
    private Node<T> head;
    /**
     * The number of rows and columns in the list.
     */
    private int width, height;

    /**
     * Type of ppm image (P2 or P3) 
     */
    private String type = "P2";

    /**
     * Constructor for the 2D doubly linked list image.
     * @param width the number of columns.
     * @param height the number of rows. 
     */
    public Image(int width, int height){
        if(width <= 0 || height <= 0){
            throw new RuntimeException("Invalid image dimension.");
        }

        this.width = width;
        this.height = height;
        this.head = new Node<T>();
        Node<T> currNode = head;

        Node<T> rowHeadNode = head;
        Node<T> tempNode = null;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; ++j){
                
                if(j < width-1){
                    currNode.setRight(new Node<T>()); //makes new node (right)
                    currNode.getRight().setLeft(currNode); //sets new node's left pointer to previous
                }
                if(i != 0){
                    currNode.setUp(tempNode);
                    currNode.getUp().setDown(currNode);
                }

                currNode = currNode.getRight(); //sets currnode to new Node (right)

                if(tempNode != null){
                    tempNode = tempNode.getRight();
                }
            }
            if(i < height-1){
                tempNode = rowHeadNode;
                rowHeadNode.setDown(new Node<T>());
                currNode = rowHeadNode.getDown();     //moves to start of next row
                rowHeadNode = rowHeadNode.getDown();  //saves first position of next row
            }
        }
    }

    /**
     * Constructor for the 2D doubly linked list image.
     * @param width the number of columns.
     * @param height the number of rows. 
     * @param type the images type (P2 or P3)
     */
    public Image(int width, int height, String type){
        if(width <= 0 || height <= 0){
            throw new RuntimeException("Invalid image dimension.");
        }

        this.type = type;
        this.width = width;
        this.height = height;
        this.head = new Node<T>();
        Node<T> currNode = head;

        Node<T> rowHeadNode = head;
        Node<T> tempNode = null;

        if(type.equals("P2")){
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    
                    if(j < width-1){
                        currNode.setRight(new Node<T>()); //makes new node (right)
                        currNode.getRight().setLeft(currNode); //sets new node's left pointer to previous
                    }
                    if(i != 0){
                        currNode.setUp(tempNode);
                        currNode.getUp().setDown(currNode);
                    }

                    currNode = currNode.getRight(); //sets currnode to new Node (right)

                    if(tempNode != null){
                        tempNode = tempNode.getRight();
                    }
                }
                if(i < height-1){
                    tempNode = rowHeadNode;
                    rowHeadNode.setDown(new Node<T>());
                    currNode = rowHeadNode.getDown();     //moves to start of next row
                    rowHeadNode = rowHeadNode.getDown();  //saves first position of next row
                }
            }
        }
        else {
            for(int i = 0; i < height*3; i++){
                for(int j = 0; j < width; ++j){
                    
                    if(j < width-1){
                        currNode.setRight(new Node<T>()); //makes new node (right)
                        currNode.getRight().setLeft(currNode); //sets new node's left pointer to previous
                    }
                    if(i != 0){
                        currNode.setUp(tempNode);
                        currNode.getUp().setDown(currNode);
                    }

                    currNode = currNode.getRight(); //sets currnode to new Node (right)

                    if(tempNode != null){
                        tempNode = tempNode.getRight();
                    }
                }
                if(i < height-1){
                    tempNode = rowHeadNode;
                    rowHeadNode.setDown(new Node<T>());
                    currNode = rowHeadNode.getDown();     //moves to start of next row
                    rowHeadNode = rowHeadNode.getDown();  //saves first position of next row
                }
            }
        }
    }

    /**
     * Returns height or the number of rows.
     * @return the number of rows.
     */
    public int getHeight(){
        return height;
    }
    /**
     * Returns width or the number of columns.
     * @return the number of columns.
     */
    public int getWidth(){
        return width;
    }
    /**
     * Returns the head or the first node in the 2D doubly linked list.
     * @return the head node.
     */
    public Node<T> getHead(){
        return head;
    }
    /**
     * Returns original image's type (P2 or P3).
     * @return the image type.
     */
    public String getType(){
        return type;
    }

    /**
     * Inserts a new rows of nodes into the 2D doubly linked list.
     * @param index the index at which the row should be inserted.
     * @param value the data which will occupy all of the nodes in the new row.
     */
    public void insertRow(int index, T value){
        Node<T> currNode = head;
        Node<T> tempNode = head;

        if(index >= 0 && index <= height){
            for(int i = 0; i < index-1; i++){
                currNode = currNode.getDown();
            }
            height = height + 1;
            
            while(currNode != null){
                
                if(index == 0){
                    if(currNode.getLeft() != null){
                        if(currNode.getLeft().getUp() != null){
                            currNode.setUp(currNode.getLeft().getUp().getRight());
                        }
                    } else {
                        currNode.setUp(new Node<T>(value));
                        head = currNode.getUp();
                    }
                    currNode.getUp().setDown(currNode);

                    if(currNode.getRight() != null){
                        currNode.getUp().setRight(new Node<T>(value));
                    }
                    if(currNode.getLeft() != null){
                        currNode.getUp().setLeft(currNode.getLeft().getUp());
                    }
                }
                else if(index > 0){
                    tempNode = currNode.getDown();
                    
                    if(currNode.getLeft() != null){
                        if(currNode.getLeft().getDown() != null){
                            currNode.setDown(currNode.getLeft().getDown().getRight());
                        }
                    } else {
                        currNode.setDown(new Node<T>(value));
                    }
                    currNode.getDown().setUp(currNode);

                    currNode.getDown().setDown(tempNode);
                    if(currNode.getDown().getDown() != null){
                        currNode.getDown().getDown().setUp(currNode.getDown());
                    }
                    
                    if(currNode.getRight() != null){
                        currNode.getDown().setRight(new Node<T>(value));
                    }
                    if(currNode.getLeft() != null){
                        currNode.getDown().setLeft(currNode.getLeft().getDown());
                    }
                }
                
                currNode = currNode.getRight();
            }
        } else {
            throw new RuntimeException("Invalid index."); 
        }
    }

    /**
     * Removes a column of nodes from the 2D doubly linked list.
     * @param index the index at which the column will be removed.
     */
    public void removeColumn(int index){
        if(index < 0 || index >= width || width <= 1){
            throw new RuntimeException("Invalid index.");
        } else {

            Node<T> currNode = head;
            if(index == 0){
                head = head.getRight();
            } else {
                for(int i = 0; i < index; i++){
                    currNode = currNode.getRight();
                }
            }

            while(currNode != null){
                if(index == 0){
                    currNode.getRight().setLeft(null);
                    currNode.setRight(null);
                } else {
                    if(index < width-1){
                        currNode.getRight().setLeft(currNode.getLeft());
                    }
                    currNode.getLeft().setRight(currNode.getRight());
                }
                currNode.setUp(null);
                

                currNode = currNode.getDown(); //goes down one in column
            }
        }
        width = width -1;
    }

    /**
     * Removes adjacent rows and columns that share the same value as the current node.
     * @return a count of the number of nodes removed.
     */
    public int compress(){
        Node<T> currNode = head;
        Node<T> rowHeadNode = head;
        int count = 0;
        //Image<T> compressedImage = new Image<>(count, count);
        
        while(currNode.getValue() != null){
            while(currNode.getValue().compareTo(currNode.getRight().getValue()) == 0){
                //if(currNode.getValue().compareTo(currNode.getRight().getValue()) == 0){
                //currNode.setRight(rowHeaNode);
                //}
                
                currNode = currNode.getRight();
            }
        }

        /*for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(currNode.getRight() != null){
                    if(currNode.getValue().compareTo(currNode.getRight().getValue()) == 0){
                        

                        
                    }
                }

                currNode = currNode.getRight();
            }
            currNode = rowHeaNode.getDown();
            rowHeaNode  = rowHeaNode.getDown();
        }*/

        /* i
        for(Node<T> pixel : this){
            T pxData = pixel.getValue();
            
            if(pixel.getLeft() != null && pxData.compareTo(pixel.getLeft().getValue()) == 0){ //left
                pixel.getLeft().getValue();
            }
            if(pixel.getRight() != null && pxData.compareTo(pixel.getRight().getValue()) == 0){ //right
                pxData = pixel.getRight().getValue();
            }
            if(pixel.getUp() != null){
                if(pixel.getUp().getLeft() != null && pxData.compareTo(pixel.getUp().getLeft().getValue()) == 0){ //upper left
                    pxData = pixel.getUp().getLeft().getValue();
                }
                if(pxData.compareTo(pixel.getUp().getValue()) == 0){ //up
                    pxData = pixel.getUp().getValue();
                }
                if(pixel.getUp().getRight() != null && pxData.compareTo(pixel.getUp().getRight().getValue()) == 0){ //upper right
                    pxData = pixel.getUp().getRight().getValue();
                }
            }
            if(pixel.getDown() != null){
                if(pixel.getDown().getLeft() != null && pxData.compareTo(pixel.getDown().getLeft().getValue()) == 0){ //lower left
                    pxData = pixel.getDown().getLeft().getValue();
                }
                if(pxData.compareTo(pixel.getDown().getValue()) < 0){ //down
                    pxData = pixel.getDown().getValue();
                }
                if(pixel.getDown().getRight() != null && pxData.compareTo(pixel.getDown().getRight().getValue()) == 0){ //lower right
                    pxData = pixel.getDown().getRight().getValue();
                }
            }*/

        return 0;
    }

    /**
     * Creates a one pixel wide border around the existing image.
     * Data within the nodes are determined by the adjacent nodes.
     */
    public void addBorder(){
        Node<T> currNode;
        
        insertRow(0, null);
        currNode = head;
        while(currNode != null){
            currNode.setValue(currNode.getDown().getValue());
            currNode = currNode.getRight();
        }

        insertRow(height, null);
        currNode = head;
        /*for(int i = 0; i < height-1; i++)*/ while(currNode.getDown() != null) currNode = currNode.getDown();
        while(currNode != null){
            currNode.setValue(currNode.getUp().getValue());
            currNode = currNode.getRight();
        }

        //add left border;
        head.setLeft(new Node<T>(head.getValue()));
        //Node<T> currNode = head.getLeft();
        Node<T> tempNode = head;
        head = head.getLeft();
        currNode = head;
        while(tempNode != null){
            currNode.setRight(tempNode);
            tempNode.setLeft(currNode);
            currNode.setValue(tempNode.getValue());
            if(tempNode.getUp() != null){
                currNode.setUp(tempNode.getUp().getLeft());
            }
            if(tempNode.getDown() != null){
                currNode.setDown(new Node<T>());
            }
            //currNode.getDown().setUp(currNode);
            currNode = currNode.getDown();
            tempNode = tempNode.getDown();
        }
        //add right border;
        currNode = head;
        while(currNode.getRight() != null){
            currNode = currNode.getRight();
        };
        tempNode = currNode;
        currNode.setRight(new Node<T>());
        currNode = currNode.getRight();
        while(tempNode != null){
            currNode.setLeft(tempNode);
            tempNode.setRight(currNode);
            currNode.setValue(tempNode.getValue());

            if(tempNode.getUp() != null){
                currNode.setUp(tempNode.getUp().getRight());
            }
            if(tempNode.getDown() != null){
                currNode.setDown(new Node<T>());
            }
            currNode = currNode.getDown();
            tempNode = tempNode.getDown();
        }
        width+=2;
    }

    /**
     * Removes a one pixel wide border from around the image.
     */
    public void removeBorder(){
        if(width >= 3 && height >= 3){
            removeColumn(0);
            removeColumn(width-1);  
            //removeColumn(1);

            //remove top
            Node<T> currNode = head;
            head = head.getDown();
            while(currNode != null){
                currNode.getDown().setUp(null);
                currNode.setLeft(null);
                currNode.setDown(null);
                currNode = currNode.getRight();
            }

            //remove bottom
            currNode = head;
            while(currNode.getDown() != null){
                currNode = currNode.getDown();
            }
            while(currNode != null){
                currNode.getUp().setDown(null);
                currNode.setUp(null);
                currNode.setLeft(null);
                currNode = currNode.getRight();
                //System.out.println("\nremoved");
            }

            height -= 2;
        } else {
            throw new RuntimeException("Image dimensions too small.");
        }
    }

    /**
     * Creates and returns a new image that is the same size as the original image.
     * The new image's pixel values are set to the largest value adjacent to them.
     * @return the new filtered image.
     */
    public Image<T> maxFilter(){
        Image<T> filteredImage = new Image<>(width, height);
        T pxData;

        Node<T> pixel = getHead();
        Node<T> pixelHead = getHead();
        Node<T> currFilterNode = filteredImage.getHead();
        Node<T> filterNode = filteredImage.getHead();

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                pxData = pixel.getValue();
                
                if(pixel.getLeft() != null && pxData.compareTo(pixel.getLeft().getValue()) < 0){ //left
                    pxData = pixel.getLeft().getValue();
                }
                if(pixel.getRight() != null && pxData.compareTo(pixel.getRight().getValue()) < 0){ //right
                    pxData = pixel.getRight().getValue();
                }
                if(pixel.getUp() != null){
                    if(pixel.getUp().getLeft() != null && pxData.compareTo(pixel.getUp().getLeft().getValue()) < 0){ //upper left
                        pxData = pixel.getUp().getLeft().getValue();
                    }
                    if(pxData.compareTo(pixel.getUp().getValue()) < 0){ //up
                        pxData = pixel.getUp().getValue();
                    }
                    if(pixel.getUp().getRight() != null && pxData.compareTo(pixel.getUp().getRight().getValue()) < 0){ //upper right
                        pxData = pixel.getUp().getRight().getValue();
                    }
                }
                if(pixel.getDown() != null){
                    if(pixel.getDown().getLeft() != null && pxData.compareTo(pixel.getDown().getLeft().getValue()) < 0){ //lower left
                        pxData = pixel.getDown().getLeft().getValue();
                    }
                    if(pxData.compareTo(pixel.getDown().getValue()) < 0){ //down
                        pxData = pixel.getDown().getValue();
                    }
                    if(pixel.getDown().getRight() != null && pxData.compareTo(pixel.getDown().getRight().getValue()) < 0){ //lower right
                        pxData = pixel.getDown().getRight().getValue();
                    }
                }
                currFilterNode.setValue(pxData);
                pixel = pixel.getRight();
                currFilterNode = currFilterNode.getRight();
            }
            pixel = pixelHead.getDown();
            currFilterNode = filterNode.getDown();
            pixelHead = pixelHead.getDown();
            filterNode = filterNode.getDown();
        }

        /*for(Node<T> pixel : this){
            pxData = pixel.getValue(); //center

            if(pixel.getLeft() != null && pxData.compareTo(pixel.getLeft().getValue()) < 0){ //left
                pxData = pixel.getLeft().getValue();
            }
            if(pixel.getRight() != null && pxData.compareTo(pixel.getRight().getValue()) < 0){ //right
                pxData = pixel.getRight().getValue();
            }
            if(pixel.getUp() != null){
                if(pixel.getUp().getLeft() != null && pxData.compareTo(pixel.getUp().getLeft().getValue()) < 0){ //upper left
                    pxData = pixel.getUp().getLeft().getValue();
                }
                if(pxData.compareTo(pixel.getUp().getValue()) < 0){ //up
                    pxData = pixel.getUp().getValue();
                }
                if(pixel.getUp().getRight() != null && pxData.compareTo(pixel.getUp().getRight().getValue()) < 0){ //upper right
                    pxData = pixel.getUp().getRight().getValue();
                }
            }
            if(pixel.getDown() != null){
                if(pixel.getDown().getLeft() != null && pxData.compareTo(pixel.getDown().getLeft().getValue()) < 0){ //lower left
                    pxData = pixel.getDown().getLeft().getValue();
                }
                if(pxData.compareTo(pixel.getDown().getValue()) < 0){ //down
                    pxData = pixel.getDown().getValue();
                }
                if(pixel.getDown().getRight() != null && pxData.compareTo(pixel.getDown().getRight().getValue()) < 0){ //lower right
                    pxData = pixel.getDown().getRight().getValue();
                }
            }


           pixel.setValue(pxData);
        }*/

        return filteredImage;
    }

    /**
     * Creates an iterator for the 2D doubly linked list image.
     * @return the iterator for the image.
     */
    @Override
    public Iterator<Node<T>> iterator() {
        return new ImageIterator<T>(this);
    }

    /**
     * Creates an iterator for the 2D doubly linked list image.
     * The direction to iterate is specified.
     * @param dir the direction to iterate through the image.
     * @return the iterator for the image.
     */
    public Iterator<Node<T>> iterator(Direction dir){
        return new ImageIterator<T>(this, dir);
    }
}
