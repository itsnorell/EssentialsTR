package norell.essentialstr;
import cn.nukkit.plugin.PluginBase;
import norell.essentialstr.commands.*;

public class Main extends PluginBase {

    @Override
    public void onEnable() {
        this.getLogger().info("EssentialTR Aktif.");
        getServer().getCommandMap().register("feed", new feedCommand());
        getServer().getCommandMap().register("heal", new healCommand());
        getServer().getCommandMap().register("fly", new flyCommand());
    }
}