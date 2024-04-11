package org.bootstrap.reply.repository;

import org.bootstrap.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long>, ReplyQueryRepository {
}
