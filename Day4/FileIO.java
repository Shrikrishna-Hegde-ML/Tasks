import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class FileIO {

    public static void main(String[] args) {
        try{
        FileReader fr = new FileReader("source.txt");
        FileWriter fw = new FileWriter("destination.txt");
        BufferedReader br = new BufferedReader(fr);
        String in = "";
        int line= 0;
        System.out.println("------Reading Source File------");
        br.mark(1000);
        while ((in = br.readLine()) != null) {
            System.out.println(in);
            line++;
        }
        System.out.println("Number of Lines = "+line);
        System.out.println("-------------------------------");

        System.out.println("---------Writing Content to Destination-----------------------");
        br.reset();
        BufferedWriter bw = new BufferedWriter(fw);
        while ((in = br.readLine()) != null) {
            System.out.println(in);
            bw.write(in);
            bw.append('\n');
        }
        System.out.println("Write Complete");
        br.close();
        fr.close();
        bw.close();
        fw.close();
        
        }catch(IOException e){System.out.println(e);}
    }
}