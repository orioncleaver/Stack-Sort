import javax.swing.*;
import java.awt.*;
import java.util.Random;

  class Paint extends JPanel {
	
	int width = 0;
	int[] source;
	int height = 0;
	int max = 0;
	int finishline = 0;
	int switcher = 0;
	Random rand = new Random();


	public Paint(int[] numbers, int inW, int inH) {
		source = numbers; 
		width = inW;
		height = inH;
		for (int i = 1; i < width; i ++) {
			if(source[i] > max) {
				max = source[i];
			}
		}
		setPreferredSize(new Dimension(width, 500));
		setSize(width, 500);
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        	g.setColor(Color.BLACK);
        
        for (int i = 1; i < width; i++) {
        	if(i >= finishline) {
        		switch(rand.nextInt(4)) {
        			case 0: g.setColor(Color.RED);
        				break;
        			case 1: g.setColor(Color.BLUE);
        				break;	
        			case 3: g.setColor(Color.PINK);
        				break;
        			case 4: g.setColor(Color.ORANGE);
        				break;
        			default: g.setColor(Color.GREEN);
        				break;
        		}
        	} else if (i == switcher) {
        		g.setColor(Color.MAGENTA);
        	} else {
        		switch(rand.nextInt(3)) {
        			case 0: g.setColor(Color.GRAY);
        				break;
        			case 1: g.setColor(Color.DARK_GRAY);
        				break;	
        			case 3: g.setColor(Color.LIGHT_GRAY);
        				break;
        			case 4: g.setColor(Color.BLACK);
        				break;
        			default: g.setColor(Color.WHITE);
        				break;
        		}
        	}
        		switch(rand.nextInt(3)) {
        			case 0: this.setBackground(Color.GRAY);
        				break;
        			case 1: this.setBackground(Color.DARK_GRAY);
        				break;	
        			case 3: this.setBackground(Color.LIGHT_GRAY);
        				break;
        			case 4: this.setBackground(Color.BLACK);
        				break;
        			default: this.setBackground(Color.WHITE);
        				break;
        		}

        	g.drawLine(i, 500, i, 500 - ((source[i] * 500) / max));
        }
    }

    public void reDraw(int[] newNumbers, int cut, int swap) {
    	source = newNumbers;
    	finishline = cut;
    	switcher = swap;
    	
    	this.repaint();
    }

   



}