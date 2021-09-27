package ru.tka.spring.parser.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.tka.spring.parser.parser.model.XmlFile;
import ru.tka.spring.parser.parser.repository.XmlFileRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class XmlService {
    @Autowired
    private XmlFileRepository xmlFileRepository;

    public XmlFile saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        try {
            XmlFile doc = new XmlFile(fileName,file.getContentType(),file.getBytes());
            return xmlFileRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<XmlFile> getFile(Long id) {
        return xmlFileRepository.findById(id);
    }

    public List<XmlFile> getFiles(){
        return xmlFileRepository.findAll();
    }
}
