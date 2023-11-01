public class AccountingIFUnder10000App{
	public static void main(String[] args) {
		
		double valueOfsupply =  Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfsupply * vatRate;
		double total = valueOfsupply + vat;
		double expense = valueOfsupply * expenseRate;
		double income = valueOfsupply - expense;
		double dividend1 = income * 1.0;
		double dividend2 = income * 0;
		double dividend3 = income * 0;
		
		System.out.println("Value of supply : " + valueOfsupply);
		System.out.println("VAT : " + vat);
		System.out.println("Total : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		
		System.out.println("Dividend 1 : " + dividend1);
		
		System.out.println("Dividend 2 : " + dividend2);
		
		System.out.println("Dividend 3 : " + dividend3);
		
		
	}
}