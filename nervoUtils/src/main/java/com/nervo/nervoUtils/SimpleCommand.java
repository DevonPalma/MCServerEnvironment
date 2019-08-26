package com.nervo.nervoUtils;

import org.bukkit.command.CommandSender;

import app.ashcon.intake.Command;

public class SimpleCommand {

	@Command(
			aliases = "ping",
			desc = "Send a ping to the server"
			)
	public void ping(CommandSender sender) {
		sender.sendMessage("Pong!");
	}
	
}
