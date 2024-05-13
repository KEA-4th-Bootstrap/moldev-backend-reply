package org.bootstrap.reply.dto.vo;

import org.springframework.data.mongodb.core.mapping.Field;

public record CommentReplyCountVo(
        @Field("_id")
        String id,
        Long total
) {
}
