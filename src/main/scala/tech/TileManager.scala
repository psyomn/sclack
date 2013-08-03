package sclack.tech

import scala.collection.mutable.HashMap
import java.awt.image.BufferedImage

/**
 * The tile manager is a Cache-like pattern that only loads the required
 * tilesets once, and then they are loaded from a single point in memory when
 * required, when painting the tiles anywhere. 
 * 
 * @author Simon Symeonidis
 */
class TileManager {

  /**
   * Get the tileset by giving the required name
   */
  def get(name: String) {
    name match {
      case "dungeon" => println("Dungeon tileset load")
      case "fantasy" => println("Fantasy tileset load")
    }
  }


  /**
   * The tilemap to contain the required graphics
   */
  private var tilemap = new HashMap[String,BufferedImage]

}
