package net.mysterymod.addon.version_specific;

import net.minecraft.client.Minecraft;
import net.mysterymod.addon.MysteryModAddon;
import net.mysterymod.api.minecraft.KeyCode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

  @Inject(method = "runTick", at = @At(value = "HEAD"))
  public void checkKeyboard(CallbackInfo callbackInfo) {
    if(Minecraft.getInstance().player != null && Minecraft.getInstance().isGameFocused()) {
      if (MysteryModAddon.keyboard.isKeyDown(KeyCode.KEY_W.getValue())) {
        MysteryModAddon.wPressed = true;
      } else {
        MysteryModAddon.wPressed = false;
      }
      if (MysteryModAddon.keyboard.isKeyDown(KeyCode.KEY_A.getValue())) {
        MysteryModAddon.aPressed = true;
      } else {
        MysteryModAddon.aPressed = false;
      }
      if (MysteryModAddon.keyboard.isKeyDown(KeyCode.KEY_S.getValue())) {
        MysteryModAddon.sPressed = true;
      } else {
        MysteryModAddon.sPressed = false;
      }
      if (MysteryModAddon.keyboard.isKeyDown(KeyCode.KEY_D.getValue())) {
        MysteryModAddon.dPressed = true;
      } else {
        MysteryModAddon.dPressed = false;
      }
      if (MysteryModAddon.keyboard.isKeyDown(KeyCode.KEY_SPACE.getValue())) {
        MysteryModAddon.spacePressed = true;
      } else {
        MysteryModAddon.spacePressed = false;
      }
    }
  }
}
