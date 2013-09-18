package sclack.tech

/**
 * Just a class to help with coordinates and reduce code clutter. 
 * 
 * @author Simon Symeonidis 
 */
object CoordinateHelper {

  /**
   * Call this when you want coordinates for doing things (who is around me?
   * what is around me?)
   *
   * @param  coord is the current coordinate in tuple form (x, y)
   * @return tuples of (x, y), each containing relative points to (x, y) in
   *   directions left, right, top, bottom. 
   */
  def adjacentCoordinates(coord: (Int,Int)) : Array[(Int,Int)] = {
    Array[(Int,Int)](
      (coord._1 - 1, coord._2), /* left  */
      (coord._1 + 1, coord._2), /* right */
      (coord._1, coord._2 - 1), /* up    */
      (coord._1, coord._2 + 1)  /* down  */
    )
  }
}

