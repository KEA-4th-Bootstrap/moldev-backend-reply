package org.bootstrap.reply.dto.request;

public record ReplyUpdateRequestDto(
        String replyId,
        String content
) {
}
