package sclack.ui.factories

import scala.swing.TextField
import java.awt.Color

/** 
 * For creating text fields with special settings quickly
 * @author Simon Symeonidis
 */
object TextFieldFactory {
  /**
   * Create a disabled (grayed out) text field with the required
   * information inside
   *
   * @param t 
   *   is the string to set to the text field
   * @return 
   *   a grayed out text field with the specified contents
   */
  def disabledTextField(t: String) : TextField = {
    new TextField{
        text       = t
        editable   = false 
        background = new Color(200,200,200)
    }
  }
}

