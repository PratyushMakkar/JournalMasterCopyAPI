package journal.Code.JournalAPI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeserealizationTest {

    @Qualifier("customDeserializer")
    @Autowired
    Gson gsonInstance;

    //String testArticle =  new  """"{"authorName" : "YeetMainArticle", "title" : " My assArticle", "description": "deez nitsArticle","url": "http//MainArticle.pong" }""";
    @Test
    void deserealizeJounralArticle() {
        JournalArticle journalArticle = gsonInstance.fromJson("", JournalArticle.class);
    }

}
