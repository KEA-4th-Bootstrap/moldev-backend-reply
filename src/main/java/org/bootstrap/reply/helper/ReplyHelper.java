package org.bootstrap.reply.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.mongorepository.ReplyMongoMongoRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReplyHelper {
    private final ReplyMongoMongoRepository replyMongoRepository;

    public Reply saveReply(Reply reply) {
        return replyMongoRepository.save(reply);
    }
}
