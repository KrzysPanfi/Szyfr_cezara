import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
    String filepath="";

    }
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
    public static ArrayList<String> cipher(int key,ArrayList<String>slowa){
    ArrayList<String>wynik=new ArrayList<>();

        for (String i :slowa){
            StringBuilder newstring= new StringBuilder();
        char[]znaki=i.toCharArray();
        for (char znak:znaki){
            int valascii=znak;
            int newvalascii=valascii+key;
            if(newvalascii>90){
                newvalascii=newvalascii-25;
            }
           char znak2=(char)(newvalascii);
            newstring.append(znak2);
        }
        wynik.add(newstring.toString());
    }
        return wynik;
    }

}