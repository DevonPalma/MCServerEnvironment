package com.nervo.nervoUtils.file;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public abstract class AbstractFile {
	private JavaPlugin plugin;
	protected File file;
	@Getter protected FileConfiguration config;

	private String fileName;
	
	public AbstractFile(JavaPlugin plugin, String fileName) {
		if (!fileName.endsWith(".yml"))
			fileName += ".yml";
		this.fileName = fileName;
		this.plugin = plugin;
		load();
	}
	
	public ConfigurationSection getSection(String label) {
		if (config.contains(label))
			return config.getConfigurationSection(label);
		else
			return config.createSection(label);
	}
	
	public void load() {
		file = new File(plugin.getDataFolder(), fileName);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			plugin.saveResource(fileName, false);
		}
		config = new YamlConfiguration();
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		createDefaults();
		save();
	}

	public abstract void createDefaults();

	public void reload() {
		load();
	}
	
	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void smartSet(ConfigurationSection section, String path, boolean override, Object value, Object defaultValue) {
		if (!section.isSet(path)) {
			if (value == null)
				section.set(path, defaultValue);
			else
				section.set(path, value);
		} else if (override) {
			if (value != null)
				section.set(path, value);
		}
	}
}
