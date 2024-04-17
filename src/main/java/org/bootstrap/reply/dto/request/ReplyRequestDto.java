package org.bootstrap.reply.dto.request;

public record ReplyRequestDto(
        Long memberId,
        Long postId,
        String replyId,
        String content
) {
}
