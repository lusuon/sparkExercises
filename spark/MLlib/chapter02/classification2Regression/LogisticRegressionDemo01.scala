

import org.apache.spark.mllib.classification.{LogisticRegressionModel, LogisticRegressionWithLBFGS}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object LogisticRegressionDemo01 {

  def main(args: Array[String]): Unit = {
    val conf =  new SparkConf().setAppName("LogisticRegressionDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val root = "D:\\data\\sparkmllib\\"
    // Load training data in LIBSVM format.
    val data = MLUtils.loadLibSVMFile(sc, root + "sample_libsvm_data.txt")

    // Split data into training (60%) and test (40%).
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
    val training = splits(0).cache()
    val test = splits(1)

    /*
    有两种最优化算法可以求解逻辑回归问题并求出最优参数：
    mini-batch gradient descent(梯度下降法），L-BFGS法。
    我们更推荐使用L-BFGS，因为它能更快聚合,
    而且现在spark2.1.0已经放弃LogisticRegressionWithLSGD()模式了*/
    // Run training algorithm to build the model
    val model:LogisticRegressionModel = new LogisticRegressionWithLBFGS()
      .setNumClasses(10)
      .run(training)

      // Compute raw scores on the test set.
      val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
        val prediction = model.predict(features)
        (prediction, label)
    }

    // Get evaluation metrics.
    val metrics = new MulticlassMetrics(predictionAndLabels)
    val precision = metrics.precision
    println("Precision = " + precision)
    val accuracy = metrics.accuracy
    println("accuracy = " + precision)

    // Save and load model
    /*model.save(sc, "models/LogisticRegressionModel")
    val sameModel = LogisticRegressionModel.load(sc, "models/LogisticRegressionModel")*/
  }

}
