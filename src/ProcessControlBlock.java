import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessControlBlock {
	int processID;
	String processState;
	int programCounter;
	int[] memoryBoundaries;

	public ProcessControlBlock(int processID, int[] memoryBoundaries) {
		this.processID = processID;
		this.processState = null;
		this.programCounter = 0;
		this.memoryBoundaries = memoryBoundaries;
	}

	public void printPCB() {
		System.out.println("Process ID : " + this.processID);
		System.out.println("Process State : " + this.processState);
		System.out.println("Program Counter : " + this.programCounter);
		System.out.println("Memory Boundaries: --> Start : " + memoryBoundaries[0]);
		System.out.println("Memory Boundaries: --> End : " + memoryBoundaries[1]);
	}

	public void incrementPC() {
		this.programCounter = this.programCounter + 1;
	}

	public void changeState(String newState) {
		this.processState = newState;
	}

	public static void main(String[] args) {
		HashMap<String, ProcessControlBlock> map = new HashMap<String, ProcessControlBlock>();
		int[] memB = { 0, 1 };
//		ProcessControlBlock pcb = new ProcessControlBlock(0, memB);
//		pcb.printPCB();
//		pcb.incrementPC();
//		pcb.changeState("blocked");
//		pcb.printPCB();
		for (int i = 0; i < 3; i++) {
			ProcessControlBlock pcb = new ProcessControlBlock(i, memB);
			map.put(i + "", pcb);
		}
		map.get("1").incrementPC();
		map.get("1").printPCB();
		map.get("0").printPCB();
		int int_random = ThreadLocalRandom.current().nextInt();
		while (int_random < 0) {
			int_random = ThreadLocalRandom.current().nextInt();
		}
		System.out.println("Random Integers: " + int_random);
	}
}
