package item_home;

public class Item_home {
    private int imageResource;
    private String title;
    private String content;

    public Item_home(int imageResource, String title, String content) {
        this.imageResource = imageResource;
        this.title = title;
        this.content = content;
    }

    // getters
    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}