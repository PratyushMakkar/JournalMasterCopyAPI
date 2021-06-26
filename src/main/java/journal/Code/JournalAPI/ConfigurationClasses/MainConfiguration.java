package journal.Code.JournalAPI.ConfigurationClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import journal.Code.JournalAPI.BusinessObjects.Deserielization.CustomArticleDeserializer;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import journal.Code.JournalAPI.DataAccess.ArticlesDataService;
import journal.Code.JournalAPI.DataAccess.MainArticlesDataService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"production"})
public class MainConfiguration {

    @Value("${spring.data.mongodb.uri}")
    String MongoDbUri;

    @Value("${spring.data.mongodb.database}")
    String databaseName;

    @Value("${collectionName}")
    String collectionName;

    @Value("${mainArticlesCollectionName}")
    String mainArticlesCollectionName;

    @Bean
    public Gson customDeserializer() {
        return new GsonBuilder()
                .registerTypeAdapter(JournalArticle.class, new CustomArticleDeserializer())
                .create();
    }

    @Bean
    public ArticlesDataService getArticlesDataService() {
        return new ArticlesDataService();
    }

    @Bean
    public MainArticlesDataService getMainArticlesDataService() {
        return new MainArticlesDataService();
    }

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(MongoDbUri);
    }

    @Bean
    public MongoCollection<Document> getArticlesCollection() {
        MongoDatabase database = mongoClient().getDatabase(databaseName);
        return database.getCollection(collectionName);
    }

    @Bean
    public MongoCollection<Document> getMainArticlesCollection() {
        MongoDatabase database = mongoClient().getDatabase(databaseName);
        return database.getCollection(mainArticlesCollectionName);
    }


}
