package norell.essentialstr.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class feedCommand extends Command {

    public feedCommand() {
        super("feed", "Açlığınızı  fuller.");
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
            target.getFoodData().setFood(20);
            target.sendMessage("§aBaşarıyla açlık barınız sıfırlandı.");
            target.sendMessage("§aaçlık barınız §6" + player.getName() + " §aTarafından sıfırlandı.");
            player.sendMessage("§a" + argsPlayer + " oyuncusunun açlık barı sıfırlandı.");
        } else {
            player.getFoodData().setFood(20);
            player.sendMessage("§aBaşarıyla açlık barınız sıfırlandı.");
        }

        return true;
    }
}
