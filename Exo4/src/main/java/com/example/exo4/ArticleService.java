package com.example.exo4;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ArticleService {
    List<Article> articles;

    public ArticleService (){
        articles.add(new Article("1", "Introduction to Spring WebFlux"));
        articles.add(new Article("2", "Reactive Programming with Project Reactor"));
        articles.add(new Article("3", "Building APIs with Spring Boot"));
    }

    public Flux<Article> getArticle(){
        return Flux.just((Article) articles);
    }
}
