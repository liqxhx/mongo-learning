package com.lqh.learning.mongo.client;

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
    public void test1(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase mongoDatabase = mongoClient.getDatabase("mongo-learning");

        MongoCollection mongoCollection = mongoDatabase.getCollection("t_logs");

        Document document = new Document("id", UUID.randomUUID().toString());
        document.append("timestampNano", System.nanoTime());
        document.append("desc", "hello mongo");

        mongoCollection.insertOne(document);
    }
}
