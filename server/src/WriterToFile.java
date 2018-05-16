import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {

    /**
     * Store data to a text file.
     */
    public static void storeDataToTextFile(String data) {

        try
        {
            String filename= "startbootstrap/store.txt";
            FileWriter fw = new FileWriter(filename,false); //the true will
            // append the new data
            fw.append(data + "\n");//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
