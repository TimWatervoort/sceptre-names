package com.sceptrenames;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SceptreNamesPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SceptreNamesPlugin.class);
		RuneLite.main(args);
	}
}