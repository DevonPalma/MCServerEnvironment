package com.nervo.nervoUtils.commandUtils.provider;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import app.ashcon.intake.argument.ArgumentException;
import app.ashcon.intake.argument.CommandArgs;
import app.ashcon.intake.argument.Namespace;
import app.ashcon.intake.bukkit.parametric.provider.BukkitProvider;
import app.ashcon.intake.parametric.ProvisionException;

public abstract class CustomAbstactProvider<T> implements BukkitProvider<T> {
	private Class<T> clazz;
	
	public CustomAbstactProvider(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public String getName() {
		return clazz.getSimpleName().toLowerCase();
	}
	
	@Override
	public T get(CommandSender sender, CommandArgs args, List<? extends Annotation> mods)
			throws ArgumentException, ProvisionException {
		String query = null;
		if (args.hasNext()) {
			query = args.next();
			T option = read(query, mods);
			if (option != null)
				return option;
		}
		if (query != null)
			throw new ArgumentException("Could not find " + getName() + " named '" + query +"'");
		else
			throw new ArgumentException("You must provide a " + getName() + " name");
	}
	
	@Override
	public T get(CommandArgs args, List<? extends Annotation> mods)
			throws ArgumentException, ProvisionException {
		String query = null;
		if (args.hasNext()) {
			query = args.next();
			T option = read(query, mods);
			if (option != null)
				return option;
		}
		if (query != null)
			throw new ArgumentException("Could not find " + getName() + " named '" + query +"'");
		else
			throw new ArgumentException("You must provide a " + getName() + " name");
	}
	
	@Override
	public List<String> getSuggestions(String prefix, CommandSender sender, Namespace namespace,
			List<? extends Annotation> mods) {
		prefix = prefix.toLowerCase();
		List<String> suggestions = new ArrayList<String>();
		for (T e : getSource(mods)) {
			String name = asString(e, mods).toLowerCase();
			if (name.startsWith(prefix))
				suggestions.add(name);
		}
		return suggestions;
	}
	
	public T read(String query, List<? extends Annotation> mods) {
		query = query.toLowerCase();
		List<T> possibleOptions = new ArrayList<T>();
		for (T object : getSource(mods)) {
			String name = asString(object, mods).toLowerCase();
			if (name.equals(query))
				return object;
			else if (name.startsWith(query))
				possibleOptions.add(object);
		}
		if (possibleOptions.size() != 1)
			throw new IllegalArgumentException("Unknown option");
		return possibleOptions.get(0);
	}
	
	public abstract String asString(T object, List<? extends Annotation> mods);
	
	public abstract List<T> getSource(List<? extends Annotation> mods);
	
	public <T extends Annotation> T findAnnotation(List<? extends Annotation> mods, Class<T> annotation) {
		for (Annotation a : mods) {
			if (a.annotationType().getName().equals(annotation.getName()))
				return (T) a;
		}
		return null;
	}

}
