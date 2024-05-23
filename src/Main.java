import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.WatchService;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        String filepath1 = "dane_6_1.txt";
        ArrayList<String> slowa1 = Download(filepath1);
        String filepath2 = "dane_6_2.txt";
        ArrayList<String> slowa2 = Download(filepath2);
        String filepath3 = "dane_6_3.txt";
        ArrayList<String> slowa3 = Download(filepath3);
        if (slowa1 != null && slowa2 != null && slowa3!=null) {
             //for (String i:slowa1) {
            // String str=cipher(107,i);
            //  System.out.println(str);
           // }
             for (String i : slowa2) {
             String str = decipher(i);
            System.out.println(str);
            }
        //for(String i:compare(slowa3)){
          //  System.out.println(i);
        //}
        }
    }

    public static final  String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static ArrayList<String> Download(String filepath) {
        ArrayList<String> Wynik = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Wynik.add(line);
            }
            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static String cipher(int key, String slowo) {
       String wynik ="";
            StringBuilder newstring = new StringBuilder();
            for (int j = 0; j < slowo.length(); j++) {
                int pos = alfabet.indexOf(slowo.charAt(j));
                int newpos = (pos + key) % 26;
                if(newpos<0){
                    newpos=alfabet.length()+newpos;
                }
                char newchar = alfabet.charAt(newpos);
                newstring.append(newchar);
        }
            wynik=newstring.toString();
        return wynik;
    }


    public static String decipher( String slowo) {
        String [] strings=slowo.split(" ");
        String slowo1=strings[0];
        int key=-Integer.parseInt(strings[1]);
       return cipher(key,slowo1);
        }

        public static ArrayList<String> compare (ArrayList<String>slowa){
        ArrayList<String>wynik=new ArrayList<>();
        for(String slowo:slowa){
        String [] strings=slowo.split(" ");
        String slowo1=strings[0];
        String slowo2=strings[1];
        int pos1=alfabet.indexOf(slowo1.charAt(0));
        int pos2=alfabet.indexOf(slowo2.charAt(0));
        int key=pos2-pos1;
        if(key<0){
            key+=26;
        }
        if(!(cipher(key,slowo1).equals(slowo2))) {
            wynik.add(slowo1);
        }
        }
        return wynik;
        }
    }
