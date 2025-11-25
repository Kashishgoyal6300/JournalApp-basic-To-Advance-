package com.journal.journal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journal.journal.entity.JournalEntity;
import com.journal.journal.repository.JournalRepository;

@Service
public class JournalEntryService {

    @Autowired
    private JournalRepository repo;

    public JournalEntity saveEntry(JournalEntity entry) {
        return repo.save(entry);
    }

    public List<JournalEntity> getAll() {
        return repo.findAll();
    }

    public Optional<JournalEntity> findById(String id) {
        return repo.findById(id);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
