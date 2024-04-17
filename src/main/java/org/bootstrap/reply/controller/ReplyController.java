package org.bootstrap.reply.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.common.SuccessResponse;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.service.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("{id}")
    public ResponseEntity<SuccessResponse<?>> updateReply(@PathVariable("id") String replyId,
                                                          @RequestBody ReplyUpdateRequestDto requestDto) {
        replyService.updateReply(replyId, requestDto);
        return SuccessResponse.ok(null);
    }
}
