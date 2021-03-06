package net.mysterymod.addon;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import lombok.RequiredArgsConstructor;
import net.mysterymod.api.event.EventHandler;
import net.mysterymod.api.event.game.GameTickEvent;
import net.mysterymod.api.graphics.IDrawHelper;
import net.mysterymod.api.gui.IGuiFactory;
import net.mysterymod.api.input.Keyboard;
import net.mysterymod.api.listener.ListenerChannel;
import net.mysterymod.api.minecraft.KeyCode;
import net.mysterymod.api.module.category.ModuleCategoryRegistry;
import net.mysterymod.mod.MysteryMod;
import net.mysterymod.mod.addon.Addon;
import net.mysterymod.mod.gui.inventory.ItemInventoryGui;
import sun.java2d.opengl.OGLDrawImage;

import java.awt.*;

@Singleton
public class MysteryModAddon extends Addon {
  public static Injector injector;
  private final ListenerChannel listenerChannel;
  public static IGuiFactory guiFactory;
  public static Keyboard keyboard;

  public static KeyStrokesConfig config;

  public static boolean wPressed = false;
  public static boolean aPressed = false;
  public static boolean sPressed = false;
  public static boolean dPressed = false;
  public static boolean spacePressed = false;
  public static ItemInventoryGui gui;
  public static IDrawHelper drawHelper;
  public static int centredPosX = 56;
  public static int centredPosY = 8;

  @Inject
  public MysteryModAddon(Injector inject, ModuleCategoryRegistry moduleCategoryRegistry){
    injector = inject;
    listenerChannel = injector.getInstance(ListenerChannel.class);
    config = injector.getInstance(KeyStrokesConfig.class);
    drawHelper = injector.getInstance(IDrawHelper.class);
    guiFactory = injector.getInstance(IGuiFactory.class);
  }

  @Override
  public void onEnable() {
    setSettingsProvider(injector.getInstance(KeyStrokesProvider.class));
    listenerChannel.registerListener(this);
    guiFactory = injector.getInstance(IGuiFactory.class);
    keyboard = injector.getInstance(Keyboard.class);
    ColorUtils.color = new Color(Integer.valueOf(config.getColordatas().split(":")[0]), Integer.valueOf(config.getColordatas().split(":")[1]), Integer.valueOf(config.getColordatas().split(":")[2]));
    gui = injector.getInstance(ItemInventoryGui.class);
    centredPosX = config.getX();
    centredPosY = config.getY();
  }

  @EventHandler
  public void onTick(GameTickEvent e){
    if(config.getModus() == 0){
      ColorUtils.setColor(0, 0, 0, true);
    }
    if(config.getModus() == 1){
      ColorUtils.setColor(255, 255, 255, false);
    }
    if(config.getModus() == 2){
      ColorUtils.setColor(255, 0, 0, false);
    }
    if(config.getModus() == 3){
      ColorUtils.setColor(52, 152, 219, false);
    }
    if(config.getModus() == 4){
      ColorUtils.setColor(0, 0, 255, false);
    }
    if(config.getModus() == 5){
      ColorUtils.setColor(243, 104, 224, false);
    }
    if(config.getModus() == 6){
      ColorUtils.setColor(46, 204, 113, false);
    }
    if(config.key != null && !MysteryMod.getInstance().getMinecraft().isGuiOpened()) {
      if (keyboard.isKeyDown(config.key.getValue())) {
        guiFactory.displayGui(GuiChangePosition.class);
      }
    }
  }

}
