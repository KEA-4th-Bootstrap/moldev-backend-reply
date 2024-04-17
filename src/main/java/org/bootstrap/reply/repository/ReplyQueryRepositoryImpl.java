package org.bootstrap.reply.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ReplyQueryRepositoryImpl implements ReplyQueryRepository{
    private final MongoTemplate mongoTemplate;

}
