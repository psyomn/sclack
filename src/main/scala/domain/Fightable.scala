package sclack.domain

/**
 * Trait for things that are fightable
 * @author Simon Symeonidis
 */
trait Fightable {
  def attack
  def defend
  def cast
}
