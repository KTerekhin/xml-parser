package ru.tka.spring.parser.parser.model;

import javax.persistence.*;

@Entity
@Table(name = "content")
public class Content {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tag")
    private String tag;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "raw_id")
    private XmlFile xmlFile;

    public Content() {
    }

    public Content(String tag, String content) {
        this.tag = tag;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public XmlFile getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(XmlFile xmlFile) {
        this.xmlFile = xmlFile;
    }

    @Override
    public String toString() {
        return "Content {" +
                "tag='" + tag + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
