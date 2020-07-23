package mod.azure.doomweapon.util;

import java.io.File;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import mod.azure.doomweapon.DoomMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class Config {

	public static final ServerConfig SERVER;
	public static final ForgeConfigSpec SERVER_SPEC;

	static {
		final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
		SERVER_SPEC = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	public static class ServerConfig {
		public final BooleanValue NETHER_SPAWN;
		public final BooleanValue END_SPAWN;

		ServerConfig(ForgeConfigSpec.Builder builder) {
			builder.push("spawn");
			NETHER_SPAWN = builder.comment("Do you want to Spawn in the Nether?")
					.translation(DoomMod.MODID + ".config.nether_spawn").define("NETHER_SPAWN", false);
			END_SPAWN = builder.comment("Do you want to Spawn in the End?")
					.translation(DoomMod.MODID + ".config.end_spawn").define("END_SPAWN", false);
			builder.pop();
		}
	}

	public static void loadConfig(ForgeConfigSpec config, String path) {
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave()
				.writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
}