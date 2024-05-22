package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record DefaultSuccessResponseDto(
        String message
) {
    public static DefaultSuccessResponseDto ok() {
        return DefaultSuccessResponseDto.builder()
                .message("요청에 성공했습니다.")
                .build();
    }
}
