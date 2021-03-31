package drawers;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import element.Coin;

public class CoinDrawer extends ElementDrawer<Coin>{
    @Override
    public void draw(Coin element, TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#fcba03"));
        graphics.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), "C");
    }
}
