package drawers;

import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;

public abstract class ElementDrawer<T extends Element> {
    public abstract void draw(T element, TextGraphics graphics);
}
