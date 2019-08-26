package com.nervo.teamingSystem.teamComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

public class TeamGroup {
	@Getter private List<String> permissions;
	@Getter private List<UUID> users;
	
	public TeamGroup() {
		permissions = new ArrayList<String>();
		users = new ArrayList<UUID>();
	}
	
	public void addPermission(String permission) {
		getPermissions().add(permission);
	}
	
	public void addUser(UUID user) {
		getUsers().add(user);
	}
	
	public void removePermission(String permission) {
		
	}
}
