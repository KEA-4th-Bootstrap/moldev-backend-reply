package org.bootstrap.reply.mapper;

import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.response.CommentReplyListResponseDto;
import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public Reply toEntity(ReplyRequestDto replyRequestDto) {
        return Reply.createReply(replyRequestDto);
    }

    public CommentReplyListResponseDto toReplyListResponseDto(Slice<Reply> replySlice) {
        return CommentReplyListResponseDto.createReplyResponse(replySlice);
    }
    public CommentReplyListResponseDto toCommentListResponseDto(Slice<Reply> commentSlice) {
        return CommentReplyListResponseDto.createCommentResponse(commentSlice);
    }
}
