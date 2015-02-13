import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class Input {
	int ar[] = new int[10000];
	int tos = 0;
	

	public int[] fileInput() throws IOException {
		File file = new File("input.txt");
		FileInputStream in = null;

		try {
			in = new FileInputStream(file);

			int c;
			int total = 0;

			while((c = in.read()) != -1) {
				
				if(c >= 48 && c <= 57) {
					total = (total * 10) + (c - 48);
				} else
				if(c == 32) {
					this.push(total);
					total = 0;
				} else {

				}
			}
		} finally {
			if(in != null) {
				in.close();
			}
		}

		return ar;
	}

	public void push(int number) {
		tos++;
		ar[tos] = number;
	}

	public int theTOS() {
		return tos;
	}

}