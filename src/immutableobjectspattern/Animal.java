package immutableobjectspattern;

import java.util.ArrayList;
import java.util.List;

// Problem: How do we create read‐only objects that can be shared and used by multiple classes?

public class Animal {
	private final String species;
	private final int age;
	private final List<String> favoriteFoods;

	public Animal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}

	// Don’t allow referenced mutable objects to be modified or accessed directly.
	// bad example

	// you should never share references to a mutable object contained within an
	// immutable object

	
//	we created a new ArrayList in the Animal constructor. This is
//	absolutely important to prevent the class that initially creates the object from maintaining
//	a reference to the mutable List used by Animal. Consider if we had just done the
//	following in the constructor:
//	this.favoriteFoods = favoriteFoods;
//	With this change, the caller that creates the object is using the same reference as the
//	immutable object, which means that it has the ability to change the List! It is important
//	when creating immutable objects that any mutable input arguments are copied to the
//	instance instead of being used directly.
}
