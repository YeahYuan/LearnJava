//�������ģʽ���������ص��������ݣ���������

//����ʽ�����ã�
class Single//��һ���أ�������Ѿ�����
{
	private static Single s = new single();

	private Single(){}
	public static Single getInstance()//ͨ������������������
	{
		return s;
	}
}
//����ʽ�����ԣ�
class Single2//����ؽ�����û�ж���ֻ�е�����getInstance����ʱ���Żᴴ������
				//�ӳټ�����ʽ������Ҫ���������������ԣ���������
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

		//Single ss = Single.s;//ֱ����û�취��������
	
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