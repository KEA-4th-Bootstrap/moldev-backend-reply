package org.bootstrap.reply.controller;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.dto.response.*;
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

    // 댓글이 달린 postId 가져오기
    @GetMapping("/post-id")
    public ResponseEntity<ReplyResponseDto> getReply(@RequestParam final String replyId) {
        final ReplyResponseDto responseDto = replyService.getReply(replyId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PostMapping
    public ResponseEntity<DefaultSuccessResponseDto> createReply(@RequestHeader("Authorization") final Long memberId,
                                                                 @RequestBody final ReplyRequestDto requestDto) {
        replyService.createReply(memberId, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(DefaultSuccessResponseDto.ok());
    }

    @PatchMapping
    public ResponseEntity<DefaultSuccessResponseDto> updateReply(@RequestHeader("Authorization") final Long memberId,
                                                                 @RequestBody final ReplyUpdateRequestDto requestDto) {
        replyService.updateReply(memberId, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(DefaultSuccessResponseDto.ok());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultSuccessResponseDto> deleteReply(@RequestHeader("Authorization") final Long memberId,
                                                                 @PathVariable("id") final String replyId) {
        replyService.deleteReply(memberId, replyId);
        return ResponseEntity.status(HttpStatus.OK).body(DefaultSuccessResponseDto.ok());
    }
}
