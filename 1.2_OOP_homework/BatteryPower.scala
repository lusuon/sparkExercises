/**
  * 3.自己设计一套特质，要求体现叠加在一起的特质，设计具体的抽象方法抽象字段
  *  创建trait BatteryPower 来报告剩余电量。如果电量多余40%，那么报告“green”；如果在
  * 20%~39% 之间 那么报告yellow；如果少于20%，那么报告”red”。实例化该代码满足下列测
  * 试： class Battery extends EnergySource with BatteryPower
  * val battery = new Battery
  * battery.monitor(80) is “green”
  * battery.monitor(30) is “yellow”
  * battery.monitor(10) is “red
  */

trait BatteryPower{}