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

  val roots = soPairs.subtractByKey(soPairs.map(t1 => (t1._2, 0)))
  roots.foreach(println(_))

  val osPairs = soPairs.map(t1 => (t1._2, t1._1))
  val leaves = osPairs.subtractByKey(osPairs.map(t1 => (t1._2, 0)))
  leaves.foreach(println(_))


  val soPairsTest = sc.parallelize {
    Array((1, 2), (2, 3), (3, 4)).map(x => x)
  }
  val osPairsTest = soPairsTest.map(t1 => (t1._2, t1._1))
  var rdd5 = soPairsTest.join(osPairsTest).map(t1 => (t1._2._2, t1._2._1)).union(soPairsTest).distinct().sortByKey()
  var prev_size = rdd5.count()
  var new_size = 0l
  while (prev_size != new_size) {
    rdd5 = rdd5.join(osPairsTest).map(t1 => (t1._2._2, t1._2._1)).union(rdd5).distinct().sortByKey()
    prev_size = new_size
    new_size = rdd5.count()
  }
  rdd5.foreach(println(_))

  rdd5 = soPairs.join(osPairs).map(t1 => (t1._2._2, t1._2._1)).union(soPairs).distinct().sortByKey()
  prev_size = rdd5.count()
  new_size = 0l
  while (prev_size != new_size) {
    rdd5 = rdd5.join(osPairs).map(t1 => (t1._2._2, t1._2._1)).union(rdd5).distinct().sortByKey()
    prev_size = new_size
    new_size = rdd5.count()
  }
  rdd5.foreach(println(_))


  var rdd6 = rdd5.subtract(soPairs)
  rdd6.foreach(println(_))

  var rooted = rdd5.join(roots).map(t1 => (t1._1, t1._2._1)).distinct().groupByKey()
  rooted.foreach(println(_))

  var cycles = rdd5.filter(t1 => t1._1 == t1._2)
  cycles.foreach(println(_))
}