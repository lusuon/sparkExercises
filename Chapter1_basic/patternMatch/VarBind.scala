package Chapter1_basic.patternMatch

/**
  * Created by taos.
  * 变量绑定模式 (variable binding patterns)
  * 这个和前边的变量模式有什么不同？看一下代码就清楚了：
  * 依然是上面的TreeNode，如果我们希望匹配到左边节点值为”left”就返回这个节点的话：
  */
object VarBind {
  def main(args: Array[String]) {
    val tree = Tree(TreeNode("root",TreeNode("left", null, null),TreeNode("right", null, null)))
    println(tree.root match {
      case TreeNode(_, leftNode_var@TreeNode("left",_,_), _) => leftNode_var
      case _ => println("error")
    })
  }
}
