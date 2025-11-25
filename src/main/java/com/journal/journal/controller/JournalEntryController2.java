package com.journal.journal.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.journal.journal.entity.JournalEntity;
import com.journal.journal.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController2 {

    @Autowired
    private JournalEntryService service;

    // Get all entries
    @GetMapping
    public List<JournalEntity> getAll() {
        return service.getAll();
    }

    // Create new entry
    @PostMapping
    public JournalEntity createEntry(@RequestBody JournalEntity entry) {
        entry.setDate(LocalDateTime.now());
        return service.saveEntry(entry);
    }

    // Get by ID
    @GetMapping("/{id}")
    public JournalEntity getJournalEntityById(@PathVariable String id) {
        return service.findById(id).orElse(null);
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public boolean deleteJournalEntityById(@PathVariable String id) {
        service.deleteById(id);
        return true;
    }

    // Update by ID
    @PutMapping("/{id}")
    public JournalEntity updateJournalEntityById(
            @PathVariable String id,
            @RequestBody JournalEntity entry) {

        JournalEntity old = service.findById(id).orElse(null);

        if (old != null) {
            if (entry.getTitle() != null && !entry.getTitle().isEmpty()) {
                old.setTitle(entry.getTitle());
            }

            if (entry.getContent() != null && !entry.getContent().isEmpty()) {
                old.setContent(entry.getContent());
            }

            return service.saveEntry(old);
        }

        return null;
    }
}
