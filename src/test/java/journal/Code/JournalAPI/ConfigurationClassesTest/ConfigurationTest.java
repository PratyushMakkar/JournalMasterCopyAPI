package journal.Code.JournalAPI.ConfigurationClassesTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import journal.Code.JournalAPI.BusinessObjects.Deserielization.CustomArticleDeserializer;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import journal.Code.JournalAPI.DataAccess.ArticlesDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@TestConfiguration
@Profile({"Test"})
public class ConfigurationTest {


}

