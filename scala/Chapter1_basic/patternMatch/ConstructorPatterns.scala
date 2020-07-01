package scala.Chapter1_basic.patternMatch

/**
 * @author taoshi
 * 真正能够体现模式匹配的能力
 */
object ConstructorPatterns {
   def main(args: Array[String]): Unit = {
     val tree = Tree(TreeNode("root",TreeNode("left",null,null),TreeNode("right",null,null)))
     //希望构造一个节点 左子节点值为”left”，右子节点值为”right”并且右子节点没有子节点
     
     tree.root match {
       case TreeNode("root", TreeNode("left",_,_), TreeNode("right", null, null))
       =>
       println("ok")
       case _ => println("error")
     }
     
   }
}

case class TreeNode(v:String, left:Node, right:Node) extends Node

case class Tree(root:TreeNode)