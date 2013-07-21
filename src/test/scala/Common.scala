package sclack.testing

/** 
 * Contains common helper methods for one to use in testing.
 * @author Simon Symeonidis
 */
object Common {
  /** 
   * Checks to see if the object given has a certain method, by name
   * @param name the name of the method we wish to query if existant
   * @param obj  the object we want to make sure that satisfies this
   *   requirement
   * @note 
   *   Thanks to http://stackoverflow.com/questions/2886446
   */
  def hasMethod(name: String, obj: Object) = obj.getClass
      .getMethods
      .map(_.getName)
      .contains(name)
}

