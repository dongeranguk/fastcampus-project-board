package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.Hashtag;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record HashtagWithArticleDto(
        Long id,
        Set<ArticleDto> articleDtos,
        String hashtagName,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedby
) {

    public static HashtagWithArticleDto of(Set<ArticleDto> articleDtos, String hashtagName) {
        return new HashtagWithArticleDto(null, articleDtos, hashtagName, null, null, null, null);
    }

    public static HashtagWithArticleDto of(Long id, Set<ArticleDto> articleDtos, String hashtagName, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedby) {
        return new HashtagWithArticleDto(id, articleDtos, hashtagName, createdAt, createdBy, modifiedAt, modifiedby);
    }

    public static HashtagWithArticleDto from(Hashtag entity) {
        return new HashtagWithArticleDto(
                entity.getId(),
                entity.getArticles().stream()
                        .map(ArticleDto::from)
                        .collect(Collectors.toUnmodifiableSet())
                ,
                entity.getHashtagName(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Hashtag toEntity() { return Hashtag.of(hashtagName); }
}
