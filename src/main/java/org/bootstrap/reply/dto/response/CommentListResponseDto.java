package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.entity.Reply;

import java.util.List;
import java.util.stream.Collectors;

@Builder(access = AccessLevel.PRIVATE)
public record CommentListResponseDto(
        List<CommentResponseDto> commentList,
        Integer totalCount
) {
    public static CommentListResponseDto of(List<Reply> replyList) {
        return CommentListResponseDto.builder()
                .commentList(replyList.stream()
                        .map(CommentResponseDto::of)
                        .collect(Collectors.toList()))
                .totalCount(replyList.size())
                .build();
    }
}
