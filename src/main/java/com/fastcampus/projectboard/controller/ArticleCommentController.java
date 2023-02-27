package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.dto.UserAccountDto;
import com.fastcampus.projectboard.dto.request.ArticleCommentRequest;
import com.fastcampus.projectboard.dto.security.BoardPrincipal;
import com.fastcampus.projectboard.service.ArticleCommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    public ArticleCommentController(ArticleCommentService articleCommentService) {
        this.articleCommentService = articleCommentService;
    }

    @PostMapping("/new")
    public String postArticleComment(@AuthenticationPrincipal BoardPrincipal boardPrincipal,
                                     ArticleCommentRequest articleCommentRequest) {

        articleCommentService.saveArticleComment(articleCommentRequest.toDto(boardPrincipal.toDto()));


        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable Long commentId,
                                       @AuthenticationPrincipal BoardPrincipal boardPrincipal,
                                       Long articleId) {

        articleCommentService.deleteArticleComment(commentId, boardPrincipal.getUsername());

        return "redirect:/articles/" + articleId;
    }

}
