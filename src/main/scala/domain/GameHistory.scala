package sclack.domain

import scala.collection.mutable.Queue

/** 
 * The domain object that represents the game history / actions that have 
 * happened in the last session.
 * @author Simon Symeonidis 
 */
class GameHistory {
  /** the maximum amount of logs to keep */
  var max  = 100
  var logs : Queue[String] = new Queue[String]

  def log(l: String){
    if (logs.size + 1 > max)
      logs.dequeue
    logs.enqueue(l)
  }
  
}
