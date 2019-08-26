package com.nervo.nervoUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Replacer {
	
	public static ItemStack itemReplacer(ItemStack item, String...values) {
		return itemReplacer(item, generate(values));
	}
	
	public static ItemStack itemReplacer(ItemStack item, Map<String, String> replaceValues) {
		ItemStack outputItem = item.clone();
		ItemMeta itemMeta = outputItem.getItemMeta();
		itemMeta.setDisplayName(stringReplacer(itemMeta.getDisplayName(), replaceValues));
		List<String> lore = new ArrayList<String>();
		for (String s : itemMeta.getLore())
			lore.add(stringReplacer(s, replaceValues));
		itemMeta.setLore(lore);
		outputItem.setItemMeta(itemMeta);
		return outputItem;
	}
	
	public static String stringReplacer(String input, String...values) {
		return stringReplacer(input, generate(values));
	}
	
	public static String stringReplacer(String input, Map<String, String> replaceValues) {
		String output = input;
		for (Entry<String, String> e : replaceValues.entrySet()) {
			output = output.replaceAll(e.getKey(), e.getValue());
		}
		return output;
	}
	
	public static Map<String, String> generate(String...strings) {
		if (strings.length%2 != 0)
			throw new IllegalArgumentException("Must enter an even number of fields");
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < strings.length/2; i++) {
			map.put(strings[i*2], strings[i*2+1]);
		}
		return map;
	}
}
