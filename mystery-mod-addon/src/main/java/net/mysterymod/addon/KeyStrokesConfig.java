package net.mysterymod.addon;

import com.google.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import net.mysterymod.api.minecraft.KeyCode;
import net.mysterymod.mod.config.GsonConfig;

import java.awt.*;
import java.io.File;
import java.util.function.Consumer;

@Setter
@Getter
@Singleton
public class KeyStrokesConfig extends GsonConfig {

  public boolean enabled;
  public boolean space;
  public int modus;
  public String colordatas;
  public Color color;
  public KeyCode key;
  public int x;
  public int y;

  public KeyStrokesConfig() {
    super(new File("MysteryMod/keystrokes.json"));
    this.initialize();
  }
}
