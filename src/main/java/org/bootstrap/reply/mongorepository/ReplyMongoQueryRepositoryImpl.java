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
    public Slice<Reply> findReplyDetailVos(Long postId, String parentsId, Pageable pageable) {
        Query query = new Query()
                .with(pageable)
                .skip(pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize() + 1);
        query.with(Sort.by(Sort.Order.asc("lastModifiedDate")));
        query.addCriteria(getCriteriaForCondition(postId, parentsId));
        List<Reply> chats = mongoTemplate.find(query, Reply.class, "chatting");
        return new SliceImpl<>(chats, pageable, hasNextPage(chats, pageable.getPageSize()));
    }

    @Override
    public void updateReplyById(String replyId, String content) {
        Query query = new Query();
        Update update = new Update();

        query.addCriteria(Criteria.where("replyId").is(replyId));
        update.set("content", content);
        mongoTemplate.updateMulti(query, update, Reply.class);
    }

    private Criteria getCriteriaForCondition(Long postId, String parentsId) {
        if (Objects.isNull(parentsId))
            return Criteria.where("postId").is(postId);
        else
            return Criteria.where("postId").is(postId).and("parentsId").is(parentsId);
    }

    private boolean hasNextPage(List<Reply> chats, int pageSize) {
        if (chats.size() > pageSize) {
            chats.remove(pageSize);
            return true;
        }
        return false;
    }
}
