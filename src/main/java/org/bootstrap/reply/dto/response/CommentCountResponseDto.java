package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access= AccessLevel.PRIVATE)
public record CommentCountResponseDto(
        Long commentCount
) {
    public static CommentCountResponseDto of(Long commentCount) {
        return CommentCountResponseDto.builder()
                .commentCount(commentCount)
                .build();
    }
}
