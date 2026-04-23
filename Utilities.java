import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import java.util.ArrayList;

/**
 * This class contains some utilities that can be used to modify the image.
 * @author Ayaan Modak
 */

public final class Utilities
{
    /**
     * Reads data from a file and creates an image based on the data.
     * @param pgmFile the file the data is read from.
     * @return an image object based on the data given.
     */
    public static Image<Short> loadImage(String pgmFile) throws FileNotFoundException
    {   
        Scanner sc1 = new Scanner(new File(pgmFile));
        
        String imageType = sc1.nextLine();
        if(imageType.equals("P3")){
            sc1.nextLine();
        }
        int width = sc1.nextInt();
        int height = sc1.nextInt();
        sc1.nextInt();

        Image<Short> image = new Image<Short>(width, height, imageType);


        if(true /* imageType.equals("P2") */) {
            for(Node<Short> pixel : image){
                pixel.setValue(sc1.nextShort());
            }
        }
        /* else {
            for(Node<Short> node : image){
                node.setValue(sc1.nextShort());
            }
        } */

        sc1.close();
        return image;
    }

    /**
     * Gets data from an image object and writes it onto a given file.
     * @param image the image object which the data will come from.
     * @param pgmFile the file which will be written on.
     */
    public static void saveImage(Image<Short> image, String pgmFile) throws FileNotFoundException
    {
        PrintWriter wr1 = new PrintWriter(pgmFile);
        
        wr1.print(image.getType()+"\n");
        if(image.getType().equals("P3")){
            wr1.print("# feep.ppm\n");
        }
        wr1.print(image.getWidth() + " ");
        wr1.print(image.getHeight() + "\n");
        wr1.print("255\n");
 
        int count = 0;
        for(Node<Short> i : image){
            if(count % 3 == 0){
                wr1.print("\n");
            }

            wr1.print(i.getValue() + " ");
            count++;
        }

        wr1.print("\n");

        wr1.close();
    }

    /**
     * Converts the image from a P2 to P3 (RGB supported) format.
     * @param image the image object which the data will come from.
     * @param pgmFile the file which will be written on.
     */
    public static void updateImage(Image<Short> image, String pgmFile) throws FileNotFoundException
    {
        PrintWriter wr1 = new PrintWriter(pgmFile);
        
        int width = image.getWidth();
        int height = image.getHeight();

        wr1.print("P3\n# feep.ppm\n");
        wr1.print(width + " " + height + "\n255\n");

        // Image<Short> updatedImage = new Image<Short>(image.getWidth(), image.getHeight(), "P3");

        for(Node<Short> pixel : image){
            wr1.print("50, 10, " + pixel.getValue() + "\n");
        }

        wr1.close(); 
    }

    /**
     * Prints content of image file.
     * @param image the image object which the data will come from.
     */
    public static void printImage(Image<Short> image){
        String output = "" + image.getType() + "\n" + image.getWidth() + " " + image.getHeight() + "\n255\n";

        int count = 0;
        for(Node<Short> pixel : image){
            if(count % 3 == 0){
                output += "\n";
            }

            output += pixel.getValue() + " ";
            count++;
        }

        System.out.println(output);
    }
}
