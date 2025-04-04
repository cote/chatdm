This is a collection of Model Context Controller tools, prompts, etc. for playing Dungeons and Dragons. They are implemented in Spring AI.

These are for (1) helping me play D&D with AIs (Claude, for now), and (2) to re-learn Java, Spring, Spring AI, and Spring AI MCP. Thus, there are some experiments and gratuitous uses of frameworks. See [the log](https://github.com/cote/chatdm/blob/main/log.md) for my ongoing lab journal and notes.

I've [play solo D&D with various AIs](https://cote.io/2024/04/09/how-to-use.html), for about two years now. There is a lot of manual work you need to do: meatsack agentic AI. MCP is a nice way to add those tools in and let the AI handle it.

Check out the [EasyChatDM project](https://github.com/cote/EasyChatDM) for simpler, sep-by-step guide to making MCP tools with Spring AI. There's videos that go along with it to walk you through creating MCP Servers in Java with Spring AI.

See notes on running this in [Docker](https://github.com/cote/chatdm/blob/main/docker.md).

# Tools, etc.

Currently, there are:

- [Oracles](https://github.com/cote/chatdm/tree/main/src/main/java/io/cote/chatdm/oracle) - these are tool wrappers around [JSON files](https://github.com/cote/chatdm/tree/main/src/main/resources/chatdm-default-files/oracle) that can either be yes/no style solo RPG Oracles or the equivilent or random RPG tables. The Oracle service will find all the oracle YAML files in the classpath and elsewhere and auto-load them up, populating the MCP tool name, description, etc.
- [DM Journal](https://github.com/cote/chatdm/tree/main/src/main/java/io/cote/chatdm/journal) - this is a tool that write out DM notes to a markdown file and also read them back in. The AI (MCP Client) uses these to keep a lot of things to remember _and_ remember them as needed.
- [DM setup](https://github.com/cote/chatdm/tree/main/src/main/java/io/cote/chatdm/dnd) - a tool used to iniatlize playing D&D. This is mostly to put in an initial prompt and point out there are other tools to use. 
- [Dice Roller](https://github.com/cote/chatdm/tree/main/src/main/java/io/cote/chatdm/dice) - Tool to roll dice, backed by [Dice Notation Tools for Java](https://github.com/Bernardo-MG/dice-notation-java).

(I have not written Java since 2005, so I have no idea what I'm doing with this fancy, new Spring Boot style.)

# DM Journal

This is one of the most exciting parts! It's fun to see when the AI (MCP Client, here, Claude desktop) chooses to write something down in its journal. Even better, it will remember what has been happening in the adventure by reloading it. Also, you get a nice accounting of it.

Here is a very short example:
```
## DM journal entry for 2025-03-20T13:23:46.377206

Adventure Concept: Sven the gnome fighter will be drawn into a mystery surrounding a small mining town where strange occurrences have been happening. The local mine has uncovered something ancient that shouldn't have been disturbed.

Key NPCs:
- Magda Copperkettle: Dwarven mine overseer, worried about her miners
- Thistlewick: Halfling tavern owner, knows all the local gossip
- Krell: Half-orc blacksmith, suspicious of strangers
- Elowen: Elven sage who might know something about the ancient relic

Location: Grimstone, a mining settlement built into the foothills of the Iron Peaks
Initial Hook: Sven has arrived to deliver a package to Magda, but finds the town in disarray

Challenge Level: Medium difficulty for a gnome fighter, with some combat, investigation, and social encounters.

## DM journal entry for 2025-03-20T13:30:05.136744

Session Progress:
Sven has arrived in Grimstone, finding it in a state of fear and disruption. He's successfully delivered the package to Magda Copperkettle, which contained a "resonance key" - a crystal tuning fork with metal inlays that supposedly can weaken a creature that has escaped from the mine.

Current Situation:
- Something dangerous has broken out of the barricaded mine
- The townsfolk are panicking
- An elf named Elowen knows how to use the resonance key
- The creature appears to be protected by some kind of magical sigils that make it resistant to normal weapons
- Several people have already been injured
- The creature is heading toward the town square

Key NPCs Introduced:
- Magda Copperkettle: Dwarven mine overseer, grateful for the package delivery
- Thistlewick: Halfling tavern owner who helped Sven find Magda
- Elowen: Elven sage with knowledge of the artifact and creature

Potential Combat Encounter:
The creature will likely be a CR-appropriate threat for Sven. If he chooses to help, it will be a combat where:
1. Elowen must use the resonance key to disable the creature's protections
2. Fighters like Sven will need to wound it once vulnerable
3. Anyone using the key will be vulnerable while doing so

If Sven chooses not to help, I'll offer alternate paths like helping evacuate townsfolk or finding another way to assist indirectly.

The creature concept: An ancient construct with rune-carved stone skin that was accidentally awakened when miners broke into a sealed chamber. The runes glow with arcane energy and can inflict strange markings on those it touches (as mentioned by the townsfolk).

## DM journal entry for 2025-03-20T14:12:47.118344

## DM journal entry for 2025-03-20

Current Scene:
Sven the gnome fighter is in Grimstone, facing an approaching ancient construct that escaped from the mine. The construct has been described as an 8-foot tall humanoid figure made of interlocking bluish-gray stone segments with shifting runes across its body. It has a featureless oval head with three concentric rings and glowing amber slits for eyes. Its arms end in geometric shapes (cube and sphere) covered in shifting runes.

Important Details:
- The construct is approaching the town square where people are gathering
- Elowen has the resonance key that can weaken its magical protections
- The construct's runes can transfer to people it touches, causing strange effects
- Several miners have already been injured
- The construct was found in a sealed chamber with an arcane circle
- It awakened when miners tried to take gemstones embedded in its chest
- Normal weapons are ineffective against it due to magical sigils

NPCs Present:
- Magda Copperkettle (dwarven mine overseer)
- Thistlewick (halfling tavern owner)
- Elowen (elven sage with knowledge of the artifact)

Next likely decision point for Sven:
Whether to help confront the construct using the resonance key, assist with evacuations, or find another approach to the situation.

Game on hold at this tension point, ready to resume when the player returns.
```
