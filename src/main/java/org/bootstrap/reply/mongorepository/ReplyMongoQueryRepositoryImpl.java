package org.bootstrap.reply.mongorepository;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.entity.Reply;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@RequiredArgsConstructor
public class ReplyMongoQueryRepositoryImpl implements ReplyMongoQueryRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public void updateReplyById(String replyId, String content) {
        Query query = new Query();
        Update update = new Update();

        query.addCriteria(Criteria.where("replyId").is(replyId));
        update.set("content", content);
        mongoTemplate.updateMulti(query, update, Reply.class);
    }
}
