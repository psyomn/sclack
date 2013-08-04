package sclack.domain

/**
 * A portal is a gateway from one map to another. This helps keep the code 
 * cleaner by delegating the actions of warping a character from one part to 
 * another to a single class.
 * 
 * @author Simon Symeonidis
 */
class Portal extends Observable {
  def observe = "You see a gateway here that leads to ... "
}
