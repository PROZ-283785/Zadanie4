package restapi;

public class AverageCounter {

	public Float getAverage(ExchangeRatesSeries ers) {
		Float avg = 0f;
		
		try {
			for(Rate e: ers.getRates()) {
				System.out.println(e.getEffectiveDate());
				System.out.println(e.getMid());
				avg += e.getMid();
			}
		} catch (NullPointerException e) {
			System.out.println("ruszyło?");
		}
		
		return avg/ers.getRates().size();
	}
}
