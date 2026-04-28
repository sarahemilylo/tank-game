# 💣 Tank Battle Game (Java Swing)

![Java](https://img.shields.io/badge/Language-Java-blue.svg)
![GUI](https://img.shields.io/badge/GUI-Swing-green.svg)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen.svg)

A two-player turn-based tank battle game built using Java Swing. Players control tank turrets, adjust shot power, and fire projectiles with realistic parabolic motion to hit their opponent.

---

<img width="2541" height="1432" alt="tank_game_interface" src="https://github.com/user-attachments/assets/16313ea0-d3da-405d-a39d-3927d142acdb" />

## 🎮 Features

- 2-player turn-based gameplay  
- Adjustable turret angle and shot power  
- Realistic projectile motion (gravity-based)  
- Collision detection for hits  
- Win condition system  
- Smooth animation using a game loop (`Timer`)  

---

## 🕹️ Controls

### Player 1 (Left Tank)
| Action | Key |
|------|-----|
| Move turret up | W |
| Move turret down | S |
| Increase power | A |
| Decrease power | D |
| Fire | Q |

---

### Player 2 (Right Tank)
| Action | Key |
|------|-----|
| Move turret up | ↑ |
| Move turret down | ↓ |
| Increase power | ← |
| Decrease power | → |
| Fire | / |

---

## 🧠 How It Works

### Game Loop
- Runs at ~60 FPS using:
```java
Timer theTimer = new Timer(1000/60, this);
