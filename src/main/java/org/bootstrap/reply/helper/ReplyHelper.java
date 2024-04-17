package org.bootstrap.reply.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.mongorepository.ReplyMongoRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReplyHelper {
    private final ReplyMongoRepository replyMongoRepository;

    public void updateReply(String replyId, ReplyUpdateRequestDto replyUpdateRequestDto) {
        replyMongoRepository.updateReplyById(replyId, replyUpdateRequestDto.content());
    }

    public void deleteReply(String replyId) {
        replyMongoRepository.deleteById(replyId);
    }

    public Reply saveReply(Reply reply) {
        return replyMongoRepository.save(reply);
    }
}
