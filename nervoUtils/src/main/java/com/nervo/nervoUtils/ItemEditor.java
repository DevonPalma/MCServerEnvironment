package com.nervo.nervoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.google.common.collect.Multimap;

public class ItemEditor {
	private ItemStack item;
	private ItemMeta itemMeta;
	
	public ItemEditor(ItemStack item) {
		this.item = item;
		this.itemMeta = item.getItemMeta();
	}
	
	public ItemEditor(Material item) {
		this(new ItemStack(item));
	}
	
	
	
	public ItemEditor setMaterial(Material material) {
		item.setType(material);
		return this;
	}
	
	public Material getMaterial() {
		return item.getType();
	}
	
	
	
	public ItemEditor setAmount(Short amount) {
		item.setAmount(amount);
		return this;
	}
	
	public int getAmount() {
		return item.getAmount();
	}
	
	
	
	public ItemEditor setName(String name) {
		itemMeta.setDisplayName(name.replaceAll("&", "§"));
		return this;
	}
	
	public String getName() {
		if (itemMeta == null)
			return null;
		return itemMeta.getDisplayName().replaceAll("§", "&");
	}
	
	
	
	public ItemEditor setLore(String...strings) {
		List<String> lore = new ArrayList<String>();
		for (int i = 0; i < strings.length; i++) {
			lore.add(strings[i].replaceAll("&", "§"));
		}
		itemMeta.setLore(lore);
		return this;
	}
	
	public List<String> getLore() {
		if (itemMeta == null)
			return null;
		return itemMeta.getLore();
	}
	
	
	
	public ItemEditor setUnbreakable(boolean unbreakable) {
		itemMeta.setUnbreakable(unbreakable);
		return this;
	}
	
	public boolean isUnbreakable() {
		if (itemMeta == null)
			return false;
		return itemMeta.isUnbreakable();
	}
	
	
	
	public ItemEditor addAttribute(Attribute attribute, String name, double amount, Operation operation) {
		itemMeta.addAttributeModifier(attribute, new AttributeModifier(name, amount, operation));
		return this;
	}
	
	public ItemEditor removeAttribute(Attribute attribute) {
		itemMeta.removeAttributeModifier(attribute);
		return this;
	}
	
	public ItemEditor removeAttribute(Attribute attribute, AttributeModifier modifier) {
		itemMeta.removeAttributeModifier(attribute, modifier);
		return this;
	}
	
	public boolean hasAttribute() {
		if (itemMeta == null)
			return false;
		return itemMeta.hasAttributeModifiers();
	}
	
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers() {
		if (itemMeta == null)
			return null;
		return itemMeta.getAttributeModifiers();
	}
	
	
	
	public ItemEditor addEnchant(Enchantment enchantment, int level) {
		itemMeta.addEnchant(enchantment, level, true);
		return this;
	}
	
	public ItemEditor addEnchants(Enchantment...enchantments) {
		if (enchantments != null && enchantments.length > 0)
			for (Enchantment e : enchantments) 
				if (e != null)
				addEnchant(e, e.getMaxLevel());
		return this;
	}
	
	public ItemEditor removeEnchant(Enchantment enchantment) {
		itemMeta.removeEnchant(enchantment);
		return this;
	}
	
	public Map<Enchantment, Integer> getEnchants() {
		return itemMeta.getEnchants();
	}
	
	
	
	
	public ItemEditor addFlag(ItemFlag...flags) {
		itemMeta.addItemFlags(flags);
		return this;
	}
	
	public ItemEditor removeFlag(ItemFlag...flags) {
		itemMeta.removeItemFlags(flags);
		return this;
	}
	
	public Set<ItemFlag> getFlags() {
		return itemMeta.getItemFlags();
	}
	
	
	public ItemStack getItem() {
		item.setItemMeta(itemMeta);
		return item;
	}
	
	
	
	
	public ItemEditor setPotionColor(Color color) {
		PotionMeta potionMeta = (PotionMeta) itemMeta;
		potionMeta.setColor(color);
		return this;
	}
	
	public ItemEditor addPotionEffect(PotionEffectType type, int duration, int amplifier) {
		PotionMeta potionMeta = (PotionMeta) itemMeta;
		potionMeta.addCustomEffect(new PotionEffect(type, duration, amplifier, false, false, false), true);
		return this;
	}
	
	public ItemEditor removePotionEffect(PotionEffectType type) {
		PotionMeta potionMeta = (PotionMeta) itemMeta;
		potionMeta.removeCustomEffect(type);
		return this;
	}
	
	public List<PotionEffect> getPotionEffects() {
		PotionMeta potionMeta = (PotionMeta) itemMeta;
		return potionMeta.getCustomEffects();
	}
}
