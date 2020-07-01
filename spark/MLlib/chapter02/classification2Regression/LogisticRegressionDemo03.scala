

import org.apache.spark.mllib.classification.{LogisticRegressionModel, LogisticRegressionWithLBFGS}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.util.MLUtils
/**
  * 使用LBFGS算法的逻辑回归
  */
object LogisticRegressionDemo03 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("LogisticRegressionDemo02")
    val sc = new SparkContext(conf)
    val root = "D:\\data\\sparkmllib\\"
    val data = sc.textFile(root + "wa2.txt")
    println(data.count())
    val parseData = data.map{line =>
      val parts = line.split(",")
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(" ").map(_.toDouble)))
    }.cache()
    // 把数据分为两部分，一部分作为训练集，一部分作为测试机
    val splits = parseData.randomSplit(Array(0.7,0.3), seed = 11L)

    val trainintData = splits(0)
    val testData = splits(1)
    println(trainintData.count(), testData.count())
    testData.foreach(println)

    val model = new LogisticRegressionWithLBFGS().setNumClasses(2).run(trainintData)
    val labelAndPreds = testData.map{ point =>
      val prediction = model.predict(point.features)
      (prediction, point.label)
    }

    println("modelWeight=" + model.weights)
    labelAndPreds foreach println
    val trainErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble/ testData.count()
    println(s"容错率为：$trainErr")

    // 计算测试集
    val predictionAndLabels = testData.map{
      case LabeledPoint(label, features) =>
        val prediction = model.predict(features)
        // 存储测试值和预测值
        (prediction, label)
    }

    // 创建验证类
    val metrics = new MulticlassMetrics(predictionAndLabels)
    // 计算验证值
    val accuracy = metrics.accuracy
    println("accuracy=" + accuracy)

    val patient = model.predict(Vectors.dense(Array(70, 3, 180.0, 4, 3)))
    if(patient == 1)
      println("患者的胃癌有几率转移！")
    else
      println("患者的胃癌没有几率转移！")

  }
}
