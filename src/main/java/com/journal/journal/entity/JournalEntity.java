package com.journal.journal.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "journal_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntity {

    @Id
    private String id;
    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }
    // flexible ID (acts like Object but valid for JPA)

    private String title;
    private String content;
    private LocalDateTime date;
}
