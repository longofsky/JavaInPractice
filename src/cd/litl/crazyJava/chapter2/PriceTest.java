package cd.litl.crazyJava.chapter2;

class Price {

//	���Ա��priceʵ��
	final static Price INSTANCE = new Price(2.8);
	
//	���������
	static double initPrice = 20;
	
	double currentPrice;
	
	public Price (double discount) {
		currentPrice = initPrice - discount;
	}
}

public class PriceTest {
	public static void main (String [] args) {
		System.out.println("1111111111");
		System.out.println(Price.INSTANCE.currentPrice);
		Price price = new Price(5);
		System.out.println(price.currentPrice);
		
	}
}
