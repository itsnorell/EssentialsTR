package norell.essentialstr.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class healCommand extends Command {

    public healCommand() {
        super("heal", "Canınızı fuller.");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.isOp()) {
            player.sendMessage("§7Bu komutu kullanabilmek için §6VIP §7izniniz olmalıdır.");
            return false;
        }
        if (args.length > 0) {
            String argsPlayer = args[0];
            Player target = player.getServer().getPlayer(argsPlayer);
            if (target == null) {
                player.sendMessage("§c" + argsPlayer + " adlı oyuncu bulunamadı.");
                return false;
            }
            target.heal(player.getMaxHealth() - player.getHealth());
            target.sendMessage("§aBaşarıyla can barınız sıfırlandı.");
            target.sendMessage("§aCan barınız §6" + player.getName() + " §aTarafından sıfırlandı.");
            player.sendMessage("§a" + argsPlayer + " oyuncusunun can barı sıfırlandı.");
        } else {
            player.heal(player.getMaxHealth() - player.getHealth());
            player.sendMessage("§aBaşarıyla can barınız sıfırlandı.");
        }

        return true;
    }
}
