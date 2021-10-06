import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCursor;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.*;

public class main {
    public static void main(String[] args) {
        // Question 11 :
        MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        // Question 12 :
        MongoDatabase database = mongoClient.getDatabase("dbma");
        MongoCollection<Document> movies = database.getCollection("movies");
        // Question 13 :
        System.out.println(movies.find().first().toJson());
        // Question 14 :
        System.out.println(movies.countDocuments());
        // Question 15 :
        MongoCursor<Document> cursor = movies.find(gte("release_year", 1995)).iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            System.out.println(doc.toJson());
        }
        // Question 16 :
        Document document = new Document().append("title", "Logan");
        movies.insertOne(document);
        System.out.println(movies.find(eq("title", "Logan")).first().toJson());
        // Question 17 :
        movies.updateOne(eq("title", "Logan"), new Document("$set", new Document("release", "03-03-2017")));
        System.out.println(movies.find(eq("title", "Logan")).first().toJson());
        // Question 18 :
        movies.deleteOne(eq("title", "Logan"));


    }
}
