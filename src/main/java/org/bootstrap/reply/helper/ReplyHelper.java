package org.bootstrap.reply.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.mongorepository.ReplyMongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReplyHelper {
    private final ReplyMongoRepository replyMongoRepository;

    public List<Reply> findCommentList (Long postId) {
        return replyMongoRepository.findCommentDetailVos(postId);
    }

    public List<Reply> findReplyList (String parentsId) {
        return replyMongoRepository.findReplyDetailVos(parentsId);
    }

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
