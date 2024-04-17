package org.bootstrap.reply.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import org.bootstrap.reply.common.PageInfo;
import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Slice;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record ReplyListResponseDto(
        List<Reply> replys,
        PageInfo pageInfo
) {
    public static ReplyListResponseDto of(Slice<Reply> replySlice) {
        return ReplyListResponseDto.builder()
                .replys(replySlice.getContent())
                .pageInfo(PageInfo.of(replySlice))
                .build();
    }
}
