import java.util.ArrayList;
import java.util.Scanner;

public class CompressAndDecompress {
    String Compress(String s)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        String x = "",compressed = "";
        int pointer = 0 , index = 0, oldPointer = 0;
//        Scanner input = new Scanner(s);
        arrayList.add("");

        for (char c : s.toCharArray()) {
            index++;
            x += c;

            pointer = arrayList.indexOf(x);

            if(index == s.length())
            {
                compressed += oldPointer + "" + c ;
                arrayList.add(x);
            }
            else if(pointer != -1)
            {
                oldPointer = pointer; // Save this pointer to use it when the string is not found in the ArrayList
                continue;
            }
            else
            {
                arrayList.add(x);
                compressed += oldPointer + "" + c;
                x = "";
            }
            oldPointer = 0;
        }

        return compressed;
    }
    String decompress(String Compressed)
    {
        String Decomm = "", x = "", s = "";
        int poi = 0;
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("");
//        Scanner input = new Scanner(Compressed);

        for (char c : Compressed.toCharArray()) {
            if(!Character.isAlphabetic(c))
            {
                x += c;
                continue;
            }
            else
            {
                poi = Integer.parseInt(x);
                x = "";
                if(poi == 0)
                {
                    x += c;
                    arrayList.add(x);
                    Decomm += x;
                }
                else
                {
                    x += c;
                    s = arrayList.get(poi);
                    x = s + x;
                    arrayList.add(x);
                    Decomm += x;
                }
            }
            x = "";
        }
        return Decomm;
    }
}