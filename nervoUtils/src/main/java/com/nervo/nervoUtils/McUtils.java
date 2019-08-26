package com.nervo.nervoUtils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class McUtils {
	public static boolean isDamageable(Material material) {
		return material.getMaxDurability() > 0;
	}
	
	public static boolean isDamageable(ItemStack item) {
		return isDamageable(item.getType());
	}
}
