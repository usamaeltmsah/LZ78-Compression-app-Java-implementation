import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Compressor frame = new Compressor();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To make the program stop when close the GUI
        CompressAndDecompress cc = new CompressAndDecompress();
        String l = cc.decompress("0A0B1A2A4A4B2B7B8B0A9X10M");
        System.out.println(l);

        String x = cc.Compress("ABAABABAABABBBBBBBBBBAX");
        System.out.println(x);
        /*for (String c : arrayList) {
            System.out.println(c);
        }
        System.out.print(compressed);*/
    }
}
