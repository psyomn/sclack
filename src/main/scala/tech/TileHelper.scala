package sclack.tech

import java.io.File
import javax.imageio.ImageIO 
import java.awt.image.BufferedImage
import java.awt.Graphics2D


/**
 * This class should not be used directly. You should look at the TileManager
 * class for more information.
 * 
 * The tile helper reads an image file and extracts tiles from them. You create
 * this object by specifying the tile dimentions (in our case 16x16), and then
 * provide an index in order to select the wanted tile.
 * 
 * @author Simon Symeonidis 
 * @see    TileManager
 * @param  x is the width of the tile from the given tileset
 * @param  y is the height of the tile from the given tileset
 * @param  tileset is the name of the wanted tileset. Please set to 'dungeon'
 *   or 'fantasy', for what you want.
 */
class TileHelper(x: Int, y: Int, bdr: Int = 0, tset: java.net.URL){
  
  lazy val tileset = ImageIO.read(tset)

  /**
   * Get a tile by getting an id
   * 
   * @param id is the id that is specified 
   * @note Thanks to: 
   *   http://stackoverflow.com/questions/299495/ for loading buffered images
   * @throws SclackTechnicalException if an id of 0 is given (we assume that
   *   ids are non-zero, positive numbers)
   */
  def tile(id: Int) : BufferedImage = {
    if (id <= 0) throw new SclackTechnicalException("ids are > 0")

    tileset.getSubimage(
      relativeX(id),
      relativeY(id),
      width,
      height)
  }

  /** 
   * Relative X, given the id of the tile, and the border
   * 
   * @return an integer giving the relative X to start the canvas
   */
  private def relativeX(id: Int) : Int =
    ((width + border) * id) % tileset.getWidth + border

  /** 
   * Relative Y, given the id of the tile, and the border
   *
   * @return an integer giving the relative Y to start the canvas
   */
  private def relativeY(id: Int) : Int = 
    (height + border) * 
    ((id - 1) / tilesPerRow).floor.toInt + border

  /** 
   * The tiles we can have per row
   * 
   * @return the number of tiles per row
   */ 
  private def tilesPerRow = tileset.getWidth / width + border

  def width   = x
  def height  = y
  def border  = bdr 
}

