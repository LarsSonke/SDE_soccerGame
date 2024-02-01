# SDE Exam 3 - Soccer Game

## Table of Contents
<!-- TOC -->
* [SDE Exam 3 - Soccer Game](#sde-exam-3---soccer-game)
  * [1. Cooperation with team members](#1-cooperation-with-team-members)
  * [2. Design patterns](#2-design-patterns)
    * [2.1 Creational patterns](#21-creational-patterns)
      * [2.1.1 Singleton](#211-singleton)
      * [2.1.2 Builder](#212-builder)
    * [2.2 Structural patterns](#22-structural-patterns)
      * [2.2.1 Facade](#221-facade)
      * [2.2.2 Adapter](#222-adapter)
    * [2.3 Behavioral patterns](#23-behavioral-patterns)
      * [2.3.1 Iterator](#231-iterator)
      * [2.3.2 State](#232-state)
<!-- TOC -->

## 1. Cooperation between team members 


Since we worked together with live share and coop in intellij, the github commits are not accurate in showing the contributions. Therefore we ask of you to refer to the list above of who did what.

## 2. Design patterns 

### 2.1 Creational patterns
#### 2.1.1 Singleton
At all times you should only have one instance of a class.

In our application, there should only exist one game while active, so we chose for a singleton pattern so that we can 
always access the same game everywhere, and to make sure a game does not exist elsewhere.

When we want to create a new game, we check if there is already a game. If there is, we return the existing game. 
If there is no game, we create a new game and return that.

#### 2.1.2 Builder
Use a builder to create different kinds of a class with an interface.

In our application, we can have different kinds of the game. Think about the dimensions or the chips in a row needed 
to win. To make this easier, we used a builder.

The builder is used in the GameHandler class. When a new game is created, the builder is used to create a new game.

### 2.2 Structural patterns
#### 2.2.1 Facade 
When you receive input it should convert to a command.

In the Handler classes, we receive input from the user. We want to convert the input to a command, so we can use it 
but in the loophandler class, it does not need to know how it is handled. So we just pass the input that is given, and we parse it in our handler class.

#### 2.2.2 Adapter 
The console reader. 

We created the ConsoleReader class to read input from the console. 
We used the adapter pattern to make sure that there will be no code duplication
for reading console input, and to make it easily accessible.

### 2.3 Behavioral patterns
#### 2.3.1 Strategy

#### 2.3.2 State
Decides which state the application part is in. 

In our Application, the loopHandler has a state which defines which handler it uses for input.
This uses the HandlerState interface to declare the methods, and uses the loopHandler's changeState function to 
change the application to a different handler.

## Authors
* Thijs de Rechter - *student* - [ThijsDeR](https://github.com/ThijsDeR/)
* Lars Sonke - *student* - [LarsSonke](https://github.com/LarsSonke/)
