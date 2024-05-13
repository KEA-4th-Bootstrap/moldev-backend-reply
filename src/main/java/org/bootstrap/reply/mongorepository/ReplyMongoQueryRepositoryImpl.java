package org.bootstrap.reply.mongorepository;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.vo.CommentReplyCountVo;
import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

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
    public List<CommentReplyCountVo> countAllByParentsId(List<String> parentsIdList) {
        MatchOperation matchStage = Aggregation.match(Criteria.where("parents_id").in(parentsIdList));
        GroupOperation groupStage = Aggregation.group("parents_id").count().as("total");

        Aggregation aggregation = Aggregation.newAggregation(matchStage, groupStage);
        AggregationResults<CommentReplyCountVo> results = mongoTemplate.aggregate(aggregation, "reply", CommentReplyCountVo.class);

        return results.getMappedResults();
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
