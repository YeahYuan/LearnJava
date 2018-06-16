/*
�������߶�����������
Lock��������ReentrantLock�����������ͬ��synchronized
Condition(await\signal\signalAll)�����������Object������
*/
import java.util.concurrent.locks.*;

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;
	//����һ��������
	Lock lock = new ReentrantLock();
	//ͨ�����е�����ȡ�����ϵļ���������
	//Condition con = lock.newCondition();
	//ͨ�����е�����ȡ������������ֱ���������ߺ�������
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	public void set(String name)
	{
		lock.lock();
		try
		{
			while (flag)
				try{producer_con.await();}catch(InterruptedException e){}
			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName()+"...������...."+this.name);
			flag = true;
			consumer_con.signal();
		}
		finally
		{
			lock.unlock();
		}
		
	}
	public void out()
	{
		lock.lock();
		try
		{
			while (!flag)
				try{consumer_con.await();}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"...������........"+this.name);
			flag = false;
			producer_con.signal();
		}
		finally
		{
			lock.unlock();
		}

		
	}
}

class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while (true)
		{
		r.set("��Ѽ");
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}




class  ProducerConsumerDemo2
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}
