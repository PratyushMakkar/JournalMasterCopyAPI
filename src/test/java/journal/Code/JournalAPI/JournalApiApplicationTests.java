package journal.Code.JournalAPI;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import journal.Code.JournalAPI.DataAccess.ArticlesDataService;

import java.util.ArrayList;

@SpringBootTest
class MongoArticleRetrievalTest {

	@Qualifier("getArticlesDataService")
	@Autowired
	ArticlesDataService dataAccess;

	@Qualifier("getMainArticlesCollection")
	@Autowired
	MongoCollection<Document> mainArticlesCollection;

	@Qualifier("customDeserializer")
	@Autowired
	Gson gsonInstance;

	@Test
	void retrieveArticle() {
		dataAccess.retrieveArticleById(0);
	}

	@Test
	void printJsonEntity() {
		ArrayList<JournalArticle> articles = new ArrayList<JournalArticle>();
		mainArticlesCollection.find().forEach(entity -> articles.add(gsonInstance.fromJson(entity.toJson(), JournalArticle.class)));
		System.out.println(articles.get(0).getAuthor());
	}

	@Test
	void printJsonEntityList() {
		ArrayList<JournalArticle> articles = new ArrayList<JournalArticle>();
		mainArticlesCollection.find().forEach(entity -> System.out.println(entity.toJson()));

	}

}
