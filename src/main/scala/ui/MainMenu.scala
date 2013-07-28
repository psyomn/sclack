package sclack.ui

import javax.swing.ImageIcon
import java.awt.Dimension
import swing._
import swing.event._
import scala.swing._

import sclack.domain.GameSession
import sclack.domain.commands.{CreateNewGame, DeleteGame, LoadGame}

/** 
 * The main menu of the application. This is where the user specifies whether
 * we want a new game, to load a game, or to delete a game.
 * @author Simon Symeonidis 
 */
object MainMenu extends SimpleSwingApplication {

  val newGameText      = "New Game" 
  val loadGameText     = "Load Game" 
  val deleteGameText   = "Delete Game"
  val quitText         = "Quit"
  val imageLocation    = getClass.getResource("/title.png")

  var newGameButton    = new Button {text = newGameText}
  var loadGameButton   = new Button {text = loadGameText}
  var deleteGameButton = new Button {text = deleteGameText}
  var quitGameButton   = new Button {text = quitText}
  var logoIcon         = new ImageIcon(imageLocation)
  var labelIcon        = new Label{icon = logoIcon}

  def top = new MainFrame {
    title = "Sclack v" + Sclack.version 

    contents = new BoxPanel(Orientation.Vertical){ 
      contents += labelIcon
      contents += newGameButton
      contents += loadGameButton
      contents += deleteGameButton
      contents += quitGameButton
    }
  }

  listenTo(newGameButton, loadGameButton, deleteGameButton)
  reactions += {
    case ButtonClicked(b) => 
      b.text match {
         case `newGameText`    => createNewGame
         case `loadGameText`   => loadGame
         case `deleteGameText` => deleteGame
         case `quitText`       => quitGame
      }
  }

  /** 
   * React to the create game click, by creating a new game session 
   */
  private def createNewGame {
    var createCommand = new CreateNewGame()
    createCommand.execute
    createCommand.gameSession
    val gameUI = new GameUI()
  }

  /** 
   * React to the load game click, by load a new game session 
   */
  private def loadGame {
    var loadGameCommand = new LoadGame()
    loadGameCommand.execute
  }

  /** 
   * React to the delete game click, by delete a new game session 
   */
  private def deleteGame {
    var deleteGameCommand = new DeleteGame()
    deleteGameCommand.execute
  }

  /**
   * Quit the application 
   */
  private def quitGame {
    println("herpderp")
    exit(0)
  }
}
