package journal.Code.JournalAPI.DataAccess;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class ArticlesDataService {

    @Qualifier("getArticlesCollection")
    @Autowired
    MongoCollection<Document> articlesCollection;

    @Qualifier("customDeserializer")
    @Autowired
    Gson gsonInstance;

    public void retrieveArticleById(int Id) {
       articlesCollection.find().forEach(entity -> System.out.println(entity.toJson()));
    }

    public ArrayList<JournalArticle> retrieveArticles(int numberOfArticles) {
        ArrayList<JournalArticle> articles = new ArrayList<JournalArticle>();
        articlesCollection.find().sort(new BasicDBObject("id", -1)).forEach(entity ->
                articles.add(gsonInstance.fromJson(entity.toJson(), JournalArticle.class)));   //Failing since the Json has an extra field
        return articles;
    }

    public JournalArticle uploadArticle(JournalArticle article) {

        long articleId = articlesCollection.countDocuments()+1;

        Document document = new Document("title", article.getTitle())
                                .append("id", articleId)
                                .append("authorName", article.getAuthor())
                                .append("url", article.getUrlLocation())
                                .append("date", article.getDate())
                                .append("description", article.getDescription());
        this.articlesCollection.insertOne(document);

        article.setID(((int) articleId));
        return article;
    }

    public void deleteArticle() {

    }

}
