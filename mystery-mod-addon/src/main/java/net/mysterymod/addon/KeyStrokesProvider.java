package net.mysterymod.addon;

import com.google.inject.Inject;
import net.mysterymod.api.gui.Gui;
import net.mysterymod.mod.addon.AddonSettingsProvider;
import net.mysterymod.mod.gui.settings.SettingsGui;
import net.mysterymod.mod.gui.settings.component.SettingsComponent;
import net.mysterymod.mod.gui.settings.component.SettingsComponentProvider;
import net.mysterymod.mod.gui.settings.component.color.SingleColorComponent;
import net.mysterymod.mod.gui.settings.component.input.KeybindComponent;
import net.mysterymod.mod.gui.settings.component.selection.SlimDropdownComponent;
import net.mysterymod.mod.gui.settings.component.toggle.ToggleComponent;

import java.awt.*;
import java.util.List;
import java.util.function.Consumer;

public class KeyStrokesProvider implements AddonSettingsProvider {

  private final KeyStrokesConfig config;

  @Inject
  public KeyStrokesProvider(KeyStrokesConfig config) {
    this.config = config;
  }

  @Override
  public void addSettings(
    SettingsGui settingsGui,
    SettingsComponentProvider settingsComponentProvider,
    List<SettingsComponent> components) {
      components.add(
        ToggleComponent.create(
          "Keystrokes aktivieren",
          null,
          toggleState -> {
            // Toggle listener
            config.setEnabled(toggleState);
            config.saveConfig();
          },
          config.isEnabled()
        ));
    components.add(
      ToggleComponent.create(
        "Leertaste anzeigen",
        null,
        toggleState -> {
          // Toggle listener
          config.setSpace(toggleState);
          config.saveConfig();
        },
        config.isSpace()
      ));
    String[] colorOptions = {"RGB", "§fWeiß", "§4Rot", "§9Türkis", "§1Blau", "§dPink", "§aLimette"};
    components.add(new SlimDropdownComponent("Farbe", null, colorOptions, config.getModus(),toggleState -> {
      // Toggle listener
      config.setModus(toggleState);
      config.saveConfig();
    }));
    components.add(new KeybindComponent("Position ändern", null,
      config.getKey(), keyCode -> {
      config.setKey(keyCode);
      config.saveConfig();
    }));
  }
}
