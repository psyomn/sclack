# Milestones

Just keeping the goals in text so that I can keep track of myself in case I
have no access to github. Laying out work is always a good thing too.

This is subject to change however - points might appear and disappear in some
releases (though it should not be often).

#### v0.1 UI Hammering out

* The very, very basic core achitecture of the Hack and Slash game should be 
  laid out. (Most of the domain model should be here)

* The UI flow should be present, even if not all features are implemented yet.
  this would include the following: 

  * Be greeted by the main menu
  * Be shown the Character Creation dialog on a new game
  * Be presented with a very simple layout of the in game UI (no overworld
    rendering)
  * Be presented with the _Load Game_ UI __Mock__ 
  * Be presented with the _Delete Game_ UI __Mock__
 
##### Scala Topics Covered

The scala toics covered in this release is the following:

* Classes, Objects, Traits, (Re-) using libraries from pure Java

* Inheritance, Overriding

_Extra topics include:_

* Use of scala-swing in order to provide a UI to the actual game / project. A
  nice thing about this is that this way I have documented a way to use swing
  in Scala to perform from simple to complex tasks (so if any other person
  needs examples, this could be a good place to look at; maybe).

* Using SBT for compilation and testing tasks, ScalaTest for behavioural
  testing

* Minor use of reflection in Scala / Java in order to test for method
  availabilities in classes.

* Exploiting __splat__ operators in oder to produce more elegant code

#### v0.2 - Basic paint usage, and tileset usage

* Implement world rendering using the paint method from the awt toolkit, and 
  picking out tiles programmatically from the tilesets.

* Start working on a world generating algorithm / feasibility study on time 
  wasted doing this.

#### v0.3 - Basic map interactions

* Walking around the map 

* Interaction with NPCs

* Interaction with treasure chests

* Obstructibles (So we can fix things like walls)

#### v0.4 - Battle System

* Implementation of a simple battle system

#### v0.5 - Quest

* Implementation of a simple story, so that the game can begin and end

* Investigate the ease of allowing the player to play past the endpoint

#### v1.0 - Release / Endproject

This release should conclude the project I undertook for learning the Scala
programming language, and most or all of its features. This is the point where
I should also be allowed to leave this project fully modifiable from the
outside.

* Save / Load Games

## Outstanding Language Features

* Case Classes
* Unit
* Generics 
  * (Probably will use this with some of the AI algorithms)
* Investigate possibility of metaprogramming with Scala
  * Eugene Burmako, Metaprogramming in Scala 2.10: [link](http://scalamacros.org/talks/2012-04-28-MetaprogrammingInScala210.pdf)
