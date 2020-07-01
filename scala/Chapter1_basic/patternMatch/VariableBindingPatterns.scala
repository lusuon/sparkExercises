package scala.Chapter1_basic.patternMatch

/**
 * @author taoshi
 */
object VariableBindingPatterns {
  def main(args: Array[String]): Unit = {
     //如果我们希望匹配到左边节点值为”left”就返回这个节点的话
     println(variableBinding(TreeNode("root",TreeNode("left",null,null),TreeNode("right",null,null))))
  
  }
  
  def variableBinding(tree: TreeNode): TreeNode =  tree match {
       case TreeNode(_, leftTreeNode@TreeNode("left",_,_), _)
       => leftTreeNode
       case _ => null
  }
}