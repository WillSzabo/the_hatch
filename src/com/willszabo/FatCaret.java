package com.willszabo;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

class FatCaret extends DefaultCaret {

	
	@Override
	protected synchronized void damage(Rectangle r) {
		if (r == null) {
			return;
		}
		// give values to x,y,width,height (inherited from java.awt.Rectangle)
		x = r.x;
		y = r.y;
		width = 7;
		height = 16;
		repaint(); // calls getComponent().repaint(x, y, width, height)
	}

	@SuppressWarnings("deprecation")
	@Override
	public void paint(Graphics g) {
		JTextComponent comp = getComponent();
		if (comp == null) {
			return;
		}
	
		int dot = getDot();
		Rectangle r = null;
		
		try {
			r = comp.modelToView(dot);
		} catch (BadLocationException e) {
			return;
		}
			if (r == null) {
			return;
		}
	
	
		if (isVisible()) {
			g.setColor(comp.getCaretColor());
			g.fill3DRect(r.x, r.y, width, height, true);
		}
	}

}