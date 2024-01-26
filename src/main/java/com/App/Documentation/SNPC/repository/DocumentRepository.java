package com.App.Documentation.SNPC.repository;

import com.App.Documentation.SNPC.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
