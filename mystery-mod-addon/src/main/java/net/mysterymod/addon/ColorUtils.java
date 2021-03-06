package net.mysterymod.addon;

import java.awt.*;

public class ColorUtils {

  public static Color color;

  public static void setColor(int r, int g, int b, boolean rainbow){
    if(rainbow == false){
      color = new Color(r, g, b);
    }else{
      color = rainbowEffect(1000000, 1.0F);
    }
  }
  public static Color rainbowEffect(long offset, float fade) {
    float hue = (float)(System.nanoTime() + offset) / 1.0E10F % 1.0F;
    long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()), 16);
    Color c = new Color((int)color);
    return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
  }
}
