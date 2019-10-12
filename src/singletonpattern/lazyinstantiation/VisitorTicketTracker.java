package singletonpattern.lazyinstantiation;

public class VisitorTicketTracker {
	// Lazy instantiation
	private static VisitorTicketTracker instance;

	private VisitorTicketTracker() {
	}

	public static VisitorTicketTracker getInstance() {
		if (instance == null) {
			instance = new VisitorTicketTracker(); // NOT THREAD-SAFE!
		}
		return instance;
	}
	// Data access methods
	// ...

	// Thread safety is the property of an object that guarantees safe execution by
	// multiple
	// threads at the same time.

	public static synchronized VisitorTicketTracker getInstancee() {
		if (instance == null) {
			instance = new VisitorTicketTracker();
		}
		return instance;
	}

	private static volatile VisitorTicketTracker instancee;

	
	// double‐checked locking
	// a design pattern in which we first test if
	// synchronization is needed before actually acquiring any locks
	public static VisitorTicketTracker getInstanceee() {
		if (instance == null) {
			synchronized (VisitorTicketTracker.class) {
				if (instancee == null) {
					instancee = new VisitorTicketTracker();
				}
			}
		}
		return instancee;
	}

}
