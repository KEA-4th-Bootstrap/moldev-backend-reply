package org.bootstrap.reply.mapper;

import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.response.CommentListResponseDto;
import org.bootstrap.reply.dto.response.ReplyListResponseDto;
import org.bootstrap.reply.entity.Reply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplyMapper {
    public Reply toEntity(ReplyRequestDto replyRequestDto) {
        return Reply.createReply(replyRequestDto);
    }

    public ReplyListResponseDto toReplyListResponseDto(List<Reply> replyList) {
        return ReplyListResponseDto.of(replyList);
    }
    public CommentListResponseDto toCommentListResponseDto(List<Reply> replyList) {
        return CommentListResponseDto.of(replyList);
    }
}
