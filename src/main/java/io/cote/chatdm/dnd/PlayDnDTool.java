package io.cote.chatdm.dnd;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * AI tools to assist in the playing D&D: a bootstrapping tool to start with a prompt and instruct the AI to use the other tools available.
 */
@Service
public class PlayDnDTool {

    private static final Logger logger = LoggerFactory.getLogger(PlayDnDTool.class);

    @Tool(name="Play_DnD", description="When you start playing D&D, consult these instructions.")
    public String playDnD(){
        return """
                You are a Dungeon Master (DM) and will be an fun, imaginative DM for solo role playing D&D with the user. You will play D&D 5th edition (5e) and follow the rules. You have several tools at your disposal like oracles and others. Look through your tools to familiarize yourself with what is available and use them as needed when coming up with what to do next, resolving questions, playing NPCs, coming up with adventures, etc. Mix in the reply of the tools with your own thinking. Unless otherwise stated by the user, start playing and come up with an adventure for them to follow. Remember to only tell the user what their player character (PC) would know and see, do not reveal secrets to them. Give them full agency over their PC, do not determine what the PC does or says (except for very small, trivial things when needed to advance the plot). Keep responses relatively short unless the user asks for more detail. Call for skills checks when needed, coming up with a Difficulty Class (DC) for the skill based on how hard it is: 10 is easy, 15 requires effort and skill, 20 is difficult, 25 is near impossible, 30 takes a miracle.
                """;

    }

    @Tool(description = "Used by the Dungeon Master (DM) to note down important things to remember. DM journal entries are usually for DM eyes only and are things like state of play, interesting developments to the plot, new NPCs, and other things a DM and story teller would keep in their notebook to remember and use ongoing.")
    public void writeDMJournalEntry(String journalText) {
        // TK this needs a service to go into a DB and a dated markdown file.
        logger.info("DM Journal entry:\n{}", journalText);
        journalEntries.add(LocalDateTime.now().toString()+"\n\n"+journalText+"\n\n");
    }

    @Tool(description = "Used to get entries from the Dungeon Master (DM) journal. These are notes the DM wanted to keep for later and may want to refer back to as they are crafting the adventure. Journal entries are not always for players eyes and are often for DM's eyes only.")
    public String readDMJournal() {
        if (journalEntries.isEmpty()) {
            return "No journal entries found.";
        } else {
            return String.join("\n", journalEntries);
        }
    }

    // This should probably be a record or something? Then we could write it out?
    private List<String> journalEntries = new ArrayList<>();
}
