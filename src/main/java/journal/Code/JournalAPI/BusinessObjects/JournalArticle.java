package journal.Code.JournalAPI.BusinessObjects;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

public class JournalArticle {

    private String authorName;
    private String title;
    private String description;
    private String urlLocation;
    private int ID;
    private String date;

    public JournalArticle(String authorName, String title, String description, String UrlLocation, int ID, String date) {
        this.setAuthor(authorName);
        this.setTitle(title);
        this.setDescription(description);
        this.setID(ID);
        this.setUrlLocation(urlLocation);
        this.date = date;
    }
    public JournalArticle(String authorName, String title, String description, String urlLocation, String date) {
        this.setAuthor(authorName);
        this.setTitle(title);
        this.setDescription(description);
        this.setUrlLocation(urlLocation);
        this.date = date;
    }

    public String getAuthor() {
        return this.authorName;
    }

    public void setAuthor(String AuthorName) {
        this.authorName = AuthorName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlLocation() {
        return this.urlLocation;
    }

    public void setUrlLocation(String UrlLocation) {
        this.urlLocation = UrlLocation;
    }

    public int getId() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date= date;
    }

    public String serializeToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JsonArticle = gson.toJson(this);
        return JsonArticle;
    }

}
