package org.bootstrap.reply.dto.request;

public record ReplyRequestDto(
        Long postId,
        String parentsId,
        String content
) {
}
