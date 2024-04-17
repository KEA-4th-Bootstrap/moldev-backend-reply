package org.bootstrap.reply.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.helper.ReplyHelper;
import org.bootstrap.reply.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyHelper replyHelper;
    private final ReplyMapper replyMapper;

    public void createReply(ReplyRequestDto requestDto) {
        Reply reply = createReplyAndSave(requestDto);
    }

    private Reply createReplyAndSave(ReplyRequestDto requestDto) {
        Reply reply = replyMapper.toEntity(requestDto);
        return replyHelper.saveReply(reply);
    }
}
