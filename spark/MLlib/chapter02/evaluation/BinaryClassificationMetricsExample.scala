


import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils

/**
  * 二分类评估Example
  */
object BinaryClassificationMetricsExample {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("BinaryClassificationMetricsExample").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    // Load training data in LIBSVM format
    val root = ""
    val data = MLUtils.loadLibSVMFile(sc, root + "sample_binary_classification_data.txt")

    // Split data into training (60%) and test (40%)
    val Array(training, test) = data.randomSplit(Array(0.6, 0.4), seed = 11L)
    training.cache()

    // Run training algorithm to build the model
    val model = new LogisticRegressionWithLBFGS()
      .setNumClasses(2)
      .run(training)

    // Clear the prediction threshold so the model will return probabilities
    /**
      * threshold变量用来控制分类的阈值，默认值为0.5。
      * 表示如果预测值小于threshold则为分类0.0，否则为1.0。
      */
    model.clearThreshold

    // Compute raw scores on the test set
    val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
      val prediction = model.predict(features)
      (prediction, label)
    }

    // Instantiate metrics object
    val metrics = new BinaryClassificationMetrics(predictionAndLabels)

    // Precision by threshold
    val precision = metrics.precisionByThreshold
    println(s"====================各个threshold下的精准率========================")
    precision.foreach { case (t, p) =>
      println(s"Threshold: $t, Precision: $p")
    }

    // Recall by threshold
    val recall = metrics.recallByThreshold
    println(s"====================各个threshold的召回率========================")
    recall.foreach { case (t, r) =>
      println(s"Threshold: $t, Recall: $r")
    }

    // Precision-Recall Curve (recall, precision)
    println(s"====================精准率-召回率曲线========================")
    val PRC = metrics.pr

    // F-measure
    val f1Score = metrics.fMeasureByThreshold
    println("====================F-measure beta=1时========================")
    // beta=1.0表示精准率和召回率同等重要;
    // beta=0.5表示召回率是精准率的0.5倍;
    // beta=1.5表示召回率是精准率的1.5倍;
    f1Score.foreach { case (t, f) =>
      println(s"Threshold: $t, F-score: $f, Beta = 1")
    }

    val beta = 0.5
    val fScore = metrics.fMeasureByThreshold(beta)
    println("====================F-measure beta=0.5时========================")
    f1Score.foreach { case (t, f) =>
      println(s"Threshold: $t, F-score: $f, Beta = 0.5")
    }

    // AUPRC
    val auPRC = metrics.areaUnderPR
    println("====================精准率-召回率曲线曲线面积========================")
    println(s"Area under precision-recall curve = $auPRC")

    // Compute thresholds used in ROC and PR curves
    val thresholds = precision.map(_._1)

    // ROC Curve
    println("====================ROC曲线========================")
    val roc = metrics.roc
    roc.foreach{case (t, f) =>
        println(s"FPR = $t, TPR = $f")
    }

    // AUC越大，模型越好。
    val auROC = metrics.areaUnderROC
    println("====================AUC========================")
    println(s"Area under ROC = $auROC")
    // $example off$
    sc.stop()
  }
}
// scalastyle:on println
