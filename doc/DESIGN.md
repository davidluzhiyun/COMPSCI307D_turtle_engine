# OOLALA Design Report
### TEAM


## Team Roles and Responsibilities

 * David Lu
    * Command line system of turtle (Includes GUI for clearing and running single line input, 
   tracing history with up and down key, parsing commands and call the corresponding turtle me)
   * Internal model for parsing L-System command and translating to turtle
   * Here is a list of major classes that are mainly done by me.
     * CommandRunner
     * LRunnerModel
     * TurtleCommandView
     * TurtleCommandHistoryModel
     * and the auxiliary classes: TurtleCommand and its subclasses, LCommand and its subclasses

 * Andrew Demma
   * Created UI for both apps
   * Created MVC model for both apps
   * Attached CommandRunner for both apps to Controller
   * Here is a list of major classes that are mainly done by me.
     * Model
     * View
     * LController and TurtleController

 * Team Member #3



## Design goals

#### What Features are Easy to Add


## High-level Design

#### Core Classes
* Main
* The Controller Classes
* The Command Runner Classes
* Model
* View


## Assumptions that Affect the Design

#### Features Affected by Assumptions


## Significant differences from Original Plan
* We originally wanted views on the sides of the scene which would display a command history and a command docs, where all commands were listed.


## New Features HowTo

#### Easy to Add Features
Drawing a line when a model moved was easy to implement

#### Other Features not yet Done
* Adding Static buttons to the top of the apps for changing background, color of turtle
* Ability to see names and the coordinates of present turtles
* 

