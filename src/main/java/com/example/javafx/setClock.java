package com.example.javafx;

import java.util.ArrayList;
import java.util.List;

public class setClock {
    protected String time;
    protected String[] days = new String[7];
    protected int volume;
    protected String name;

    public setClock(String time, String[] days, int volume, String name) {
        this.time = time;
        this.days = days;
        this.volume = volume;
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
