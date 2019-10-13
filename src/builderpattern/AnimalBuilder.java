package builderpattern;

import java.util.List;

import immutableobjectspattern.Animal;

public class AnimalBuilder {
//	Problem How do we create an object that requires numerous values 
//	to be set at the time the object is instantiated?

	private String species;
	private int age;
	private List<String> favoriteFoods;

	public AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}

	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}

	public Animal build() {
		return new Animal(species, age, favoriteFoods);
	}

}
