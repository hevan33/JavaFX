package com.example.javafx;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    void add(){
        String s = new String(time.getText());
        int hour = Integer.parseInt(new String(s.substring(0,2)));
        int minute = Integer.parseInt(new String(s.substring(3,5)));
        if(minute == 59){
            if(hour == 23){hour = 0;}
            else{ hour++;}
            minute = 0;
        }else{minute++;}
        setTime(minute ,hour);
    }
    @FXML
    void subtract(){
        String s = new String(time.getText());
        int hour = Integer.parseInt(new String(s.substring(0,2)));
        int minute = Integer.parseInt(new String(s.substring(3,5)));
        if(minute == 0){
            if(hour == 0){hour = 23;}
            else{ hour--;}
            minute = 59;
        }else{minute--;}
        setTime(minute ,hour);
    }
    @FXML
    void setTime(int minute, int hour){
        if(hour>=10&&minute>=10){time.setText(Integer.toString(hour) + ":" + (Integer.toString(minute)));}
        else if(hour<10&&minute>=10){time.setText("0" + Integer.toString((hour)) + ":" + (Integer.toString(minute)));}
        else if(hour<10&&minute<10){time.setText("0" + Integer.toString((hour)) + ":" + "0" + Integer.toString(minute));}
        else if(hour>=10&&minute<10){time.setText(Integer.toString((hour)) + ":" + "0" + (Integer.toString(minute)));}
    }
    @FXML
    void addPn(){
        addBorder(pn);
        days.add("Poniedzialek");
    }
    @FXML
    void addWt(){
        addBorder(wt);
        days.add("Wtorek");
    }
    @FXML
    void addSr(){
        addBorder(sr);
        days.add("Sroda");
    }
    @FXML
    void addCz(){
        addBorder(cz);
        days.add("Czwartek");
    }
    @FXML
    void addPi(){
        addBorder(pi);
        days.add("Piatek");
    }
    @FXML
    void addSb(){
        addBorder(sb);
        days.add("Sobota");
    }
    @FXML
    void addNi(){
        addBorder(ni);
        days.add("Niedziela");
    }
    @FXML
    void addBorder(Button b){
        b.setBorder(new Border(new BorderStroke(Color.RED,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    @FXML
    void save(){
        setClock clock = new setClock(time.getText(),days, (int)volume.getValue(), name.getText());
        Clock.add(clock);
    };

    @FXML
    void cancel(){
        time.setText("00:00");
        volume.setValue(0);
        name.setText("name");
        days.clear();
        pn.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        wt.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        sr.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        cz.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        pi.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        sb.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        ni.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    };
    @FXML
    void quit(){
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

}