package journal.Code.JournalAPI.RestControllers;

import com.google.gson.Gson;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;
import journal.Code.JournalAPI.DataAccess.ArticlesDataService;
import journal.Code.JournalAPI.DataAccess.MainArticlesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController("/articles/moderate/")
public class ModeratorsController {

    @Qualifier("customDeserializer")
    @Autowired
    Gson gsonInstance;

    @Qualifier("getArticlesDataService")
    @Autowired
    ArticlesDataService articlesDataService;

    @Qualifier("getMainArticlesDataService")
    @Autowired
    MainArticlesDataService mainArticlesDataService;

    @Value("{Password}")
    String password;


    @PostMapping("articles/moderate/delete")
    public String deleteArticle(@RequestBody String name) {
        return name;
    }

    @PostMapping("articles/moderate/mainArticle/delete")
    public String deleteMainArticle(@RequestBody String article) {
        return article;
    }

    @PostMapping("/articles/moderate/upload/{UrlPassword}")    //Complete and Tested
    @ResponseBody
    public String PostArticle(@RequestBody String article, @PathVariable("UrlPassword") String UrlPassword) {
        if (UrlPassword!=password) {
            JournalArticle journalArticle = gsonInstance.fromJson(article, JournalArticle.class);
            return this.articlesDataService.uploadArticle(journalArticle).serializeToJson();
        }
        return null;
    }

    @PostMapping("/articles/moderate/mainArticle/upload/{UrlPassword}")        //Mapping works!
    @ResponseBody
    public String PostMainArticle(@RequestBody String article, @PathVariable("UrlPassword") String UrlPassword) {
        if (UrlPassword!=password) {
            JournalArticle journalArticle = gsonInstance.fromJson(article, JournalArticle.class);
            return this.mainArticlesDataService.uploadArticle(journalArticle).serializeToJson();
        }
        return null;
    }

}
