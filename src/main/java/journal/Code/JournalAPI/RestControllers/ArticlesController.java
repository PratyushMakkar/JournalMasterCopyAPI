package journal.Code.JournalAPI.RestControllers;

import com.google.gson.Gson;
import journal.Code.JournalAPI.BusinessObjects.ArticlesRequestResponse;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import journal.Code.JournalAPI.DataAccess.ArticlesDataService;
import journal.Code.JournalAPI.DataAccess.MainArticlesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/articles")
public class ArticlesController {

    @Qualifier("getArticlesDataService")
    @Autowired
    ArticlesDataService articlesDataService;

    @Qualifier("getMainArticlesDataService")
    @Autowired
    MainArticlesDataService mainArticlesDataService;

    @Qualifier("customDeserializer")
    @Autowired
    Gson gsonInstance;

    @GetMapping("/articles/get/{numberOfArticles}")
    @ResponseBody
    public String getArticle(@PathVariable long numberOfArticles) {
        ArrayList<JournalArticle> mainArticles = mainArticlesDataService.retrieveArticles(numberOfArticles);
        ArrayList<JournalArticle> articles = articlesDataService.retrieveArticles((int) numberOfArticles-1);
        return gsonInstance.toJson(new ArticlesRequestResponse(articles, mainArticles.get(0)));
    }


}
