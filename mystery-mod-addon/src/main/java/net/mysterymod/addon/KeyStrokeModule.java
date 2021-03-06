package net.mysterymod.addon;

import com.google.inject.Inject;
import net.mysterymod.api.annotation.Init;
import net.mysterymod.api.event.EventHandler;
import net.mysterymod.api.event.render.RenderOverlayEvent;
import net.mysterymod.api.graphics.IDrawHelper;
import net.mysterymod.api.listener.InitListener;
import net.mysterymod.api.listener.ListenerChannel;
import net.mysterymod.mod.MysteryMod;
import net.mysterymod.mod.emote.UserEmote;
import net.mysterymod.mod.emote.emotes.Emote;
import net.mysterymod.mod.emote.emotes.EmoteRegistry;
import net.mysterymod.protocol.item.Item;

import java.awt.*;

@Init
public class KeyStrokeModule implements InitListener {

  public static IDrawHelper drawHelper;

  @Inject
  public KeyStrokeModule(IDrawHelper drawer){
    drawHelper = drawer;
  }

  @Override
  public void onModInit(MysteryMod mysteryMod, ListenerChannel listenerChannel) {
    listenerChannel.registerListener(this);
    System.out.println("######################################################################");
  }

  @EventHandler
  public void onOverlay(RenderOverlayEvent e) {
    if(MysteryModAddon.config.isEnabled()) {
      if (MysteryModAddon.wPressed) {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX, MysteryModAddon.centredPosY, e.getWidth() - MysteryModAddon.centredPosX + 24, MysteryModAddon.centredPosY + 24, new Color(189, 195, 199, 200).getRGB());
      } else {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX, MysteryModAddon.centredPosY, e.getWidth() - MysteryModAddon.centredPosX + 24, MysteryModAddon.centredPosY + 24, new Color(47, 53, 66, 150).getRGB());
      }
      drawHelper.drawCenteredString("W", e.getWidth() - MysteryModAddon.centredPosX + 12, MysteryModAddon.centredPosY+9, ColorUtils.color.getRGB());
      if (MysteryModAddon.aPressed) {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX - 3 - 24, MysteryModAddon.centredPosY + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(189, 195, 199, 200).getRGB());
      } else {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX - 3 - 24, MysteryModAddon.centredPosY + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(47, 53, 66, 150).getRGB());
      }
      drawHelper.drawCenteredString("A", e.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 12, MysteryModAddon.centredPosY + 24 + 3 + 9, ColorUtils.color.getRGB());
      if (MysteryModAddon.sPressed) {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX, MysteryModAddon.centredPosY + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(189, 195, 199, 200).getRGB());
      } else {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX, MysteryModAddon.centredPosY + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(47, 53, 66, 150).getRGB());
      }
      drawHelper.drawCenteredString("S", e.getWidth() - MysteryModAddon.centredPosX + 12, MysteryModAddon.centredPosY + 24 + 3 + 9, ColorUtils.color.getRGB());
      if (MysteryModAddon.dPressed) {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX + 27, MysteryModAddon.centredPosY + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX + 27 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(189, 195, 199, 200).getRGB());
      } else {
        drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX + 27, MysteryModAddon.centredPosY + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX + 27 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24, new Color(47, 53, 66, 150).getRGB());
      }
      drawHelper.drawCenteredString("D", e.getWidth() - MysteryModAddon.centredPosX + 27 + 12, MysteryModAddon.centredPosY + 24 + 3 + 9, ColorUtils.color.getRGB());
      if(MysteryModAddon.config.isSpace()) {
        if (MysteryModAddon.spacePressed) {
          drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX - 3 - 24, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 24 + 3 + 24 + 3 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3 + 16, new Color(189, 195, 199, 200).getRGB());
        } else {
          drawHelper.drawRect(e.getWidth() - MysteryModAddon.centredPosX - 3 - 24, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3, e.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 24 + 3 + 24 + 3 + 24, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3 + 16, new Color(47, 53, 66, 150).getRGB());
        }
        drawHelper.drawString("§m----------", e.getWidth() - MysteryModAddon.centredPosX - 3 - 24 + 9, MysteryModAddon.centredPosY + 24 + 3 + 24 + 3 + 7, ColorUtils.color.getRGB());
      } }
  }

}
