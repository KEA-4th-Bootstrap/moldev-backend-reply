package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

import java.time.LocalDateTime;

@Builder(access = AccessLevel.PRIVATE)
public record ReplyResponseDto(
        String id,
        Long memberId,
        Long postId,
        String content,
        String parentsId,
        LocalDateTime createdAt
) {
    public static ReplyResponseDto of(Reply reply) {
        return ReplyResponseDto.builder()
                .id(reply.getId())
                .memberId(reply.getMemberId())
                .postId(reply.getPostId())
                .content(reply.getContent())
                .parentsId(reply.getParentsId())
                .createdAt(reply.getCreateDate())
                .build();
    }
}
