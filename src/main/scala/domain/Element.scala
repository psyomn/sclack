package sclack.domain

/**
 * Enumeration for the different elements that exist.
 * @author Simon Symeonidis
 */
object Element extends Enumeration {
  type Element = Value
  val  fire, water, wind, earth, physical, 
       void, shadow, lightning, sonic = Value
}
