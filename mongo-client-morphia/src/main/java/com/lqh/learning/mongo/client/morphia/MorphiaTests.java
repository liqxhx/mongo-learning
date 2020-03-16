package com.lqh.learning.mongo.client.morphia;

import com.lqh.learning.mongo.client.entity.OperateRecords;
import com.mongodb.MongoClient;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

/**
 * <p> 类描述: Morphia CRUD Tests
 *
 * @author liqxhx
 * @version TODO
 * @date 2020/03/16 22:58
 * @since 2020/03/16 22:58
 */
public class MorphiaTests {
    @Test
    public void testCreate() {
        final Morphia morphia = new Morphia();
        Datastore ds = morphia.createDatastore(new MongoClient("localhost",27017),"gupaoedu-demo");

        for (int i = 0; i < 50; i++) {
            OperateRecords operateRecords = OperateRecords.builder()
                    .action("add")
                    .time(System.nanoTime())
                    .content("test morphia " + i)
                    .build();

            Key<OperateRecords> key = ds.save(operateRecords);

            System.out.println(key.getId());
        }

    }
}
