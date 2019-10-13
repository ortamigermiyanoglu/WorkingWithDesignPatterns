package immutableobjectspattern;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ModifyingImmutableObject {
	
//	How do we modify immutable objects if they are inherently unmodifiable? The answer is,
//	we can’t! Alternatively, we can create new immutable objects that contain all of the same
//	information as the original object plus whatever we wanted to change.

	public static void main(String[] args) {
		
		// Create a new  immutable Animal instance
		Animal lion = new Animal("lion", 5, Arrays.asList("meat", "more meat"));

		// Create a new Animal instance using data from the first instance
		List<String> favoriteFoods = new ArrayList<String>();
		for (int i = 0; i < lion.getFavoriteFoodsCount(); i++) {
			favoriteFoods.add(lion.getFavoriteFood(i));
		}

		Animal updatedLion = new Animal(lion.getSpecies(), lion.getAge() + 1, favoriteFoods);
	}

}
