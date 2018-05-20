package restapi;

public class AverageCounter {

	public Float getAverage(ExchangeRatesSeries ers) {
		Float avg = 0f;

		for (Rate e : ers.getRates()) {
			System.out.println(e.getEffectiveDate());
			System.out.println(e.getMid());
			avg += e.getMid();
		}

		return avg / ers.getRates().size();
	}
}
