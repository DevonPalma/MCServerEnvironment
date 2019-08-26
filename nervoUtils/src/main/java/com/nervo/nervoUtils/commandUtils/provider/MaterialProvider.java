package com.nervo.nervoUtils.commandUtils.provider;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;

import com.nervo.nervoUtils.commandUtils.types.MaterialFilter;


public class MaterialProvider extends CustomAbstactProvider<Material> {

	public MaterialProvider() {
		super(Material.class);
	}

	@Override
	public String asString(Material object, List<? extends Annotation> mods) {
		return object.name();
	}


	@Override
	public List<Material> getSource(List<? extends Annotation> mods) {
		List<Material> source = Arrays.asList(Material.values());
		
		if (hasDamagableFilter(mods)) {
			List<Material> filteredSource = new ArrayList<Material>();
			for (Material material : source) {
				if (material.getMaxDurability() > 0) {
					filteredSource.add(material);
				}
			}
			return filteredSource;
		}
		return source;
	}
	
	private boolean hasDamagableFilter(List<? extends Annotation> mods) {
		MaterialFilter filter = findAnnotation(mods, MaterialFilter.class);
		return (filter != null && filter.damegable());
	}
	
}
