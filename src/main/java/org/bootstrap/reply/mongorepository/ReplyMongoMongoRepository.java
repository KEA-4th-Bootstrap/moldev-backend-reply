package org.bootstrap.reply.mongorepository;

import org.bootstrap.reply.entity.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReplyMongoMongoRepository extends MongoRepository<Reply, String>, ReplyMongoQueryRepository {
}
