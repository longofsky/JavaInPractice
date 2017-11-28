package cd.litl.designmode.facade;

public class Computer {

	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer () {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.disk = new Disk();
	}
	public void startUp () {
		System.out.println("Computer startup");
		cpu.startUp();
		memory.startUp();
		disk.startUp();
		System.out.println("Computer startup finished");
		
	}
	
	public void shutDown () {
		System.out.println("Computer shutDown");
		cpu.shutDown();
		memory.shutDown();
		disk.shutDown();
		System.out.println("Computer shutDown finished");
	}
}
