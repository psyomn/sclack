package sclack.tech

import java.awt.image.BufferedImage
import scala.collection.mutable.HashMap
import java.awt.image.BufferedImage

/**
 * The tile manager is a Cache-like pattern that only loads the required
 * tilesets once, and then they are loaded from a single point in memory when
 * required, when painting the tiles anywhere. 
 * 
 * @author Simon Symeonidis
 */
object TileManager {

  /**
   * The tilemap to contain the required graphics
   */
  private var tilemap = new HashMap[String,BufferedImage]

  /**
   * Get the tileset by giving the required name
   * @param name is the name of the tileset to use (for now 'dun', and 'fan'
   *   are the only valid choices 
   * @param ix is the index of the tile to fetch and return
   * @return the tile that you require, given the id
   * @note Ultimately you'd 
   */
  def tile(name: String, ix: Int) : BufferedImage = {
    name match {
      /* Dungeon */
      case "dun" => 
        return dungeonTileHelper.tile(ix)

      /* Fantasy */
      case "fan" => 
        return fantasyTileHelper.tile(ix)
    }
  }

  private val dungeonTilesetName = "/16x16-dungeon-tiles-nes-remake.png"
  private val fantasyTilesetName = "/16x16-fantasy-tileset.png"
  private val dungeonTilesetRes  = getClass.getResource(dungeonTilesetName)
  private val fantasyTilesetRes  = getClass.getResource(fantasyTilesetName)

  private val dungeonTileHelper  = new TileHelper(16,16,2,dungeonTilesetRes)
  private val fantasyTileHelper  = new TileHelper(16,16,0,fantasyTilesetRes)
}

