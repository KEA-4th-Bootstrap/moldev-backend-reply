package org.bootstrap.reply.mongorepository;

import org.bootstrap.reply.entity.Reply;

import java.util.Optional;

public interface ReplyMongoQueryRepository {
    void updateReplyById(String replyId, String content);
}
