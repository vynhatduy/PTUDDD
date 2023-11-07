package com.vn.orderapp.item_sale;


public class Item_sale {
    private int img;
    private String title;
    private String content;

    public Item_sale(int img, String title, String content, String text_btn) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.text_btn = text_btn;
    }

    private String text_btn;

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getText_btn() {
        return text_btn;
    }
}
