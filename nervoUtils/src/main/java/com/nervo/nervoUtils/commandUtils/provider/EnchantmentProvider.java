package com.nervo.nervoUtils.commandUtils.provider;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import org.bukkit.enchantments.Enchantment;

public class EnchantmentProvider extends CustomAbstactProvider<Enchantment> {

	public EnchantmentProvider() {
		super(Enchantment.class);
	}

	@Override
	public String asString(Enchantment object, List<? extends Annotation> mods) {
		return object.getKey().getKey();
	}

	@Override
	public List<Enchantment> getSource(List<? extends Annotation> mods) {
		return Arrays.asList(Enchantment.values());
	}
	
	
}
