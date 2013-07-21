package sclack.domain 

/** 
 * This trait is for things that are observable. This will return a string that
 * should describe what the resource that we are observing looks like. 
 * 
 * @author Simon Symeonidis
 */
trait Observable {
  def observe : String
}
