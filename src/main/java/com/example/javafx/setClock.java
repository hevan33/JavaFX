package com.example.javafx;

import java.util.ArrayList;
import java.util.List;

public class setClock {
    protected String time;
    protected List<String> days = new ArrayList<>();
    protected int volume;
    protected String name;

    public setClock(String time, List<String> days, int volume, String name) {
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

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
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
