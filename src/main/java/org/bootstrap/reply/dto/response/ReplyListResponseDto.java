package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

import java.util.List;
import java.util.stream.Collectors;

@Builder(access = AccessLevel.PRIVATE)
public record ReplyListResponseDto(
        List<ReplyResponseDto> replyList,
        Integer totalCount
) {
    public static ReplyListResponseDto of(List<Reply> replyList) {
        return ReplyListResponseDto.builder()
                .replyList(replyList.stream()
                        .map(ReplyResponseDto::of)
                        .collect(Collectors.toList()))
                .totalCount(replyList.size())
                .build();
    }
}
