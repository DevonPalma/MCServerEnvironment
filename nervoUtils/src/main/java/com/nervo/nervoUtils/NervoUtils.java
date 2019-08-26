package com.nervo.nervoUtils;

import org.bukkit.plugin.java.JavaPlugin;

import app.ashcon.intake.bukkit.BukkitIntake;
import app.ashcon.intake.bukkit.graph.BasicBukkitCommandGraph;
import app.ashcon.intake.fluent.DispatcherNode;
import lombok.Getter;

public class NervoUtils extends JavaPlugin {
	
	@Getter private static NervoUtils instance;
	
	@Override
	public void onEnable() {
		instance = this;
		generateCommands();
	}
	
	public void generateCommands() {
		BasicBukkitCommandGraph cmdGraph = new BasicBukkitCommandGraph();
		DispatcherNode testNode = cmdGraph.getRootDispatcherNode().registerNode("test");
		testNode.registerCommands(new SimpleCommand());
		
		BukkitIntake intake = new BukkitIntake(this, cmdGraph);
		intake.register();
	}
}
