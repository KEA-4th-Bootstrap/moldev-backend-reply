package org.bootstrap.reply.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.common.SuccessResponse;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.dto.response.CommentCountResponseDto;
import org.bootstrap.reply.dto.response.CommentListResponseDto;
import org.bootstrap.reply.dto.response.ReplyListResponseDto;
import org.bootstrap.reply.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    // 게시글 댓글 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<CommentListResponseDto> getCommentList(@PathVariable("id") final Long postId) {
        final CommentListResponseDto responseDto = replyService.getCommentList(postId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 댓글의 답글 가져오기
    @GetMapping("")
    public ResponseEntity<ReplyListResponseDto> getReplyList(@RequestParam final String parentsId) {
        final ReplyListResponseDto responseDto = replyService.getReplyList(parentsId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    // 게시글에 달린 댓글 수 가져오기
    @GetMapping("/count/{id}")
    public ResponseEntity<CommentCountResponseDto> getPostCommentCount(@PathVariable("id") final Long postId) {
        final CommentCountResponseDto responseDto = replyService.getPostCommentCount(postId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
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
