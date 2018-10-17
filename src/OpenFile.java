import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class OpenFile {
    JFileChooser fileChooser = new JFileChooser();
    StringBuilder sb = new StringBuilder();
    java.io.File file;
    public OpenFile(){}

    public String getFilePath() {
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        return path;
    }
    public String getFileName()
    {
        String filename = fileChooser.getSelectedFile().getName();
        return filename;
    }

    public File pickMe() throws Exception
    {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            file = fileChooser.getSelectedFile();

            String path= fileChooser.getSelectedFile().getAbsolutePath();
            String filename= fileChooser.getSelectedFile().getName();
            System.out.println(path);
            Scanner input = new Scanner(file);
        }
        else
        {
            sb.append("No File was selected");
        }
        return fileChooser.getSelectedFile();
    }
}
