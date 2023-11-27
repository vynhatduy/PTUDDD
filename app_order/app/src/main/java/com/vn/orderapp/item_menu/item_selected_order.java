package com.vn.orderapp.item_menu;

public class item_selected_order {
    private String title;
    private String note;
    private int num;
    private int cash;

    public item_selected_order(String title, String note, int num, int cash) {
        this.title = title;
        this.note = note;
        this.num = num;
        this.cash = cash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
