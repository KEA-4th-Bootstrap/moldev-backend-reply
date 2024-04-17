package org.bootstrap.reply.mapper;

import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.entity.Reply;
import org.springframework.stereotype.Component;

@Component
public class ReplyMapper {
    public Reply toEntity(ReplyRequestDto replyRequestDto) {
        return Reply.createReply(replyRequestDto);
    }
}
