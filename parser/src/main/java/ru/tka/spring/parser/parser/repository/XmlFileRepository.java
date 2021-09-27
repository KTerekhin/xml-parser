package ru.tka.spring.parser.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tka.spring.parser.parser.model.XmlFile;

@Repository
public interface XmlFileRepository extends JpaRepository<XmlFile, Long> {
}
