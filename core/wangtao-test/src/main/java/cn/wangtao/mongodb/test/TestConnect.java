package cn.wangtao.mongodb.test;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

/**
 * @ClassName TestConnect
 * @Auth 桃子
 * @Date 2019-9-16 9:44
 * @Version 1.0
 * @Description
 **/
public class TestConnect {

    @Test
    public void testConnect1(){
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://root:0610@localhost:27017");
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        MongoDatabase database = mongoClient.getDatabase("xc_cms");
        MongoCollection<Document> collection = database.getCollection("cms_config");
        Document document = collection.find().first();
        System.out.println(document.toJson());

    }
}
