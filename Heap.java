import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;

public class Heap{
	int numbers[] = new int[10000];
	int tos;
	int height;
	int width;
	Paint paint;
	JFrame frame = new JFrame();

	
	public Heap() throws IOException {
		this.getNumbers();
		
		height = 541;
		width = tos;

		paint = new Paint(numbers, width, height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width + 16, height);
		frame.add(paint);
		frame.setVisible(true);
	}

	public void getNumbers() throws IOException {
		Input intext = new Input();
		
		numbers = intext.fileInput();

		tos = intext.theTOS() - 1;
		numbers[0] = tos;
	}

	 public void display(int swap, boolean speed) {
		if(!speed) {	
			try {
   				Thread.sleep(1);               
			} catch(InterruptedException ex) {
	    		Thread.currentThread().interrupt();
			}
		} else {
			try {
   				Thread.sleep(5);               
			} catch(InterruptedException ex) {
	    		Thread.currentThread().interrupt();
			}
		}

		paint.reDraw(numbers,numbers[0], swap);
	}

	public void heapify(int max, boolean speed) {
		int index;

		for(int i = 1; i < max; i++) {
			index = i;

			while(numbers[index / 2] < numbers[index] && (index/2) != 0) {
				int temp = numbers[index/2];
				numbers[index/2] = numbers[index];
				numbers[index] = temp;
				index = index/2;
				if(!speed) {
					display((int)index/2, speed);
				}
			}
			
		}	
	}

	public void sort(boolean speed) {
		while(numbers[0] > 0) {
			

			//Put first number on the end	
			int temp = numbers[1];
			numbers[1] = numbers[numbers[0]];
			numbers[numbers[0]] = temp;

			//Puts largest number on top of heap
			this.heapify(numbers[0], speed);

			if(speed) {
				display(0, speed);
			}


			numbers[0]--;

		}
	}

	public void close() {
		frame.setVisible(false);
		System.exit(0);
	}
}