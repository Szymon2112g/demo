package com.learn.demo.Controller;

import com.learn.demo.Entity.News;
import com.learn.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MongoController {

    @Autowired
    NewsService newsService;

    @GetMapping("/mongodb/getall")
    public List<News> getNews() {
        return newsService.getAll();
    }

    @DeleteMapping("/mongodb/delete/{id}")
    public ResponseEntity<Void> deleteNews(
            @PathVariable String id
    ) {
        newsService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mongodb/getsinglenews/{id}")
    public News getSingleNews(
            @PathVariable String id
    ) {
        return newsService.findById(id);
    }

    @PutMapping("/mongodb/updatenews/{id}")
    public ResponseEntity<News> updateNews(
            @RequestBody News news
    ) {

        News news1 = newsService.save(news);
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    @PostMapping("/mongodb/createNews/")
    public ResponseEntity<News> createNews(
            @RequestBody News news
    ) {
        News createdNews = newsService.save(news);

        return new ResponseEntity<News>(news, HttpStatus.OK);
    }
}
