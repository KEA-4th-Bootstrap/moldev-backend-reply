package org.bootstrap.reply.mapper;

import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.response.CommentListResponseDto;
import org.bootstrap.reply.dto.response.ReplyListResponseDto;
import org.bootstrap.reply.dto.vo.CommentReplyCountVo;
import org.bootstrap.reply.entity.Reply;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReplyMapper {
    public Reply toEntity(Long memberId, ReplyRequestDto replyRequestDto) {
        return Reply.createReply(memberId, replyRequestDto);
    }

    public ReplyListResponseDto toReplyListResponseDto(List<Reply> replyList) {
        return ReplyListResponseDto.of(replyList);
    }
    public CommentListResponseDto toCommentListResponseDto(List<Reply> commentList, List<CommentReplyCountVo> commentReplyCountList) {
        return CommentListResponseDto.of(commentList, commentReplyCountList);
    }
}
