package ca.corykruger.magic.magic_wantlist.mtgjson;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileFetcher {
	public static final String SET_CODES = "SetCodes";
	
	private final String LOCAL_DIR = "C:\\Users\\Admin\\Desktop\\Wantlist\\";
	private final String MTG_JSON = "https://mtgjson.com/json/";
	private final String CONFLUX = "CON";
	
	public void fetch(String file) throws MalformedURLException, IOException {
		if (CONFLUX.equals(file)) {
			file += "_";
		}
		FileUtils.copyURLToFile(new URL(MTG_JSON + file + ".json"), new File(LOCAL_DIR + file + ".json"));
	}

}
