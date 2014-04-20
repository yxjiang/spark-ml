package util

import collection.mutable.Stack
import org.scalatest._

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

class TestNormalizer extends FunSuite with LocalSparkContext {
  
	test("normalization") { 
    val data = sc.textFile("src/test/resources/data.txt")
    
    val parsedData = data.map { line =>
      val tokens = line.split(' ')
      tokens.map(x => x.toDouble).toArray
    }
    
    val normalizer = new Normalizer()
    val res = normalizer.minMaxNormalize(parsedData)
    val normalizedData = res._1
    val arrs = normalizedData.toArray
		data.count
  }

}
