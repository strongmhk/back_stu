
public class _4AccountingApp {
	// 공급가액
	public static double valueOfSupply = 10000.0;
	//부가가치세율
	public static double vatRate = 0.1;
	
	public static double getTotal() {
		return valueOfSupply + getVAT();
	}
	
	
	public static double getVAT() {
		return valueOfSupply * vatRate;
	}
		
	
	public static void main(String[] args) {
		
		
		
		System.out.println("Value of supply : " + valueOfSupply);
		System.out.println("VAT : " + getVAT()); // 부가세
		System.out.println("Total : " + getTotal()); // 합계

	}

}
