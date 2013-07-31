package sclack.domain

import scala.collection.mutable.Queue

/** 
 * The domain object that represents the game history / actions that have 
 * happened in the last session.
 * @author Simon Symeonidis 
 */
class GameHistory {

  def log(l: String){
    if (logs.size + 1 > max)
      logs.dequeue
    logs.enqueue(l)
  }

  def count : Int = logs.size

  /** the maximum amount of logs to keep */
  private var max  = 100

  /** the log data structure we're using to perform this */
  private var logs : Queue[String] = new Queue[String]
}
