package sclack.domain

/** 
 * This is a user class that is to help encapsulate information about the 
 * current person using the system - not to be confused with the actual in 
 * game characters. 
 */
class User(mName: String){

  /** The identity of the user */
  val id : Long = -1

  def name = mName
}
