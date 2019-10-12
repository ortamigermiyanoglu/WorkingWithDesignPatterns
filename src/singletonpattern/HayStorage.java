package singletonpattern;

/*
 * How do we create an object in memory only once in an application and have it
 * shared by multiple classes?
 */

/*
 * The singleton pattern is a creational pattern focused on creating only one
 * instance of an object in memory within an application, sharable by all classes and threads
 * within the application. The globally available object created by the singleton pattern is
 * referred to as a singleton.
*/

public class HayStorage {
	private int quantity = 0;

	private HayStorage() {
	}

	private static final HayStorage instance = new HayStorage();

	public static HayStorage getInstance() {
		return instance;
	}

	public synchronized void addHay(int amount) {
		quantity += amount;
	}

	public synchronized boolean removeHay(int amount) {
		if (quantity < amount)
			return false;
		quantity -= amount;
		return true;
	}

	public synchronized int getHayQuantity() {
		return quantity;
	}

	/*
	 * creational patterns simply apply a level of indirection to object creation by
	 * creating the object in some other class, rather than creating the object
	 * directly in your application. Level of indirection is a general term for
	 * solving a software design problem by conceptually separating the task into
	 * multiple levels.
	 */

}