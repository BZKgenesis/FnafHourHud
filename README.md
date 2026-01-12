# FNaF Hour HUD

FNaF Hour HUD is a simple Forge mod for Minecraft 1.20.1 that adds a Five Nights at Freddy's–style hour display in the top-right corner of the screen.

This HUD is not linked to Minecraft's internal time system. It is designed to be controlled entirely via scoreboards, making it ideal for custom maps, adventure maps, or horror experiences.


---

## How it works

The mod relies on a custom scoreboard objective:
```
fnafhourhud.main
```
Two player values are used:
```
isEnabled
```
Set to 1 → enables the HUD for the player (`/scoreboard players set isEnabled fnafhourhud.main 1`)

Any other value → HUD is hidden

```
time
```
Defines the hour displayed on screen (`/scoreboard players set time fnafhourhud.main 6`)



### Example:

time = 3  → displays "3 AM"

time = 12 → displays "12 AM"

time = 9999 → displays "9999 AM"

### ⚠️ Important:
There is no built-in time validation or logic.
The mod will display exactly the value you put in the scoreboard.
Handling hour progression, limits, AM logic, or events is entirely up to the map maker.


---

## Intended usage

This mod was originally made to be used alongside a specific custom map:
👉 Map link: &lt;coming soon&gt;

That said, the mod is fully standalone and can be used in any map or project without issues.


---

## Features

- FNaF-style hour display (top-right HUD)
- Fully controlled via scoreboards
- Client-side visual mod
- Perfect for adventure / horror maps
- No dependency on in-game time

---

## ❌ What this mod does NOT do (for now)

- No automatic hour progression
- No validation on time values
- No PM support (only displays AM)
