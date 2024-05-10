package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.common.PageInfo;
import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

@Builder(access = AccessLevel.PRIVATE)
public record CommentReplyListResponseDto(
        List<?> commentReplys,
        PageInfo pageInfo
) {
    public static CommentReplyListResponseDto createReplyResponse(Slice<Reply> replySlice) {
        return CommentReplyListResponseDto.builder()
                .commentReplys(replySlice.getContent().stream()
                        .map(ReplyResponseDto::of)
                        .collect(Collectors.toList()))
                .pageInfo(PageInfo.of(replySlice))
                .build();
    }

    public static CommentReplyListResponseDto createCommentResponse(Slice<Reply> replySlice) {
        return CommentReplyListResponseDto.builder()
                .commentReplys(replySlice.getContent().stream()
                        .map(CommentResponseDto::of)
                        .collect(Collectors.toList()))
                .pageInfo(PageInfo.of(replySlice))
                .build();
    }
}
