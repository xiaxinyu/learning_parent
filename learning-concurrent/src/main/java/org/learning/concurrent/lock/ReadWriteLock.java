package org.learning.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
	private static PersonCoachData coach = new PersonCoachData();
	private static int WAITING_SECOND = 20;

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(WAITING_SECOND);
						} catch (InterruptedException e) {
						}
						Person p = coach.get();
						System.out.println("Get Person: " + (p != null ? p.toString() : "No Data"));
						if (coach.size() >= 10000) {
							break;
						}
					}
				}
			}).start();

			new Thread(new Runnable() {
				public void run() {
					int counter = 0;
					while (true) {
						try {
							Thread.sleep(WAITING_SECOND);
						} catch (InterruptedException e) {
						}
						counter++;
						String name = "name" + counter;
						Person p = new Person(name, name + "-occupation");
						coach.add(p);
						System.out.println("Finish adding Person:" + p.toString());
						if (coach.size() >= 10000) {
							break;
						}
					}
				}
			}).start();
		}
	}

}

class PersonCoachData {
	private List<Person> list = new ArrayList<Person>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public int size() {
		lock.readLock().lock();
		try {
			if (list != null && list.size() > 0) {
				return list.size();
			}
		} finally {
			lock.readLock().unlock();
		}
		return 0;
	}

	public Person get() {
		Person result = null;
		lock.readLock().lock();
		try {
			if (list != null && list.size() > 0) {
				int index = new Random().nextInt(list.size() - 1);
				result = list.get(index);
			}
		} finally {
			lock.readLock().unlock();
		}
		return result;
	}

	public void add(Person person) {
		lock.writeLock().lock();
		try {
			list.add(person);
		} finally {
			lock.writeLock().unlock();
		}
	}
}

class Person {
	private String name;
	private String occupation;

	public Person() {
	}

	public Person(String name, String occupation) {
		super();
		this.name = name;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", occupation=" + occupation + "]";
	}
}
