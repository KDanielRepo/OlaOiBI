import java.io.*;


public class Main {
    String tekst= "";
    String wynik="";
    Integer liczba=4;


public void met1 (){
    wynik="";
    for (int i = 0; i < tekst.length() ; i++) {
       char rzut = tekst.charAt(i);
       int ile = rzut+liczba;
       if (ile >122){
            ile=97+(ile-123);
       }
       char tak = (char) ile;
       wynik += tak ;
    }
}
public void siorbPlik(File f){
    try {
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        tekst=bufferedReader.readLine();
        bufferedReader.close();
        met1();
        System.out.println(wynik);
        File file = new File("./zad1/src/kek");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(wynik);
        bufferedWriter.newLine();
        bufferedWriter.close();
        if (!file.exists())
        file.createNewFile();
    }catch (Exception e){
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
        Main main = new Main();
        /*Scanner nazwa = new Scanner(System.in);
        main.tekst = nazwa.nextLine();
        main.liczba = nazwa.nextInt();
        main.met1();
        System.out.println(main.wynik);*/
        main.siorbPlik(new File("./zad1/src/kektest1.txt"));
        main.siorbPlik(new File("./zad1/src/kektest2.txt"));
        main.siorbPlik(new File("./zad1/src/kektest3.txt"));
        main.siorbPlik(new File("./zad1/src/kektest4.txt"));
        main.siorbPlik(new File("./zad1/src/kektest5.txt"));

    }
}
