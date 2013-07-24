package sclack.tech

/**
 * The tile helper reads an image file and extracts tiles from them. You create
 * this object by specifying the tile dimentions (in our case 16x16), and then
 * provide an index in order to select the wanted tile.
 * @author Simon Symeonidis 
 * @param  x is the width of the tile from the given tileset
 * @param  y is the height of the tile from the given tileset
 * @param  tileset is the name of the wanted tileset. Please set to 'dungeon'
 *   or 'fantasy', for what you want.
 */
class TileHelper(x: Int, y: Int, tset: String){
  
  val dungeonTilesetName = "16x16-dungeon-tiles-nes-remake.png"
  val fantasyTilesetName = "16x16-fantasy-tileset.png"

  val dungeonTilesetRes  = getClass.getResource(dungeonTilesetName)
  val fantasyTilesetRes  = getClass.getResource(fantasyTilesetName)

  /**
   * Get a tile by getting an id
   * @param id is the id that is specified 
   */
  def tile(id: Int){
  }

  def width   = x
  def height  = y
  def tileset = tset
}

