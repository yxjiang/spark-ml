import org.apache.spark.rdd.RDD

/**
 *	Define the interface of all the normalizers.
 */
trait Normalizer {
	/**
	 *	Normalize the data
	 */
	def normalize(data: RDD[Array[Double]])
}
