package org.bootstrap.reply.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bootstrap.reply.common.BaseTimeEntity;
import org.bootstrap.reply.dto.request.ReplyRequestDto;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Document(collection = "reply")
public class Reply extends BaseTimeEntity {
    @Id
    @Field(name="_id")
    private String id;
    @Field(name="member_id")
    private Long memberId;
    @Field(name="post_id")
    private Long postId;
    @Field(name="content")
    private String content;
    @Field(name="parents_id")
    private String parentsId;

    public static Reply createReply(Long memberId, ReplyRequestDto replyRequestDto) {
        return Reply.builder()
                .memberId(memberId)
                .postId(replyRequestDto.postId())
                .content(replyRequestDto.content())
                .parentsId(replyRequestDto.parentsId())
                .build();
    }
}
