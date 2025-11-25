//package com.journal.journal.controller;
//
//import java.util.*;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.journal.journal.entity.JournalEntity;
//
//@RestController
//@RequestMapping("/api")
//public class JournalController {
//	
//	Map<Long, JournalEntity> journalEntries=new HashMap<>();
//	
//	@GetMapping
//	public List<JournalEntity> getAll(){
//		return new ArrayList<JournalEntity>(journalEntries.values());
//	}
//	@PostMapping
//	public boolean createEntry(@RequestBody JournalEntity entry) {
//		journalEntries.put(entry.getId(), entry);
//		return true;
//	}
//	
//	@GetMapping("/{getId}")
//	public JournalEntity getJournalEntityById(@PathVariable Long getId) {
//		return journalEntries.get(getId);
//	}
//	
//	@DeleteMapping("/{getId}")
//	public JournalEntity deleteJournalEntityById(@PathVariable Long getId) {
//		return journalEntries.remove(getId);
//	}
//	
//	@PutMapping("/{getId}")
//	public JournalEntity updateJournalEntityById(@PathVariable Long getId,@RequestBody JournalEntity entry) {
//		return journalEntries.put(getId, entry);
//	}
//}
