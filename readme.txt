发布者的开发步骤：

classes(clsId,clsName)
student(stuId,stuName,clsId)

student实体类(stuId,stuName,clsId,clsName)

1、创建实体类（实体类应该如何来写？）
	实体类应该是根据（实际需求，后台数据库）
	实际需求-->数据库建模（建立什么样子的数据库，数据库中有哪些表，表中有哪些字段，表与表之间什么关系）
	a,在自己编制的实体类上添加注解：
		@XmlRootElement(name = "实体类名") 建议使用这种，可读性好
		或者@XmlRootElement
	
2、编制接口(用来发布出去给别人调用的接口(指定的方法)，类的注解@WebService(serviceName,portName),发布出去的方法上注解@WebMethod)
	a,编制一个新的接口(没问题)
	b,复制样例接口上的注解@WebService(serviceName="接口名",portName="接口名+port",targetNamespace="你们公司的域名+/ws/接口名")
	c,编制该接口中的方法，方法上也要复制样例中的注解@WebMethod
	d,放在biz比较合适，原因：针对发布者的公司发布出去的应该是某个特定的需求方法，换句话说就要在biz层可能调用多个DAO层方法
	
3、编制接口的实现类(类的注解参见编制接口上的注解(与接口的注解内容要保持一致))
	a,直接把自己写的接口上的注解复制粘贴过来
	b,实现的方法上添加注解@WebMethod(operationName="getWeathers")
	
4、发布
	Endpoint.publish(发布的地址,实现类对象);