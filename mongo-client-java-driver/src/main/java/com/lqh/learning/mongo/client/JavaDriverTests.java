package com.lqh.learning.mongo.client;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.UUID;

import org.junit.Test;

/**
 * <p> 类描述: MongoJavaDriverTests
 *
 * @author liqxhx
 * @version 1.0
 * @date 2020/03/14 09:55
 * @since 2020/03/14 09:55
 */
public class JavaDriverTests {
    @Test
    public void testCurd() {
        Mongo mongo = new Mongo("localhost", 27017);

        DB db = new DB(mongo, "cc");

        DBCollection dbCollection = db.getCollection("t_operate_records");

        for (int i = 0; i < 10; i++) {
            DBObject dbObject = new BasicDBObject();
            dbObject.put("id", UUID.randomUUID().toString());
            dbObject.put("action", i%2==0? "add" : "modify");
            dbObject.put("time", System.nanoTime());
            dbObject.put("content", "do something "+ i);

            dbCollection.insert(dbObject);
        }

        DBCursor dbCursor = dbCollection.find();
        for (DBObject obj : dbCursor) {
            System.out.println(obj.toString());
        }

    }

    @Test
    public void testNativeAPI(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongo-learning");

        MongoCollection mongoCollection = mongoDatabase.getCollection("t_logs");

        Document document = new Document("id", UUID.randomUUID().toString());
        document.append("timestampNano", System.nanoTime());
        document.append("desc", "hello mongo");

        mongoCollection.insertOne(document);
    }
}
