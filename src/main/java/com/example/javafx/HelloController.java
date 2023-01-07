package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HelloController {
    @FXML
    private TextField time;
    @FXML
    private List<setClock> Clock = new ArrayList<>();
    @FXML
    private Slider volume;
    @FXML
    private List<String> days = new ArrayList<>();
    @FXML
    private TextField name;
    @FXML
    private Button closeButton;
    @FXML
    private Button pn;
    @FXML
    private Button wt;
    @FXML
    private Button sr;
    @FXML
    private Button cz;
    @FXML
    private Button pi;
    @FXML
    private Button sb;
    @FXML
    private Button ni;
    @FXML
    public void add(){
        int[] hourMinutes = convertString();
        if(hourMinutes[1] == 59){
            if(hourMinutes[0] == 23){hourMinutes[0] = 0;}
            else{ hourMinutes[0]++;}
            hourMinutes[1] = 0;
        }else{hourMinutes[1]++;}
        setTime(hourMinutes[1] ,hourMinutes[0]);
    }
    // funkcja dodająca czas za pomocą kliknięcia w odpowiedni przycisk
    @FXML
    public void subtract(){
        int[] hourMinutes = convertString();
        if(hourMinutes[1]== 0){
            if(hourMinutes[0] == 0){hourMinutes[0] = 23;}
            else{ hourMinutes[0]--;}
            hourMinutes[1] = 59;
        }else{hourMinutes[1]--;}
        setTime(hourMinutes[1] ,hourMinutes[0]);
    }
    // funkcja odejmująca czas za pomocą kliknięcia w odpowiedni przycisk
    @FXML
    public int[] convertString(){
        String s = new String(time.getText());
        isNumeric(s);
        int[] hourMinutes = new int[2];
        hourMinutes[0] = Integer.parseInt(new String(s.substring(0,2)));
        hourMinutes[1] = Integer.parseInt(new String(s.substring(3,5)));
        return hourMinutes;
    }
    // funkcja konwertująca i pobierająca wartość z pola TextField
    @FXML
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    // obsługa wyjątku w sytuacji, kiedy w polu z czasem pojawi się wartość inna niż liczba
    @FXML
    public void setTime(int minute, int hour){
        if(hour>=10&&minute>=10){time.setText(Integer.toString(hour) + ":" + (Integer.toString(minute)));}
        else if(hour<10&&minute>=10){time.setText("0" + Integer.toString((hour)) + ":" + (Integer.toString(minute)));}
        else if(hour<10&&minute<10){time.setText("0" + Integer.toString((hour)) + ":" + "0" + Integer.toString(minute));}
        else if(hour>=10&&minute<10){time.setText(Integer.toString((hour)) + ":" + "0" + (Integer.toString(minute)));}
    }
    // funkcja edytująca atrybut text przy polu TextField zawierającym czas
    @FXML
    public void addPn(){
        addBorder(pn);
        days.add("Poniedzialek");
    }
    @FXML
    public void addWt(){
        addBorder(wt);
        days.add("Wtorek");
    }
    @FXML
    public void addSr(){
        addBorder(sr);
        days.add("Sroda");
    }
    @FXML
    public void addCz(){
        addBorder(cz);
        days.add("Czwartek");
    }
    @FXML
    public void addPi(){
        addBorder(pi);
        days.add("Piatek");
    }
    @FXML
    public void addSb(){
        addBorder(sb);
        days.add("Sobota");
    }
    @FXML
    public void addNi(){
        addBorder(ni);
        days.add("Niedziela");
    }
    // metody dodające do tablicy zaznaczone przez użytkownika dni w których ma dzwonić budzik, później ta tablica jest
    // wyświetlana przy parametrach budzika
    @FXML
    public void addBorder(Button b){
        b.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    // metoda dodająca obramowanie
    @FXML
    public void deleteBorder(Button b){
        b.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    // metoda usuwająca obramowanie
    @FXML
    public void save(){
        int[] hourMinutes = convertString();
        if(hourMinutes[0]<0 || hourMinutes[1]<0 || hourMinutes[0]>24 || hourMinutes[1]>24){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("The size of First Name must be between 2 and 25 characters");
            errorAlert.showAndWait();
        }
        setClock clock = new setClock(time.getText(),days, (int)volume.getValue(), name.getText());
        Clock.add(clock);
    };
    //funkcja pobierająca parametry wybrane przez użytkownika i tworząca budzik
    @FXML
    public void cancel(){
        time.setText("00:00");
        volume.setValue(0);
        name.setText(" ");
        days.clear();
        deleteBorder(pn);
        deleteBorder(wt);
        deleteBorder(sr);
        deleteBorder(cz);
        deleteBorder(pn);
        deleteBorder(sb);
        deleteBorder(ni);
    };
    //funkcja przywracająca domyślny wygląd okna, tj. bez zmian wprowadzonych przez użytkownika
    @FXML
    public void quit(){
        for(setClock o : Clock){
            System.out.println("Budzik o nazwie: " + o.name);
            System.out.println("Czas rozpoczecia: " + o.time);
            System.out.println("Głośność: " + o.volume);
            System.out.println("Uruchamia się w dniach:");
            for(String s : days){
                System.out.println(s + " ");
            }
        }
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    //metoda uruchamiana poprzez naciśniecię przycisku close, zamyka okno i parametry zapisanych budzików

}