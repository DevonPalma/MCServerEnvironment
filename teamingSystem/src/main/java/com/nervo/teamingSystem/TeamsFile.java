package com.nervo.teamingSystem;

import org.bukkit.plugin.java.JavaPlugin;

import com.nervo.nervoUtils.file.AbstractFile;

public class TeamsFile extends AbstractFile {

	public TeamsFile(JavaPlugin plugin) {
		super(plugin, "Teams");
	}

	@Override
	public void createDefaults() {
		
	}
	
}
