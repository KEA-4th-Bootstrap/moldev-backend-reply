package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.dto.vo.CommentReplyCountVo;
import org.bootstrap.reply.entity.Reply;

import java.util.List;
import java.util.stream.Collectors;

@Builder(access = AccessLevel.PRIVATE)
public record CommentListResponseDto(
        List<CommentResponseDto> commentList
) {
    public static CommentListResponseDto of(List<Reply> replyList, List<CommentReplyCountVo> replyCountList) {
        return CommentListResponseDto.builder()
                .commentList(replyList.stream()
                        .map(comment -> CommentResponseDto.of(comment, getReplyCount(comment.getId(), replyCountList)))
                        .collect(Collectors.toList()))
                .build();
    }

    // 게시글 댓글에 달린 답글 수 매핑
    private static Long getReplyCount(String id, List<CommentReplyCountVo> replyCountList) {
        return replyCountList.stream()
                .filter(vo -> vo.id().equals(id))
                .map(CommentReplyCountVo::total)
                .findFirst()
                .orElse(null); // ID가 일치하는 항목이 없으면 null 반환
    }
}
