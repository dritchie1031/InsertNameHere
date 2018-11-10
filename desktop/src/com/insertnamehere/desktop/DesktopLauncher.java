package com.insertnamehere.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.insertnamehere.INHCore;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "<Insert Name Here>";
		config.width = 640;
		config.height = 320;
		new LwjglApplication(new INHCore(), config);
	}
}
