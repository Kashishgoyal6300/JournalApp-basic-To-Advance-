package com.journal.journal.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity entry) {
        try {
            entry.setDate(LocalDateTime.now());
            JournalEntity saved = service.saveEntry(entry);   // FIXED: Save entry
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<JournalEntity> getJournalEntityById(@PathVariable String id) {
        Optional<JournalEntity> jentry = service.findById(id);

        if(jentry.isPresent()) {
            return new ResponseEntity<>(jentry.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJournalEntityById(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);   // FIXED: Removed <T>
    }

    // Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<JournalEntity> updateJournalEntityById(
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

            JournalEntity updated = service.saveEntry(old);   // FIXED: Save updated entry
            return new ResponseEntity<>(updated, HttpStatus.OK);  // FIXED: Correct ResponseEntity syntax
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
