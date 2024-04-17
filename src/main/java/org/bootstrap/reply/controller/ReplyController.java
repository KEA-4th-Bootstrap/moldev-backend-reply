package org.bootstrap.reply.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.common.SuccessResponse;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.service.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> createReply(@RequestBody ReplyRequestDto requestDto) {
        replyService.createReply(requestDto);
        return SuccessResponse.ok(null);
    }
}
