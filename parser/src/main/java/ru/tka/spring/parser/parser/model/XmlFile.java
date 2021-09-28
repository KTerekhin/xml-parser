package ru.tka.spring.parser.parser.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "test_file")
public class XmlFile {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "file")
    private byte[] data;

    public XmlFile() {
    }

    public XmlFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    public String getFiletype() {
        return fileType;
    }

    public void setFiletype(String fileType) {
        this.fileType = fileType;
    }
}
