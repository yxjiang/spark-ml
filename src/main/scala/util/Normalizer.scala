package util

import org.apache.spark.rdd.RDD
import org.jblas.DoubleMatrix

/**
 * 	Normalizer can be used to conduct various types of normalization for the data.
 */
class Normalizer {
  /**
   * 	Normalize the data
   */
  def minMaxNormalize(data: RDD[Array[Double]]): (RDD[Array[Double]], DoubleMatrix, DoubleMatrix) = {
    val nCols = data.first().length
    val minVec = new DoubleMatrix(nCols)
    minVec.fill(Double.MaxValue)
    val maxVec = new DoubleMatrix(nCols)
    maxVec.fill(Double.MinValue)
    
    // record the mins and maxs of each dimension
    data.map { row => 
      var col = 0
      while (col < row.length) {
        if (row(col) > maxVec.get(col)) maxVec.put(col, row(col))
        if (row(col) < minVec.get(col)) maxVec.put(col, row(col))
        col += 1
      }
    }
    
    // normalize the value of each dimension
    val diff = maxVec.sub(minVec)
    val normalizedData: RDD[Array[Double]] = data.map { row =>
      ((0 until nCols) map (x => (row(x) - minVec.get(x)) / diff.get(x) )).toArray
    }

    // return the normalized RDD
    (normalizedData, minVec, maxVec)
  }
}
