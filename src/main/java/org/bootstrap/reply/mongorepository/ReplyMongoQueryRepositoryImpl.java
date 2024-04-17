package org.bootstrap.reply.mongorepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

@RequiredArgsConstructor
public class ReplyMongoQueryRepositoryImpl implements ReplyMongoQueryRepository {
    private final MongoTemplate mongoTemplate;

}
