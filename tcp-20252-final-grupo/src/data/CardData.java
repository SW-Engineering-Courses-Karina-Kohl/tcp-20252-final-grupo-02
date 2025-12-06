package data;

public class CardData {

    private String group;
    private String info;
    private String date;
    private String format;

    public CardData(String group, String info, String date, String format) {
        this.group = group;
        this.info = info;
        this.date = date;
        this.format = format;
    }

    public String getGroup() {
        return group;
    }

    public String getInfo() {
        return info;
    }

    public String getDate() {
        return date;
    }

    public String getformat() {
        return format;
    }
}
