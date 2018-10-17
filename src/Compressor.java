import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Compressor extends JFrame{
    private JButton loadFileButton;
    private JPanel panel1;
    private JButton decompressButton;
    private JButton compressButon;

    CompressAndDecompress CommAndDecomm = new CompressAndDecompress();
    OpenFile of;
    ReadFile rf = new ReadFile();

    public Compressor() {

        add(panel1);
        setTitle("Files Compressor");
        setSize(500, 500);

        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Called when load file button clicked

                of = new OpenFile();

                try {
                    of.pickMe();
                }
                catch (Exception e1)
                {
                    System.out.println(e1);
                }
            }
        });


        compressButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Called when compress button clicked
                try
                {
                    String textFile = rf.readFile(of.getFilePath());
                    String Compressed = CommAndDecomm.Compress(textFile);
                    /*File file = new File(of.getFilePath());
                    if(file.createNewFile())
                    {
//                        System.out.println("LZ78File.txt" + " File Created");
                    }
                    else
                    {
//                        System.out.println("LZ78File.txt" + " already exists");
                    }*/
                    BufferedWriter writer = new BufferedWriter(new FileWriter(of.getFilePath()));
                    writer.write(Compressed);
                    writer.close();

                    JOptionPane.showMessageDialog(null, "File compressed successfully :)");
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "No file was selected!");
                }

            }
        });
        decompressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Called when Decompress button clicked
                try
                {
                    String Compressed = rf.readFile(of.getFilePath());
                    String Decompressed = CommAndDecomm.decompress(Compressed);
                    /*File file = new File("F:\\FCI\\FCIL3 T1\\IT433 - Multimedia\\Assignment1\\Decompressed.txt");
                    if(file.createNewFile())
                    {
//                        System.out.println(of.getFileName() + " File Created");
                    }
                    else
                    {
//                        System.out.println(of.getFileName() + " already exists");
                    }*/
                    BufferedWriter writer = new BufferedWriter(new FileWriter(of.getFilePath()));
                    writer.write(Decompressed);
                    writer.close();

                    JOptionPane.showMessageDialog(null, "File decompressed successfully :)");
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null, "No file was selected!");
                }
            }
        });
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Compressor frame = new Compressor();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }*/
}
