package cn.itcast.day17.linkedlist.test;
import java.util.LinkedList;

public class DuiLie {
	private LinkedList link;
	
	public DuiLie()
	{
		link = new LinkedList();
	}
	public void myAdd(Object obj)
	{
		link.addFirst(obj);
	}
	public Object myGet()
	{
		return link.removeLast();
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}	
}
