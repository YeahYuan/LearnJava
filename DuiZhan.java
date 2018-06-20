package cn.itcast.day17.linkedlist.test;

import java.util.LinkedList;

public class DuiZhan {
	private LinkedList link;
	
	public DuiZhan()
	{
		link = new LinkedList();
	}
	public void myAdd(Object obj)
	{
		link.addFirst(obj);
	}
	public Object myGet()
	{
		return link.removeFirst();
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}
}
