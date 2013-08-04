package sclack.ui.factories

import scala.swing.TextArea
import java.awt.Color

object TextAreaFactory {
  def disabledTextArea(t: String) : TextArea = {
    new TextArea{
        text       = t
        editable   = false 
        background = new Color(200,200,200)
    }
  }
}
