class Accounting {
	Accounting(double valueOfSupply, double vatRate){
		this.valueOfSupply = valueOfSupply;
		this.vatRate = vatRate;
		
	}
	// 공급가액, 부가가치세율
    public double valueOfSupply = 0.0; 
    public double vatRate = 0.0;
    
    public double getVAT() {
    	return this.valueOfSupply * this.vatRate;
    }
    public double getTotal() {
    	return this.valueOfSupply + getVAT();
    }
    
    public void printVAT() {
    	System.out.println("VAT : " + getVAT());
    }
    
    public void printTotal() {
    	System.out.println("Total : " + getTotal());
    }
}


public class _4ClassApp { // 회계 프로그램 만들기
    public static void main(String[] args) {
    	
    	Accounting a1 = new Accounting(10000.0, 0.1);
    	a1.printVAT();
    	a1.printTotal();
    	
    	Accounting a2 = new Accounting(12000.0, 0.2);
    	a2.printVAT();
    	a2.printTotal();
    	
    	
    }
 
}