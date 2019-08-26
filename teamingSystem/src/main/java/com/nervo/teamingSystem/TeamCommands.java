package com.nervo.teamingSystem;

import org.bukkit.entity.Player;

import app.ashcon.intake.Command;
import app.ashcon.intake.bukkit.parametric.annotation.Sender;

public class TeamCommands {
	
	@Command(aliases = { "create" }, desc = "creates a team with specified name")
	public void createTeam(@Sender Player sender, String teamName) {
		
	}
	
	@Command(aliases = {"invite", "inv" }, desc = "Invite a member to a team")
	public void inviteMember(@Sender Player sender, Player player) {
		
	}
}
