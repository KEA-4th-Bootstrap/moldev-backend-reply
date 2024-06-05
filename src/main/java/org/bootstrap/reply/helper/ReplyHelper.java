package org.bootstrap.reply.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.common.error.ForbiddenException;
import org.bootstrap.reply.dto.response.ReplyPostIdResponseDto;
import org.bootstrap.reply.dto.vo.CommentReplyCountVo;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.kafka.KafkaProducer;
import org.bootstrap.reply.kafka.UpdateMessageDto;
import org.bootstrap.reply.mongorepository.ReplyMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ReplyHelper {
    private final ReplyMongoRepository replyMongoRepository;
    private final KafkaProducer kafkaProducer;

    public List<Reply> findCommentList(Long postId) {
        return replyMongoRepository.findCommentDetailVos(postId);
    }

    public List<Reply> findReplyList(String parentsId) {
        return replyMongoRepository.findReplyDetailVos(parentsId);
    }

    public void checkReplyWriter(Long memberId, String replyId) {
        if (!replyMongoRepository.existsByIdAndMemberId(replyId, memberId)) {
            throw ForbiddenException.EXCEPTION;
        }
    }

    public void updateReply(String replyId, String content) {
        replyMongoRepository.updateReplyById(replyId, content);
    }

    public void deleteReply(String replyId) {
        replyMongoRepository.deleteById(replyId);
    }

    public Reply saveReply(Reply reply, Long memberId) {
        Reply savedReply = replyMongoRepository.save(reply);
        kafkaProducer.send("update", UpdateMessageDto.of(savedReply, memberId));
        return savedReply;
    }

    public Long countPostComment(Long postId) {
        return replyMongoRepository.countByPostIdAndParentsIdIsNull(postId);
    }

    public List<CommentReplyCountVo> countCommentReply(List<Reply> commentList) {
        return replyMongoRepository.countAllByParentsId(
                commentList.stream()
                        .map(Reply::getId)
                        .collect(Collectors.toList()));
    }

    public ReplyPostIdResponseDto getReplyPostId(String replyId) {
        Reply reply = replyMongoRepository.findPostIdByReplyId(replyId);
        return ReplyPostIdResponseDto.of(reply);
    }
}
