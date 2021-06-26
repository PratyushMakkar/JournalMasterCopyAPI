package journal.Code.JournalAPI.BusinessObjects;

import java.util.List;

public class ArticlesRequestResponse {

    JournalArticle mainArticle;
    List<JournalArticle> articles;


    public ArticlesRequestResponse(List<JournalArticle> articles, JournalArticle mainArticle) {
        this.articles= articles;
        this.mainArticle = mainArticle;
    }
}
