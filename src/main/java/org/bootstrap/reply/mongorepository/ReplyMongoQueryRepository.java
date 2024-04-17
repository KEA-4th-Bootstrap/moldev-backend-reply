package org.bootstrap.reply.mongorepository;

import org.bootstrap.reply.entity.Reply;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReplyMongoQueryRepository {
    Slice<Reply> findReplyDetailVos(Long postId, String parentsId, Pageable pageable);

    void updateReplyById(String replyId, String content);
}
