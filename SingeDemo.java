//单例设计模式————重点掌握内容！！！！！

//饿汉式（常用）
class Single//类一加载，对象就已经存在
{
	private static Single s = new single();

	private Single(){}
	public static Single getInstance()//通过方法可以设置条件
	{
		return s;
	}
}
//懒汉式（面试）
class Single2//类加载进来，没有对象，只有调用了getInstance方法时，才会创建对象
				//延迟加载形式。（重要！！！！！！考试！！！！）
{
	private static Single2 s = null;

	private Single2(){}
	public static Single2 getInstance()
	{
		if(s==null)
			s = new Single2();
		return s;
	}
}





class SingleDemo 
{
	public static void main(String[] args) 
	{
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();

		System.out.println(s1==s2);

		//Single ss = Single.s;//直接用没办法设置条件
	
		//Test t1 = new Test();
		//Test t2 = new Test();
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		t1.setNum(10);
		t2.setNum(20);
		System.out.println(ta.getNum());
		System.out.println(ta.getNum());
	}
}


class Test
{
	private int num;

	private static Test t = new Test();
	private Test(){}
	public static Test getInstance()
	{
		return t;
	}


	public void setNum(int num)
	{
		this.num = num;
	}
	public int getNum()
	{
		return num;
	}



}