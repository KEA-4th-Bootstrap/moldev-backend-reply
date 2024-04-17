package org.bootstrap.reply.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.repository.ReplyRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReplyHelper {
    private final ReplyRepository replyRepository;

    public Reply saveReply(Reply reply) {
        return replyRepository.save(reply);
    }
}
