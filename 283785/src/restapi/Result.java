package restapi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
	private String currency;
	private Float mid;
	
	public Result() {}
	
	public Result(String cur, Float mid) {
		setCurrency(cur);
		setMid(mid);
	}
	
	@XmlElement(name = "Currency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@XmlElement(name = "Mid")
	public Float getMid() {
		return mid;
	}
	public void setMid(Float mid) {
		this.mid = mid;
	}
	
	@Override 
	public String toString() {
		return currency + " " + mid;
	}
	
}
