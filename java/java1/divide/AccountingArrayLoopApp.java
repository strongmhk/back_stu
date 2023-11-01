public class AccountingArrayLoopApp{
	public static void main(String[] args) {
		
		double valueOfsupply =  Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfsupply * vatRate;
		double total = valueOfsupply + vat;
		double expense = valueOfsupply * expenseRate;
		double income = valueOfsupply - expense;
		
	
		
		double[] dividendRates = new double[3];
		dividendRates[0] = 0.5;
		dividendRates[1] = 0.3;
		dividendRates[2] = 0.2;
		
		
		double[] dividend = new double[3];
		for(int i = 0; i < dividendRates.length; ++i) {
			dividend[i] = income * dividendRates[i];
		}
//		double dividend1 = income * dividendRates[0];
//		double dividend2 = income * dividendRates[1];
//		double dividend3 = income * dividendRates[2];
		
		
		System.out.println("Value of supply : " + valueOfsupply);
		System.out.println("VAT : " + vat);
		System.out.println("Total : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		
		for(int i = 0; i < dividendRates.length; ++i) {
			System.out.printf("Dividend %d : %.1f\n", i+1, dividend[i]);
		}
		
	
		
	}
}