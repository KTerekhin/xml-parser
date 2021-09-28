package ru.tka.spring.parser.parser.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.tka.spring.parser.parser.model.XmlFile;
import ru.tka.spring.parser.parser.service.XmlService;

import java.io.IOException;
import java.util.List;

@Controller
public class XmlController {
    private final XmlService xmlService;

    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @GetMapping("/")
    public String get(Model model) {
        List<XmlFile> files = xmlService.getFiles();
        model.addAttribute("files", files);
        return "main";
    }

    @PostMapping("/uploadFiles")
    public String addFile(@RequestParam("file") MultipartFile file) throws IOException {
        xmlService.saveFile(file);
        return "redirect:/";
    }

    @GetMapping("/showFile/{id}")
    public ResponseEntity<ByteArrayResource> showFile(@PathVariable Long id){
        XmlFile file = xmlService.getFile(id).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFiletype()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+file.getFilename()+"\"")
                .body(new ByteArrayResource(file.getData()));
    }

    //TODO
    //@GetMapping("/showContent/{id}")
}
