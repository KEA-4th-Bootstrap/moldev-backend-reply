package org.bootstrap.reply.mongorepository;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class ReplyMongoQueryRepositoryImpl implements ReplyMongoQueryRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Reply> findCommentDetailVos(Long postId) {
        Query query = new Query();
        query.with(Sort.by(Sort.Order.asc("lastModifiedDate")));
        query.addCriteria(Criteria.where("postId").is(postId).and("parentsId").isNull());
        List<Reply> commentList = mongoTemplate.find(query, Reply.class, "reply");
        return commentList;
    }

    @Override
    public List<Reply> findReplyDetailVos(String parentsId) {
        Query query = new Query();
        query.with(Sort.by(Sort.Order.asc("lastModifiedDate")));
        query.addCriteria(Criteria.where("parentsId").is(parentsId));
        List<Reply> replyList = mongoTemplate.find(query, Reply.class, "reply");
        return replyList;
    }

    @Override
    public void updateReplyById(String replyId, String content) {
        Query query = new Query();
        Update update = new Update();

        query.addCriteria(Criteria.where("replyId").is(replyId));
        update.set("content", content);
        mongoTemplate.updateMulti(query, update, Reply.class);
    }

    private boolean hasNextPage(List<Reply> chats, int pageSize) {
        if (chats.size() > pageSize) {
            chats.remove(pageSize);
            return true;
        }
        return false;
    }
}
