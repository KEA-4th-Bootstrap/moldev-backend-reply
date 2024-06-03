package org.bootstrap.reply.mongorepository;

import org.bootstrap.reply.entity.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReplyMongoRepository extends MongoRepository<Reply, String>, ReplyMongoQueryRepository {

    Long countByPostIdAndParentsIdIsNull(Long postId);

    Boolean existsByIdAndMemberId(String replyId, Long memberId);
}
