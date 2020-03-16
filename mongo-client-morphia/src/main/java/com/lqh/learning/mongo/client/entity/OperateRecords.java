package com.lqh.learning.mongo.client.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

/**
 * <p> 类描述: 操作记录
 *
 * @author liqxhx
 * @version 1.0
 * @date 2020/03/16 23:29
 * @since 2020/03/16 23:29
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OperateRecords {
    @Id
    private ObjectId id;

    private String action;

    private long time;

    private String content;
}
