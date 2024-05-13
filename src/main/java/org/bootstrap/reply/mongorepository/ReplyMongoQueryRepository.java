package org.bootstrap.reply.mongorepository;

import org.bootstrap.reply.dto.vo.CommentReplyCountVo;
import org.bootstrap.reply.entity.Reply;

import java.util.List;

public interface ReplyMongoQueryRepository {
    List<Reply> findCommentDetailVos(Long postId);

    List<Reply> findReplyDetailVos(String parentsId);

    List<CommentReplyCountVo> countAllByParentsId(List<String> parentsIdList);

    void updateReplyById(String replyId, String content);
}
