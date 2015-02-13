import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws IOException { 
		Heap heap = new Heap();

		System.out.println(args.length);
		if(args.length == 1){
			switch(args[0]) {
				case "Fast" :	
					heap.sort(true);
					break;
				case "Slow" :
					heap.sort(false);
					break;
				default :
					System.out.println("Invalid Arguments! Please specify Fast or Slow!");
					heap.close();
					break;
			}
		} else {
			System.out.println("Invalid Arguments! Please specify Fast or Slow!");
			heap.close();
		}
	}
}