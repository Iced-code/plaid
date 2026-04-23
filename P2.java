/**
    Do NOT submit this file.

    This is just a driver class for debugging your code.
    If any of this code doesn't compile with your other classes,
    it means that you have an error in the way you declare
    or implement the other classes -- do not alter this code to make
    it compile, fix the other classes instead.
*/
import java.io.FileNotFoundException;
import java.util.Iterator;

public class P2
{
    public static void main(String[] args)
    {
        if(args.length != 2) {
            System.err.println("Usage: java P2 <input file> <output file>");
            return;
        }

        Short x = 250;
        Short y = 15;
        Short z = 37;

        // create a new image by loading a file
        try {
            Image<Short> image = Utilities.loadImage(args[0]);

            System.out.println(image);

            /* for(Node<Short> node : image){
                System.out.print(node.getValue());
            } */
            Utilities.printImage(image);

            Utilities.updateImage(image, args[1]);
            Utilities.saveImage(image, args[1]);

            System.out.println("\nupdated image:");
            Utilities.printImage(Utilities.loadImage(args[0]));
        }
        catch(FileNotFoundException e) {
            System.err.println(e);
            return;
        }
        // Image<Short> image = Utilities.loadImage("test_image.pgm");

        // print the contents -- only if the optional toString() is implemented

        // run an enhanced-for loop and print all the pixels in a horizontal traversal
        

        

        // modify the image and save it to a new file
        //image.getHead().setValue(z);
        //Utilities.saveImage(image, "ayaanTest.pgm");

        //image.removeColumn(5);
        //image.insertRow(0, x);
        //image.insertRow(3, y);
        //image.getHead().setValue(z);
        //Utilities.saveImage(image, "ayaanTest.pgm");

        /*image.removeColumn(3);
        image.removeColumn(4);
        image.removeColumn(0);
        image.getHead().setValue(x);
        //image.removeColumn(2);*/
        
        //image.getHead().setValue(z);

        //image.getHead().getDown().setValue(z);;

        //image.removeBorder();
        //image.getHead().setValue(z);
        //Image<Short> filterImage = image.maxFilter();
        /* image.removeBorder();
        image.insertRow(2, z); */
        //Utilities.saveImage(image, "ayaanTest.pgm");
        /*image.removeBorder();
        image.removeBorder();*/
        //image.addBorder();
        //image.addBorder();
        //image.getHead().getDown().setValue(x);
        //Utilities.saveImage(image, "ayaanTest.pgm");
        //Utilities.saveImage(filterImage, "filterimage.pgm");

        /*Image<Short> myTestImage = Utilities.loadImage("copytest.pgm");
        Utilities.saveImage(myTestImage, "ayaanTest.pgm");
        myTestImage.insertRow(1, x);
        Utilities.saveImage(myTestImage, "ayaanTest.pgm");*/

        //image.compress();
        //Utilities.saveImage(image, "filterimage.pgm");
        





        //test
        //Image<Short> testImage = new Image<>(2, 2);

        //Image<Short> testImage = Utilities.loadImage("test_image.pgm");
        /*System.out.println(testImage+" post\n");
        for(Node<Short> node : testImage){
            System.out.print(node + " " + node.getValue());
        }

        System.out.println("\n");*/

        
        /*if (args.length != 2)
        {
            System.err.println("Usage: java P2 <input filename> <output filename>");
            return;
        }*/

        // create a new image by loading a file
        //Image<Short> image = Utilities.loadImage(args[0]);
        
        //Image<Short> image = Utilities.loadImage("ayaanTest.pgm");
        //Image<Short> image = new Image<Short>(3, 2);
        //Image<Short> image = Utilities.loadImage("test_image.pgm");

        /*Short[] test = {1,2,3,4,5};
        for(Short i : test){
            System.out.println(i);
        }*/

        // print the contents -- only if the optional toString() is implemented
        //System.out.println(image);

        //Short x = 5;
        //System.out.println(image.getHead());
        
        // run an enhanced-for loop and print all the pixels in a horizontal traversal
        /*for(Node<Short> node : image){
            if(node == (image.getHead())){
                System.out.println("HEAD PASSED");
            } 
            //node.setValue(x);
            
            System.out.print(node.getValue() + " ");
        }

        System.out.println("\nWHILES:");
        // run the same iteration manually (i.e. with a while loop)
        Iterator<Node<Short>> iter = image.iterator();
        while(iter.hasNext())
            System.out.print(iter.next().getValue() + " ");

        System.out.println("\n");
        // run a vertical iteration
        iter = image.iterator(Direction.VERTICAL);
        while(iter.hasNext())
            System.out.print(iter.next().getValue() + " ");

        // modify the image and save it to a new file
        
        //image.getHead().setValue(0);
        Utilities.saveImage(image, args[1]); */
    }
}
