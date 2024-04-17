package org.bootstrap.reply.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.common.SuccessResponse;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.dto.response.ReplyListResponseDto;
import org.bootstrap.reply.service.ReplyService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> getReplyList(@PathVariable("id") final Long postId,
                                                           @RequestParam(required = false) final String parentsId,
                                                           @RequestParam(required = false) final Pageable pageable) {
        final ReplyListResponseDto responseDto = replyService.getReplyList(postId, parentsId, pageable);
        return SuccessResponse.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<?>> createReply(@RequestBody final ReplyRequestDto requestDto) {
        replyService.createReply(requestDto);
        return SuccessResponse.created(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> updateReply(@PathVariable("id") final String replyId,
                                                          @RequestBody final ReplyUpdateRequestDto requestDto) {
        replyService.updateReply(replyId, requestDto);
        return SuccessResponse.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<?>> deleteReply(@PathVariable("id") final String replyId) {
        replyService.deleteReply(replyId);
        return SuccessResponse.ok(null);
    }
}
