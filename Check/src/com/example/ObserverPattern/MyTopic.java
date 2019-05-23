package com.example.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX= new Object();
	
	public MyTopic(){
		this.observers=new ArrayList<>();
	}
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
		this.changed=false;
		this.message=null;
	}
	
	public static void main(String[] args) {
		//create subject
				MyTopic topic = new MyTopic();
				
				//create observers
				Observer obj1 = new MyTopicSubscriber("Obj1");
				Observer obj2 = new MyTopicSubscriber("Obj2");
				Observer obj3 = new MyTopicSubscriber("Obj3");
				
				//register observers to the subject
				topic.register(obj1);
				topic.register(obj2);
				topic.register(obj3);
				
				//attach observer to subject
				obj1.setSubject(topic);
				obj2.setSubject(topic);
				obj3.setSubject(topic);
				
				//check if any update is available
				obj1.update();
				
				//now send message to subject
				topic.postMessage("New Message");
				obj1.update();

	}

}
