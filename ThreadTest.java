/*
快速开启线程的方式
*/



class  ThreadTest
{
	public static void main(String[] args) 
	{
		//主函数
		for (int x=0; x<10; x++)
		{
			System.out.println(Thread.currentThread().getName()+".......x="+x);
		}
		//快速开启线程方法一：
		new Thread()
		{
			public void run()
			{
				for (int x=0; x<10; x++)
				{
					System.out.println(Thread.currentThread().getName()+".......y="+x);
				}
			}
		}.start();

		//快速开启线程方法二
		Runnable r = new Runnable()
		{
			public void run()
			{
				for (int x=0; x<10; x++)
				{
					System.out.println(Thread.currentThread().getName()+".......z="+x);
				}
			}
		};
		new Thread(r).start();

		//快速开启线程方法三		
		new Thread(new Runnable()
		{
			public void run()
			{
				for (int x=0; x<10; x++)
				{
					System.out.println(Thread.currentThread().getName()+".......p="+x);
				}
			}
		}).start();
	}
}
