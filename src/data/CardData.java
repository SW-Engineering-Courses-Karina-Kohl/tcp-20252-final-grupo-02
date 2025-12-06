package data;

public class CardData {

    private String title;
    private String info;
    private String date;
    private String format;

    public CardData(String title, String info, String date, String format) {
    	
        this.title = title;
        this.info = info;
        this.date = date;
        this.format = format;
        
    }

    public String getTitle() {
    	
        return title;
        
    }

    public String getInfo() {
    	
        return info;
        
    }

    public String getDate() {
    	
        return date;
        
    }

    public String getFormat() {
    	
        return format;
        
    }
    
}
