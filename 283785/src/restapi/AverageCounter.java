package restapi;

public class AverageCounter {

	public Float getAverage(ExchangeRatesSeries ers) {
		Float avg = 0f;

		for (Rate e : ers.getRates()) {
			System.out.println(e.getEffectiveDate());
			if(e.getMid() != null) {
				avg += e.getMid();
			} else {
				avg += (e.getAsk() + e.getBid()) / 2; 
			}
			
		}

		return avg / ers.getRates().size();
	}
}
