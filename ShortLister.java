import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ShortLister {

    public static ArrayList<Object> collectAll(ArrayList<Object> objects, Filter f)
    {
        ArrayList<Object> result = new ArrayList<Object>();

        for (Object obj: objects)
        {
            if(f.accept(obj))
            {
                result.add(obj);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        PrintWriter out;
        Scanner in;
        Scanner console = new Scanner(System.in);
        File selectedFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        String outFileName = "";
        String defaultFileName = "default.txt";
        int lineCount = 0;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                in = new Scanner(selectedFile);

                in.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Cancelled by User. Exiting...");
                System.exit(0);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found error!");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }


    }

}