package ru.tka.spring.parser.parser.controller;

import org.springframework.stereotype.Controller;
import ru.tka.spring.parser.parser.service.ContentService;

@Controller
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }
}
