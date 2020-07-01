

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.log4j.{Level,Logger}
import org.apache.spark.mllib.util.MLUtils

/**
  * 带有逻辑回归验证的逻辑回归实例--胃癌的转移判断（王晓华 Spark MLlib机器学习实战）
  * 使用SGD梯度下降法的逻辑回归
  *
  * 数据说明：
  * y:肾细胞癌转移情况（有转移y=1；无转移y=0）
  * x1:确诊时患者的年龄（岁）
  * x2:肾细胞癌血管内皮生长因子（VEGF）其阳性表述由低到高共三个等级
  * x3:肾细胞癌组织内微血管数(MVC）
  * x4:肾癌细胞核组织学分级，由低到高共4级
  * x5:肾癌细胞分期，由低到高共4期。
  * y x1 x2 x3 x4 x5
  * 0 1:59 2:2 3:43.4 4:2 5:1
  */
object LogisticRegressionDemo02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("LogisticRegressionDemo02")
    val sc = new SparkContext(conf)
    val root = "D:\\data\\sparkmllib\\"
    val data = MLUtils.loadLibSVMFile(sc, root + "wa1.txt")

    //对数据集切分成两部分，一部分训练模型，一部分校验模型
    val splits = data.randomSplit(Array(0.6,0.4),seed = 11L)
    val parsedData =splits(0)
    val parsedTest =splits(1)
    val numiteartor = 50
    val model = LogisticRegressionWithSGD.train(parsedData,numiteartor) //训练模型
    println(model.weights)

    //计算测试值
    val predictionAndLabels = parsedTest.map{
      case LabeledPoint(label,features) =>
        val prediction = model.predict(features)
        //存储测试值和预测值
        (prediction,label)
    }

    predictionAndLabels.foreach(println)

    val trainErr = predictionAndLabels.filter( r => r._1 != r._2)
      .count.toDouble / parsedTest.count
    println("容错率为trainErr： " +trainErr)

    //创建验证类
    val metrics = new MulticlassMetrics(predictionAndLabels)
    //计算验证值
    val precision = metrics.accuracy
    println("accuracy= "+precision)

    //计算患者可能性
    val patient = model.predict(Vectors.dense(Array(70,3,180.0,4,3)))
    if(patient == 1){
      println("患者的胃癌有几率转移。 ")
    }else {
      println("患者的胃癌没有几率转移 。")
    }
  }
}
