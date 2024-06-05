package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

@Builder(access = AccessLevel.PRIVATE)
public record ReplyPostIdResponseDto(
        Long postId
) {
    public static ReplyPostIdResponseDto of(Reply reply) {
        return ReplyPostIdResponseDto.builder()
                .postId(reply.getPostId())
                .build();
    }
}
