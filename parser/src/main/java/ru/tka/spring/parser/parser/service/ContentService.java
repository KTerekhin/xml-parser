package ru.tka.spring.parser.parser.service;

import org.springframework.stereotype.Service;
import ru.tka.spring.parser.parser.repository.ContentRepository;
import ru.tka.spring.parser.parser.repository.XmlFileRepository;
import ru.tka.spring.parser.parser.util.DOMParser;

@Service
public class ContentService {
    private final ContentRepository contentRepository;
    private final DOMParser domParser;
    private final XmlFileRepository xmlFileRepository;

    public ContentService(ContentRepository contentRepository, DOMParser domParser, XmlFileRepository xmlFileRepository) {
        this.contentRepository = contentRepository;
        this.domParser = domParser;
        this.xmlFileRepository = xmlFileRepository;
    }

//    public String getContent(Long id) {
//        File file = new File(xmlFileRepository.getById(id))
//    }
}
