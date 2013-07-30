# Sclack

Is a hack and slash game written in Scala. It should go over most of the core
feature of the language, and provide a usable application by the end of this
small case study.

#### Where did the silly name come from?

I had started but not finished another project some time ago (that someday I 
wish to finish) called Slack, and Slackedit to venture in the realms of data
driven systems, basically an experiment on how much one could decouple logic
and data from the actual system in order to keep it as dynamic as possible
(this is pretty much assets in gaming engines, and how you can just pass them
to other people to work on, while focusing purely on the engine).

Slack is a combination of the words 'slash' and 'hack', because we love slash
and hack games. Like nethack. Hackity.

#### Building

To build the project, you'll need Simple Build Tool ([sbt](http://www.scala-sbt.org)). 
Go into the main directory, and run `sbt`. The project should build
successfully. 

When you're ready you just need to run the following:

    sbt run

To run the tests (which use `ScalaTest`), run the following: 

    sbt test

If you want to generate the documentation, then run the following:

    sbt doc

#### Some helpful resources

Just leaving these here for when I need to look back on things. 

[Simple Swing App. @ Artima](http://www.artima.com/pins1ed/gui-programming.html)

