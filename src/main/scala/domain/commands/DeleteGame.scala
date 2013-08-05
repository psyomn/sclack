package sclack.domain.commands

/** 
 * For deleting a previous game
 * @author Simon Symeonidis
 */
class DeleteGame extends Commandable {
  def execute {
    println("Delete Game Command Executed")
  }
}
