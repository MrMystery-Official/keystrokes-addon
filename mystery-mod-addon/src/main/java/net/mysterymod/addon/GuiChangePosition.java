package net.mysterymod.addon;

import net.mysterymod.api.gui.Gui;
import net.mysterymod.api.gui.elements.IButton;
import net.mysterymod.mod.MysteryMod;

import java.awt.*;

public class GuiChangePosition extends Gui {

  public static boolean mouseDown = false;

  @Override
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    drawDefaultBackground();
    drawHelper.drawRect(this.getWidth() - MysteryModAddon.centredPosX, MysteryModAddon.centredPosY, this.getWidth() - MysteryModAddon.centredPosX + 24, MysteryModAddon.centredPosY + 24, new Color(47, 53, 66, 150).getRGB());
    drawHelper.drawCenteredString("W", this.getWidth() - MysteryModAddon.centredPosX + 12, MysteryModAddon.centredPosY+9, ColorUtils.color.getRGB());
      drawHelper.drawRect(this.getWidth() - MysteryModAddon.centredPosX - 3 - 24, MysteryModAddon.centredPosY + 24 + 3, this.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(47, 53, 66, 150).getRGB());
    drawHelper.drawCenteredString("A", this.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 12, MysteryModAddon.centredPosY + 24 + 3 + 9, ColorUtils.color.getRGB());
      drawHelper.drawRect(this.getWidth() - MysteryModAddon.centredPosX, MysteryModAddon.centredPosY + 24 + 3, this.getWidth() - MysteryModAddon.centredPosX + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(47, 53, 66, 150).getRGB());
    drawHelper.drawCenteredString("S", this.getWidth() - MysteryModAddon.centredPosX + 12, MysteryModAddon.centredPosY + 24 + 3 + 9, ColorUtils.color.getRGB());
      drawHelper.drawRect(this.getWidth() - MysteryModAddon.centredPosX + 27, MysteryModAddon.centredPosY + 24 + 3, this.getWidth() - MysteryModAddon.centredPosX + 27 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(47, 53, 66, 150).getRGB());
    drawHelper.drawCenteredString("D", this.getWidth() - MysteryModAddon.centredPosX + 27 + 12, MysteryModAddon.centredPosY + 24 + 3 + 9, ColorUtils.color.getRGB());
    if(MysteryModAddon.config.isSpace()) {
        drawHelper.drawRect(this.getWidth() - MysteryModAddon.centredPosX - 3 - 24, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3, this.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 24 + 3 + 24 + 3 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3 + 16, new Color(47, 53, 66, 150).getRGB());
      drawHelper.drawString("§m----------", this.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 9, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3 + 7, ColorUtils.color.getRGB());
    }

    if(mouseDown){
      MysteryModAddon.centredPosX = (this.getWidth()-mouseX+12);
      MysteryModAddon.centredPosY = mouseY - 24 - 3 - 12;
      MysteryModAddon.config.setX(MysteryModAddon.centredPosX);
      MysteryModAddon.config.setY(MysteryModAddon.centredPosY);
      MysteryModAddon.config.saveConfig();
    }

  }

  @Override
  public boolean onEscape() {
    mouseDown = false;
    return super.onEscape();
  }

  @Override
  protected void initGui() {
    mouseDown = false;
    IButton backButton = widgetFactory.createModButton(this.getWidth()/2-100, this.getHeight()-20-10, 200, 20, "Speichern", clickListener -> {
      MysteryModAddon.guiFactory.displayGui(null);
    });
    addWidget(backButton);
    super.initGui();
  }

  @Override
  protected void mouseReleased(int mouseX, int mouseY, int mouseButton) {
    mouseDown = false;
    super.mouseReleased(mouseX, mouseY, mouseButton);
  }

  @Override
  protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {

    System.out.println("MOUSE DOWN");
    mouseDown = true;
    super.mouseClicked(mouseX, mouseY, mouseButton);
  }
}
