
public class Cards {
	
	private String color;
	private String cardVal;
	

	/**
	 * @param color
	 * @param cardVal
	 */
	public Cards(String color, String cardVal) {
		this.color = color;
		this.cardVal = cardVal;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCardVal() {
		return cardVal;
	}
	public void setCardVal(String cardVal) {
		this.cardVal = cardVal;
	}
	
	public void printInfo()
	{
		System.out.println(color + ", " + cardVal);
	}
	
	

}
