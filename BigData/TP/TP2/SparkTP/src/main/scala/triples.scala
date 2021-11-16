import org.apache.spark.{SparkConf, SparkContext}

object exemples extends App {
  val conf = new SparkConf().setAppName("simpleSparkApp").setMaster("local")
  val sc = new SparkContext(conf)
  val triples = sc.parallelize {
    Array((1, 0, 5), (5, 1, 8), (8, 2, 1), (2, 0, 6), (3, 0, 6), (6, 1, 9), (5, 1, 9), (9, 3, 11), (9, 4, 12), (4, 0, 7), (7, 1, 9), (7, 2, 10), (14, 1, 15),
      (15, 1, 16), (14, 1, 16), (17, 0, 18), (18, 0, 19), (19, 1, 20), (20, 0, 17)).map(x => x)
  }
  triples.foreach(println(_))

  val soPairs = triples.map(t1 => (t1._1, t1._3))
  soPairs.foreach(println(_))

  //val roots = soPairs.map()
}