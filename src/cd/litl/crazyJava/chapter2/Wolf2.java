package cd.litl.crazyJava.chapter2;


class Animer2 {
	
	private String desc;
	
	public Animer2 () {
		this.desc = getDesc();
	}
	
	public String getDesc () {
		return "Animer" ;
	}
	
	public String toString () {
		return desc;
	}
	
}

public class Wolf2  extends Animer2{

	private String name ;
	private double weight;
	
	public Wolf2 (String name,double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getDesc () {
		return "Wolf2[name="+name+"wehight="+weight;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Wolf2("»ÒÌ«ÀÇ",32.2));
	}

}
