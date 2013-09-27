Sclack!!: Passing on the Knowledge
==================================

# Forenote

Before starting, I'd like to say that I am in no way an expert on Scala. I have
had the pleasure of using the programming language for 1-2 months, and am 
posting my notes for any other curious soul that wishes to take a look, and
maybe have a more gentle introduction to the language and development tools 
than I had. One more disclaimer: I like command line tools.

_Versions used, when this was written (Thu Sep 26 21:42:55 EDT 2013):_

* Scala, version 2.10.0-20121205-235900-18481cef9b 

* SBT, version 0.13.0-1

## Starting off the project

I like using command line tools, usually they decouple a lot of
responsabilities from applications, and give you powerful tools. For this
application, I used a tool for building called sbt.

### SBT: Simple Build Tool

SBT can be accessed in the command line after you have installed it on your
system. On an Arch install, you'd do: 

````bash
# pacman -S sbt
````

Then you just need to write your configuration file for your project. The
configuration file of sbt is located in the root directory of said project.
It contains information about the project such as _version number_, _name_,
and other fluff like that. More importantly, you can specify the scala 
version you require for this application, as well as dependencies. This 
pretty much manages everything for you on the fly; the required scala 
version, along with the dependencies that work with *that* particular 
scala version are downloaded from repositories such as maven (or any other
user defined repository if specified), and compiled as well if needed.

Let us take a look at the current project's sbt file, sclack.sbt:

````scala
import AssemblyKeys._

assemblySettings

name         := "sclack"

version      := "1.0"

scalaVersion := "2.10.0"

libraryDependencies ++= Seq(
  "org.scalatest"  % "scalatest_2.10"     % "1.9.1" % "test",
  "org.scalaquery" % "scalaquery_2.9.0-1" % "0.9.5",
  "org.xerial"     % "sqlite-jdbc"        % "3.6.16",
  "org.scala-lang" % "scala-swing"        % "2.10.0"
)

exportJars := true

````

For this project, I decided using a few 3rd party libraries which some I
did not completely have the chance to use given the alotted time. You can
see these libraries inside "libraryDependencies". The first column is the
GroupID (think of it as a certain software vendor id) we want things from, the
second the library name, with a required scala version shown some times, and
the third column being the version of that actual library. 

Note: an SBT configuration file (project-name.sbt), IS A scala file. So you can
probably do some programmatic stuff in there; I have not tested this out yet.
If you want to read more about this file, you can read the official
documentation here: 

> [SBT file Specification](http://goo.gl/klcF93)

And some even more detailed configuration details here:

> [SBT file Specification on STEROIDS](http://goo.gl/M7reZa)

On a last note, the sbt file is not really required for a project. If you have
the following setup: 

    project-root-dir
    `-- src
        `-- main
            `-- scala
                `-- main.scala

And run sbt in `project-root-dir', you're ready to compile and run your
application.

##### SBT Commands

The only commands you really need to memorize, are `compile' and `run'. And
`run' calls compile. So that's one command.

If you're using a testing framework as I am (scalatest), you can type `test' in
order to run your tests. 

## Software Engineering

Some pretty standard Software Engineering techniques have been used in this
project. The parts of the system are separated in UI, Domain, and Technical
packages. There's slightly the use of the command pattern for factoring out
logic which is reused in many parts of the system, and a few factories that are
currently aiding in complex object creations of Sclack (such as maps,
characters, etc).

### Testing

Using Scalatest, we're given access to different testing suites. I used a BDD
suite, and all the tests may be observed in `src/test'. To execute them, run 
sbt and type `test'.

````bash
[psyomn@aeolus sclack 0]$ sbt
Loading /usr/share/java/sbt/bin/sbt-launch-lib.bash
[info] Loading project definition from .../scala/sclack/project
[info] Set current project to sclack (in build file:.../scala/sclack/)
> test
[info] WizardTest:
[info] Wizard traits 
[info] - should be an instance of Character
[info] - should be observable
[info] - should be demonstratable
[info] Wizard attributes 
[info] TileHelperTest:
[info] TileHelper 
[info]   Attributes 
[info]   - should include a tile method
[info]   - should include a width method
[info]   - should include a height method
[info]   - should include a tileset method
````

The tests are probably not what you would see in the real world, but I was just
messing around, and curious to see this testing suite in action.

## Some things I found Awesome

* Talk about how we used sbt in order to take care of the compiling, dependency
  management, testing and deployment of the project. Reminders: For compiling
  sbt uses a nice directory structure. For testing, we used behavioral testing
  using the __ScalaTest__ library. For deployment we use the assembly plugin
  that packages everything nicely. 

* Talk about how the feature of Scala was used to interface with Java code. 
  we achieved this by calling some unimplemented / not understood? things in 
  scala swing in order to have the full functionality. An example is how we
  overrode the __paint__ method in order to draw the tiles on the main menu. 

* The tiles used in order to portray maps. 

* Used the basic core language functionalies such as classes, and objects. 
  Identified cases where we would need classes as opposed to objects. 

* Use of splat operator, see file: 108:ui.CreateCharacter.scala

* Used the lazy load feature in file 26:tech.TileHelper.scala 

* Used traits in order to describe objects 

