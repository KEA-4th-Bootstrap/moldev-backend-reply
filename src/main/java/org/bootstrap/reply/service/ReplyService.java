package org.bootstrap.reply.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.helper.ReplyHelper;
import org.bootstrap.reply.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyHelper replyHelper;
    private final ReplyMapper replyMapper;
}
