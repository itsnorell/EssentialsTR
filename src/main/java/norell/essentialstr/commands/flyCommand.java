package norell.essentialstr.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class flyCommand extends Command {

    public FlyCommand() {
        super(
                "fly",
                "uçuş komutu"
        );
        setPermission(Manager.FEED_PERMISSION);
        setPermissionMessage("§8» §cBu komudu kullanmak için §4§lVIP §r§colman gerekiyor!");
        commandParameters.clear();
        commandParameters.put("default", new CommandParameter[] {
                CommandParameter.newType("player", true, CommandParamType.TARGET)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        if (!testPermission(sender) || sender.getServer().isOp(sender.getName())) {
            sender.sendMessage(this.getPermissionMessage());
            return false;
        }
        if (args.length > 0) {
            String argsPlayer = args[0];
            Player target = player.getServer().getPlayer(argsPlayer);
            if (target == null) {
                player.sendMessage("§c" + argsPlayer + " adlı oyuncu bulunamadı.");
                return false;
            }
            if (target.getAllowFlight()) {
                target.setAllowFlight(false);
                target.sendMessage("§8» §7Uçuş modu §6" + player.getName() + " §7Tarafından §ckapatıldı.");
                player.sendMessage("§8» §6" + argsPlayer + "§7 oyuncusunun uçuş modu §ckapatıldı.");
            } else {
                target.setAllowFlight(true);
                target.sendMessage("§8» §7Uçuş modu §6" + player.getName() + " §7Tarafından §aaçıldı.");
                player.sendMessage("§8» §6" + argsPlayer + "§7 oyuncusunun uçuş modu §aaçıldı.");
            }
        } else {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage("§8» §7Uçuş modu §ckapatıldı.");
            } else {
                player.setAllowFlight(true);
                player.sendMessage("§8» §7Uçuş modu §aaçıldı.");
            }
        }

        return true;
    }
}
