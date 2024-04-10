package org.bootstrap.reply.helper;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.repository.ReplyRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReplyHelper {
    private final ReplyRepository replyRepository;
}
