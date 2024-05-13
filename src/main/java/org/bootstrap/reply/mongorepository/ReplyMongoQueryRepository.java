package org.bootstrap.reply.mongorepository;

import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ReplyMongoQueryRepository {
    List<Reply> findCommentDetailVos(Long postId);

    List<Reply> findReplyDetailVos(String parentsId);

    void updateReplyById(String replyId, String content);
}
