package com.example.exo4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @GetMapping("/api/articles")
    public Flux<String> getArticle(){
        return articleService.getArticle()
                .map(n ->n.getNom());
    }
}
