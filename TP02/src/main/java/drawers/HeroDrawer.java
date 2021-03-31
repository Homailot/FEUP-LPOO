package drawers;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Element;

public class HeroDrawer extends ElementDrawer {
    @Override
    public void draw(Element element, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), "H");
    }
}
