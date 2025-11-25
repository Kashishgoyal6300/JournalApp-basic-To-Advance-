package com.journal.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.journal.journal.entity.JournalEntity;

public interface JournalRepository extends JpaRepository<JournalEntity, String> {

}
