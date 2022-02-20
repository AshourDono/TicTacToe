# **Tic-Tac-Toe**

Tic-tac-toe has been a part of almost everyone’s childhood.
While the game of tic-tac-toe is really old, dating back to ancient Egyptians at around 1300 B.C., the underlying principles of the game have endured the test of time. The game seems simple enough. Two opponents, one using X and one using O, use a 3 x 3 grid to mark their symbols. The first one to get all three of his/her symbols in a row, whether it’s diagonal, horizontal, or vertical, wins the game.

---
## Overview

This project is a simple Tic-Tac-Toe online game developed as a final project for the java course.
The game is developed using java and javafx utilizing socket programming, multi-threading
and JSON data transmission to allow for a multiplayer online game with other features such as ingame Chat and much more.

------
## 🕹️ Main Features

### Server-Side

- Live list of players status and score.
- simple GUI.
- Start and stop the server with a simple click of a button.

### Client-Side

- Play in single mode vs. computer in two levels of difficulty, implemented using minimax algorithm.
- A live list of the status and score of other players in the game.
- Chat with the opponent inside the game.
- Save the game to continue playing it later.
- User-friendly GUI.

---
## 💡 Game Features

- A score metrics for each player that is calculated upon winning or losing.
- Play with your friends in multiplayer mode (online).
- Playing again with the same player.
- Quit the game in the middle, but it will result in losing the game.

---
## 💻 How To Use

Clone the project in your working directory.

```bash
https://github.com/AshourDono/TicTacToe.git
```

or download the zipped file and unzip it in your working directory.


### Database Setup

- Import SQL schema file in any MySQL Server ( <u>Recommended: phpMyAdmin</u> ) or implement SQl statements manually in mySQL Shell.
- Edit DBconfig.java file in  [Database Package] to fill your database username ,password ,port number ,and database server url .

### Run The Server

Using File Explorer : Navigate to the ServerSide folder then inside dist folder double click ServerSide.jar

Using the Terminal : Navigate to the [ServerSide/dist](https://github.com/AshourDono/TicTacToe/tree/main/ServerSide/dist) directory and run the following command:

```bash
java -jar ServerSide.jar
```

⚠️**Note that the server and the client run on port 7777.**

### Run The Client

Using File Explorer : Navigate to the ClientSide folder then inside dist folder double click ClientSide.jar

Using the Terminal : Navigate to the [ClientSide/dist](https://github.com/AshourDono/TicTacToe/tree/main/ClientSide/dist) directory and run the following command:

```bash
java -jar App.jar
```

---
## 📋 Dependencies

* [MySQL](https://www.mysql.com/)
* [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html/)
* [Json-simple library](https://github.com/fangyidong/json-simple)
* [mysql-connector](https://dev.mysql.com/downloads/connector/j/)


---
## 🚫 Limitations

- A potential shortcoming could appear when the database goes down while the server is running.
- The reliability of the Client-Server communication is about 90%; sometimes the requests from the client are not caught by the server.

---
## 📈 Possible Improvements

- Implement a notification system to notify players about others signning in/out.
- To allow the player to share his game result on his social media accounts.
---
## 👨‍💻 About Us

We are a team of students at ITI intake 42, Mansoura branch, Open-source application track.

### 📞 Contacts

You can find us on:

#### GitHub

- [Mohamed Alabasy](https://github.com/MohamedAlabasy)
- [Nermeen Shehab](https://github.com/NermeenShehab)
- [Nada Reffat](https://github.com/nadareffat98)
- [Ahmed Ashour](https://github.com/AshourDono)
- [Ahmed El-Sheikh](https://github.com/AhmedElsheikh680)
