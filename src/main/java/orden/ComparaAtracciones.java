package orden;

import java.util.Comparator;

import model.Attraction;

public class ComparaAtracciones implements Comparator<Attraction> {

	// @Override
	public int compare(Attraction a1, Attraction a2) {

		if (a1.getCost() > a2.getCost()) {
			return -1;
		} else if (a1.getCost() < a2.getCost()) {

			return 1;
		}

		if (a1.getDuration() > a2.getDuration()) {
			return -1;
		} else if (a1.getDuration() < a2.getDuration()) {

			return 1;
		}
		return 0;
	}

}