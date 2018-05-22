package restapi;

import javax.xml.bind.annotation.XmlElement;


public class Rate {
	private String no;
	private String effectiveDate;
	private Float mid;
	private Float bid;
	private Float ask;

	@XmlElement(name = "Bid")
	public Float getBid() {
		return bid;
	}

	public void setBid(Float bid) {
		this.bid = bid;
	}

	@XmlElement(name = "Ask")
	public Float getAsk() {
		return ask;
	}

	public void setAsk(Float ask) {
		this.ask = ask;
	}

	@XmlElement(name = "No")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@XmlElement(name = "EffectiveDate")
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@XmlElement(name = "Mid")
	public Float getMid() {
		return mid;
	}

	public void setMid(Float mid) {
		this.mid = mid;
	}
}
