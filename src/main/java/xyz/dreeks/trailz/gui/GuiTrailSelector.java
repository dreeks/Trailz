package xyz.dreeks.trailz.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.dreeks.trailz.network.PacketUploadTrails;
import xyz.dreeks.trailz.network.TrailzNetwork;
import xyz.dreeks.trailz.utils.Constants;

@SideOnly(Side.CLIENT)
public class GuiTrailSelector extends GuiScreen {

    public static final int WIDTH  = 200;
    public static final int HEIGHT = 166;

    private int topX, topY;
    private static final ResourceLocation background = new ResourceLocation(Constants.MOD_ID, "textures/gui/select_trail.png");

    public void initGui() {
        this.topX = (this.width/2) - (WIDTH/2);
        this.topY = (this.height/2) - (HEIGHT/2);

        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, (this.topX + WIDTH) - 25, this.topY + 5, 20, 20, "X"));
        this.buttonList.add(new GuiButton(1, this.topX + 5, this.topY + HEIGHT - 25, WIDTH - 10, 20, "Set the trail"));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        switch(button.id) {
            case 0:
                this.mc.displayGuiScreen(null);
                break;

            case 1:
                TrailzNetwork.INSTANCE.sendToServer(new PacketUploadTrails(Constants.TRAILS.get(0)));
                this.mc.displayGuiScreen(null);
                break;
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(this.topX, this.topY, 0, 0, WIDTH, HEIGHT);
        this.drawCenteredString(this.fontRenderer, "Trail selector", this.width / 2, this.topY + 10, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

}