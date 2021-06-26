package journal.Code.JournalAPI.BusinessObjects.Deserielization;

import com.google.gson.*;
import journal.Code.JournalAPI.BusinessObjects.JournalArticle;

import java.lang.reflect.Type;

public class CustomArticleDeserializer implements JsonDeserializer<JournalArticle> {

    @Override
    public JournalArticle deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JournalArticle article = new JournalArticle(
                jsonObject.get("authorName").getAsString(),
                jsonObject.get("title").getAsString(),
                jsonObject.get("description").getAsString(),
                jsonObject.get("url").getAsString(),
                jsonObject.get("date").getAsString()
        );
        if (! (jsonObject.get("id") == null)) {
            article.setID(jsonObject.get("id").getAsInt());
        }
        return article;

    }
}
