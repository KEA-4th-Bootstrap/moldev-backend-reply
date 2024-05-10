package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record CommentResponseDto(
        String id,
        Long memberId,
        Long postId,
        String content,
        LocalDateTime createdAt
) {
    public static CommentResponseDto of(Reply reply) {
        return CommentResponseDto.builder()
                .id(reply.getId())
                .memberId(reply.getMemberId())
                .postId(reply.getPostId())
                .content(reply.getContent())
                .createdAt(reply.getCreateDate())
                .build();
    }
}
