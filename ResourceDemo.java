/*
线程间通信
多个线程在处理同一资源，但任务不同

等待唤醒机制
涉及方法：
1,wait()——让线程处于冻结状态，被wait的线程会被存储到线程池中
2,notify()——唤醒线程池中的一个线程（任意）
3,notifyAll()——唤醒线程池中的所有线程

*/


//资源
class Resource
{
	private String name;
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(InterruptedException e){}
		this.name = name;
		this.sex = sex;
		flag = true;
		notify();
	}
	public synchronized void out()
	{
		if(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(name+"...."+sex);
		flag = false;
		notify();
	}
}

//输入
class Input implements Runnable
{
	Resource r;
	Input(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while (true)
		{
				if (x==0)
				{
					r.set("mike","nan");
				}
				else
				{
					r.set("丽丽","女女女女女");
				}
				x = (x+1)%2;
		}
	}
}


//输出
class Output implements Runnable
{
	Resource r;
	Output(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while (true)
		{
			r.out();
		}
	}
}



class ResourceDemo 
{
	public static void main(String[] args) 
	{
		//创建资源
		Resource r = new Resource();
		//创建任务
		Input in = new Input(r);
		Output out = new Output(r);
		//创建线程（执行路径）
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//启动线程
		t1.start();
		t2.start();
	}
}
