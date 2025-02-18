# 9 Box Puzzle Game

The **9 Box Puzzle Game** is a Java Swing-based sliding puzzle where players must restore a shuffled 3x3 grid to its correct order. With eight numbered tiles and one empty space, the game challenges you to rearrange the tiles with as few moves as possible.

## Table of Contents

- [Features](#features)
- [Game Overview](#game-overview)
- [Installation and Setup](#installation-and-setup)
- [How to Play](#how-to-play)
- [Leaderboard](#leaderboard)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [License](#license)

## Features

- **Interactive GUI:** Built with Java Swing, featuring an engaging user interface.
- **Sliding Puzzle Gameplay:** Arrange tiles by sliding them into the adjacent empty space.
- **Move Counter:** Tracks the total number of moves made.
- **Solution Checker:** Automatically detects when the puzzle is solved.
- **Randomized & Solvable Shuffling:** Every new game provides a randomized but solvable configuration.
- **Persistent Leaderboard:** Records player names and scores (number of moves) in a `database.txt` file.

## Game Overview

At startup, the game prompts the player to enter their name. The main window displays a 3x3 grid that contains eight numbered tiles (1 through 8) and one empty slot. Players move a tile into the empty space if it is adjacent, with the goal of reordering the tiles in ascending order. When the correct order is achieved, the game congratulates the player and logs the result to a leaderboard.

## Installation and Setup

1. **Prerequisites:**
   - Java JDK (version 8 or later)
   - An IDE such as Eclipse or IntelliJ IDEA (optional, for development)

2. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   ```

3. **Compile the Source Code:**
   Navigate to the project root directory and compile the Java files:
   ```bash
   javac -d bin src/*.java
   ```

4. **Run the Application:**
   ```bash
   java -cp bin BoxGameMain
   ```

## How to Play

1. **Start the Game:**
   - Upon launching, you will be prompted to enter your name.
   - After entering your name, a welcome message is displayed.

2. **Gameplay:**
   - The puzzle begins with the tiles randomly shuffled into a solvable state.
   - Click on a tile adjacent to the empty space to slide it into the empty slot.
   - Your move count is updated with every move.

3. **Winning the Game:**
   - Solve the puzzle by arranging the numbers in order (1 through 8) with the empty space positioned at the end.
   - Upon completion, a congratulatory message appears and your score (move count) is written to `database.txt`.

4. **Additional Options:**
   - **New Game:** Reshuffles the board into a new, random (but solvable) layout.
   - **Solution:** Automatically arranges the tiles into the correct order.
   - **Exit:** Closes the game.
   - **Leaderboard:** Opens a separate window displaying the leaderboard.

## Leaderboard

The leaderboard functionality records players' names and the number of moves it took to solve the puzzle. The information is stored in a file named `database.txt` in the project directory and accessed through:
- `LeaderBoard.java` – Displays the leaderboard in a separate window.
- `Comparator.java` and `Node.java` – Manage and sort the leaderboard data.

## Project Structure
