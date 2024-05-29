package org.bootstrap.reply.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.dto.response.CommentCountResponseDto;
import org.bootstrap.reply.dto.response.CommentListResponseDto;
import org.bootstrap.reply.dto.response.ReplyListResponseDto;
import org.bootstrap.reply.dto.vo.CommentReplyCountVo;
import org.bootstrap.reply.entity.Reply;
import org.bootstrap.reply.helper.ReplyHelper;
import org.bootstrap.reply.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyHelper replyHelper;
    private final ReplyMapper replyMapper;

    public CommentListResponseDto getCommentList(Long postId) {
        List<Reply> commentList = replyHelper.findCommentList(postId);
        List<CommentReplyCountVo> commentReplyCountList = replyHelper.countCommentReply(commentList);
        return replyMapper.toCommentListResponseDto(commentList, commentReplyCountList);
    }

    public ReplyListResponseDto getReplyList(String parentsId) {
        List<Reply> replyList = replyHelper.findReplyList(parentsId);
        return replyMapper.toReplyListResponseDto(replyList);
    }

    public CommentCountResponseDto getPostCommentCount(Long postId) {
        Long commentCount = replyHelper.countPostComment(postId);
        return CommentCountResponseDto.of(commentCount);
    }

    public void createReply(Long memberId, ReplyRequestDto requestDto) {
        Reply reply = createReplyAndSave(memberId, requestDto);
    }

    public void updateReply(Long memberId, ReplyUpdateRequestDto replyUpdateRequestDto) {
        replyHelper.checkReplyWriter(memberId, replyUpdateRequestDto.replyId());
        replyHelper.updateReply(replyUpdateRequestDto.replyId(), replyUpdateRequestDto.content());
    }

    public void deleteReply(Long memberId, String replyId) {
        replyHelper.checkReplyWriter(memberId, replyId);
        replyHelper.deleteReply(replyId);
    }

    private Reply createReplyAndSave(Long memberId, ReplyRequestDto requestDto) {
        Reply reply = replyMapper.toEntity(memberId, requestDto);
        return replyHelper.saveReply(reply, memberId);
    }

    private boolean isParentsIdNull(String parentsId){
        return parentsId==null;
    }
}
