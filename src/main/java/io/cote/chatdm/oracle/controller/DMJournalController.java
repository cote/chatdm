package io.cote.chatdm.oracle.controller;

import io.cote.chatdm.journal.DMJournalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/chatdm/api/dmjournal")
public class DMJournalController {

    private final DMJournalRepository dmJournalRepository;

    public DMJournalController(DMJournalRepository dmJournalRepository) {
        this.dmJournalRepository = dmJournalRepository;
    }

    @GetMapping("/read")
    public String readDMJournal() throws IOException {
        return dmJournalRepository.entries();
    }

    @PostMapping("/append")
    public void writeDMJournalEntry(String journalText) throws IOException {
        dmJournalRepository.addEntry(journalText);
    }
}
