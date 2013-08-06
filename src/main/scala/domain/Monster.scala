package sclack.domain

class Monster extends Character{
  def combinedStrength = strength + 1
  def combinedIntelligence = intelligence + 3
  def combinedConstitution = constitution + 1
  def combinedDexterity = dexterity + 10
  def discipline = "WARRRG ROOAR GWARRG!!"
}
