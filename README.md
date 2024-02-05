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

Thijs en Lars worked together via 'Code with me', so the work division is listed below

Base Project (Loophandler, ConsoleReader, Main, etc) - Thijs  
Situations & Menu - Lars  
Statistics & Menu - Lars  
Levels - Thijs  
Game & Menu - Lars & Thijs  

## 2. Design patterns 

### 2.1 Creational patterns
#### 2.1.1 Singleton
Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

In our application, there should only exist one game and one player, so we chose for a singleton pattern so that we can 
always access the same game and player everywhere, and to make sure the data is consistent.

When we want to use a class and its properties, we check if there is an instance of the class already present. If there is, we return the existing instance. 
If there is no instance, we create a new instance and return that.

#### 2.1.2 Builder
Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

In our application, we can have different kinds of situations. Changing the defenders, teammates and distance from goal
To make this easier, we used a builder.

The builder is used in the GameSelectHandler class. When a new game is created, the builder is used to create a new situation for the game.

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
Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

For calculating the chance if the strategy is successful, we use a strategy to indicate which calculation to use for the chance.

#### 2.3.2 State
Decides which state the application part is in. 

In our Application, the loopHandler has a state which defines which handler it uses for input.
This uses the HandlerState interface to declare the methods, and uses the loopHandler's changeState function to 
change the application to a different handler.

## Authors
* Thijs de Rechter - *student* - [ThijsDeR](https://github.com/ThijsDeR/)
* Lars Sonke - *student* - [LarsSonke](https://github.com/LarsSonke/)
