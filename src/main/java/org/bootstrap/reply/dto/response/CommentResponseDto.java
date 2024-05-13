package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

import java.time.LocalDateTime;

import static org.bootstrap.reply.utils.EntityUpdateValueUtils.updateValue;

@Builder(access = AccessLevel.PRIVATE)
public record CommentResponseDto(
        String id,
        Long memberId,
        Long postId,
        String content,
        Long replyCount,
        LocalDateTime createdAt
) {
    public static CommentResponseDto of(Reply reply, Long replyCount) {
        return CommentResponseDto.builder()
                .id(reply.getId())
                .memberId(reply.getMemberId())
                .postId(reply.getPostId())
                .content(reply.getContent())
                .replyCount(updateValue(0L, replyCount))
                .createdAt(reply.getCreateDate())
                .build();
    }
}
