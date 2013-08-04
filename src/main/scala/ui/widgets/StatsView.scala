package sclack.ui.widgets

import scala.swing.GridBagPanel

import sclack.domain.Character
import sclack.ui.factories.TextFieldFactory

/** 
 * Per character widget that demonstrates the character's information on a UI
 * @author Simon Symeonidis 
 */
class StatsView(character: Character) extends GridBagPanel {

  val constraint = new Constraints
  constraint.gridx = 0 
  constraint.gridy = 0
  constraint.fill  = GridBagPanel.Fill.Both

  val tf = TextFieldFactory

  /* Index for the grid bag rows */
  var ix = 0
  var iy = 0

  add(tf.disabledTextField("Hello there"), constraint); next
  add(tf.disabledTextField("Stalker"), constraint); next
  add(tf.disabledTextField("Hello there"), constraint); next
  add(tf.disabledTextField("Stalker"), constraint); next
  add(tf.disabledTextField("Hello there"), constraint); next
  add(tf.disabledTextField("Stalker"), constraint); next

  private def next = {
    if (ix == 1) {
      ix  = 0
      iy += 1
    }
    else {
      ix += 1
    }
    constraint.gridx = ix
    constraint.gridy = iy
  }
}
