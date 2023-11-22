package com.vn.orderapp.item_location;

public class Item_Location {
    private String name,sdt,info;

    public Item_Location(String name, String sdt, String info) {
        this.name = name;
        this.sdt = sdt;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public String getSdt() {
        return sdt;
    }

    public String getInfo() {
        return info;
    }
}
