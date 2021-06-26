package journal.Code.JournalAPI.DataAccess;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters.*;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.print.attribute.standard.JobHoldUntil;
import java.util.ArrayList;

public class MainArticlesDataService {

    @Qualifier("getMainArticlesCollection")
    @Autowired
    MongoCollection<Document> mainArticlesCollection;

    @Qualifier("customDeserializer")
    @Autowired
    Gson gsonInstance;

    public ArrayList<JournalArticle> retrieveArticles(long numberOfArticles) {
        ArrayList<JournalArticle> articles = new ArrayList<JournalArticle>();
        mainArticlesCollection.find().forEach(entity ->
                articles.add(gsonInstance.fromJson(entity.toJson(), JournalArticle.class)));   //Failing since the Json has an extra field
        return articles;

    }

    public void retrieveLatestArticle() {
        //return retrieveArticleById(mainArticlesCollection.countDocuments());
    }

    public JournalArticle uploadArticle(JournalArticle article) {     //Uploads a single Article depending on the Article Object supplied

        long articleId = mainArticlesCollection.countDocuments()+1;

        Document document = new Document("title", article.getTitle())
                .append("id", articleId)
                .append("authorName", article.getAuthor())
                .append("url", article.getUrlLocation())
                .append("date", article.getDate())
                .append("description", article.getDescription());
        this.mainArticlesCollection.insertOne(document);

        article.setID(((int) articleId));
        return article;
    }

    public void deleteArticle() {

    }

}
