package me.sanhak.ar.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sanhak.ar.configuration.Configuration;

public class ReloadCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�cThis command only for players , you can't perform this command from console !");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("fr.admin")) {
			if (args.length != 0) {
				player.sendMessage("�cWrong use , please try to type /frreload");
				return false;
			} else {
				Configuration.reload();
				player.sendMessage("�aYou have been reloaded the configuration file successfully !");
				player.playSound(player.getLocation(), Sound.ORB_PICKUP, 0.5f, 5.0f);
			}
		} else {
			player.sendMessage("�cYou don't have enough permissions to perform this command !");
			player.playSound(player.getLocation(), Sound.ITEM_BREAK, 0.5f, 5.0f);
		}
		return false;
	}

}
