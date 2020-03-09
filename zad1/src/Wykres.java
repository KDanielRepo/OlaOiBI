import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Wykres extends Application {
    List<String> litery = new ArrayList<>();
    List<Integer> ilosc = new ArrayList<>();
    BarChart barChart;
    BarChart barChart1;
    XYChart.Series series;
    Map test = new TreeMap();
    Map testt = new TreeMap();
    BorderPane borderPane;
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
            getWykres(tekst,wynik);
            if (!file.exists())
                file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        borderPane = new BorderPane();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        siorbPlik(new File("./zad1/src/kektest1.txt"));
        //siorbPlik(new File("./zad1/src/kektest2.txt"));
        //siorbPlik(new File("./zad1/src/kektest3.txt"));
        //siorbPlik(new File("./zad1/src/kektest4.txt"));
        //siorbPlik(new File("./zad1/src/kektest5.txt"));
    }
    public void setLitery(List<String> litery){
        litery.add("a");
        litery.add("b");
        litery.add("c");
        litery.add("d");
        litery.add("e");
        litery.add("f");
        litery.add("g");
        litery.add("h");
        litery.add("i");
        litery.add("j");
        litery.add("k");
        litery.add("l");
        litery.add("m");
        litery.add("n");
        litery.add("o");
        litery.add("p");
        litery.add("q");
        litery.add("r");
        litery.add("s");
        litery.add("t");
        litery.add("u");
        litery.add("v");
        litery.add("w");
        litery.add("x");
        litery.add("y");
        litery.add("z");
    }
    public void getWykres(String wiadomosc,String szyfr){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        barChart = new BarChart<String, Number>(xAxis, yAxis);
        series = new XYChart.Series();
        xAxis.setLabel("litera");
        yAxis.setLabel("ilosc");

        setLitery(litery);
        for (int i = 0; i < litery.size(); i++) {
            int iloscc = 0;
            for (int j = 0; j < wiadomosc.length(); j++) {
                String test = wiadomosc.substring(j, j + 1);
                if (litery.get(i).equals(test)) {
                    iloscc++;
                }
            }
            ilosc.add(iloscc);
        }

        for (int i = 0; i < litery.size(); i++) {
            test.put(litery.get(i),ilosc.get(i));
        }
        Set<String> keys = test.keySet();

        barChart.setTitle("Przed");

        for(String key : keys)
            for (int i = 0; i < keys.size(); i++) {
                series.getData().add(new XYChart.Data(key, test.get(key)));
            }

        barChart.getData().addAll(series);
        if(!borderPane.getChildren().contains(barChart)){
            borderPane.setLeft(barChart);
        }

        barChart1 = new BarChart<String, Number>(xAxis2,yAxis2);
        XYChart.Series series1 = new XYChart.Series();
        xAxis2.setLabel("litera");
        yAxis2.setLabel("ilosc");

        List<String> litery2 = new ArrayList<>();
        setLitery(litery2);
        List<Integer> ilosc2 = new ArrayList<>();
        barChart1.setTitle("Po");

        for (int i = 0; i < litery2.size(); i++) {
            int iloscc = 0;
            for (int j = 0; j < szyfr.length(); j++) {
                String testt = szyfr.substring(j, j + 1);
                if (litery2.get(i).equals(testt)) {
                    iloscc++;
                }
            }
            ilosc2.add(iloscc);
        }
        for (int i = 0; i < litery2.size(); i++) {
            testt.put(litery2.get(i),ilosc2.get(i));
        }
        Set<String> keyss = testt.keySet();

        barChart.setTitle("Przed");

        for(String key : keyss)
            for (int i = 0; i < keyss.size(); i++) {
                series1.getData().add(new XYChart.Data(key, testt.get(key)));

            }
        barChart1.getData().addAll(series1);
        if(!borderPane.getChildren().contains(barChart1)){
            borderPane.setRight(barChart1);
        }
    }

    public static void main(String[] args) {
        launch(Wykres.class,args);
    }
}
