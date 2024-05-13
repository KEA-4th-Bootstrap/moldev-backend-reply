package org.bootstrap.reply.service;

import lombok.RequiredArgsConstructor;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.bootstrap.reply.dto.request.ReplyUpdateRequestDto;
import org.bootstrap.reply.dto.response.CommentListResponseDto;
import org.bootstrap.reply.dto.response.ReplyListResponseDto;
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
        return replyMapper.toCommentListResponseDto(commentList);
    }

    public ReplyListResponseDto getReplyList(String parentsId) {
        List<Reply> replyList = replyHelper.findReplyList(parentsId);
        return replyMapper.toReplyListResponseDto(replyList);
    }


    public void createReply(ReplyRequestDto requestDto) {
        Reply reply = createReplyAndSave(requestDto);
    }

    public void updateReply(String replyId, ReplyUpdateRequestDto replyUpdateRequestDto) {
        replyHelper.updateReply(replyId, replyUpdateRequestDto);
    }

    public void deleteReply(String replyId) {
        replyHelper.deleteReply(replyId);
    }

    private Reply createReplyAndSave(ReplyRequestDto requestDto) {
        Reply reply = replyMapper.toEntity(requestDto);
        return replyHelper.saveReply(reply);
    }

    private boolean isParentsIdNull(String parentsId){
        return parentsId==null;
    }
}
