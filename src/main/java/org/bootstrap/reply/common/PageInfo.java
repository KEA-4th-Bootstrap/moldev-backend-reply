package org.bootstrap.reply.common;

import lombok.AccessLevel;
import lombok.Builder;
import org.springframework.data.domain.Slice;

import static org.bootstrap.reply.utils.EntityUpdateValueUtils.updateValue;

@Builder(access = AccessLevel.PRIVATE)
public record PageInfo(
        Boolean hasNextPage,
        Integer pageNumber
) {
    public static PageInfo of(Slice<?> page) {
        return PageInfo.builder()
                .hasNextPage(updateValue(null, page.hasNext()))
                .pageNumber(updateValue(null, page.getNumber()))
                .build();
    }
}
