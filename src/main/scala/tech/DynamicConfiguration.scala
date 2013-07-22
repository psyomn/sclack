package sclack.tech

/** 
 * Helper class that should help detect where to put different things of the
 * running application. For example if we want to get a path in which to store
 * the save games, this class should be responsible
 * 
 * @author Simon Symeonidis
 */
object DynamicConfiguration {
  val home = System.getProperty("user.home")
  val conf = home + ".config"
  val app  = conf + "/sclack"
  val data = app  + "/data"
}
