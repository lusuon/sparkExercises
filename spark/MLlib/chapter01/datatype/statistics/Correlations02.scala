/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println



import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
 * An example app for summarizing multivariate data from a file. Run with
 * {{{
 * bin/run-example org.apache.spark.examples.mllib.Correlations
 * }}}
 * By default, this loads a synthetic dataset from `data/mllib/sample_linear_regression_data.txt`.
 * If you use it as a template to create your own app, please use `spark-submit` to submit your app.
 */
object Correlations02 {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Correlations02").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val root = ""
    val examples = MLUtils.loadLibSVMFile(sc, root + "sample_linear_regression_data.txt").cache()

    println(s"${examples.count()} data points")

    // Calculate label -- feature correlations
    val labelRDD = examples.map(_.label)
    val numFeatures = examples.take(1)(0).features.size
    val corrType = "pearson"
    println()
    println(s"Correlation ($corrType) between label and each feature")
    println(s"Feature\tCorrelation")
    var feature = 0
    while (feature < numFeatures) {
      val featureRDD = examples.map(_.features(feature))
      val corr = Statistics.corr(labelRDD, featureRDD)
      println(s"$feature\t$corr")
      feature += 1
    }
    println()

    sc.stop()

  }
}
// scalastyle:on println
