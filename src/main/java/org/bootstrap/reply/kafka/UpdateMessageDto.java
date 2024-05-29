package org.bootstrap.reply.kafka;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

@Builder(access = AccessLevel.PRIVATE)
public record UpdateMessageDto(
        Long memberId,
        Long postId
) {
    public static UpdateMessageDto of(Reply reply, Long memberId) {
        return UpdateMessageDto.builder()
                .memberId(memberId)
                .postId(reply.getPostId())
                .build();
    }
}
