/*
���ٿ����̵߳ķ�ʽ
*/



class  ThreadTest
{
	public static void main(String[] args) 
	{
		//������
		for (int x=0; x<10; x++)
		{
			System.out.println(Thread.currentThread().getName()+".......x="+x);
		}
		//���ٿ����̷߳���һ��
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

		//���ٿ����̷߳�����
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

		//���ٿ����̷߳�����		
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
