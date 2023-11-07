package com.vn.orderapp.item_menu;

public class Item_MonNgonPhaiThu {
    private int img;
    private String cap;
    private String cash;

    public Item_MonNgonPhaiThu(int img, String cap, String cash) {
        this.img = img;
        this.cap = cap;
        this.cash = cash;
    }

    public int getImg() {
        return img;
    }

    public String getCap() {
        return cap;
    }

    public String getCash() {
        return cash;
    }
}
