package ca.corykruger.magic.magic_wantlist.mtgjson;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.corykruger.magic.magic_wantlist.io.FileProcessor;

public class SetsUpdater {

	public void updateSetCodes() throws IOException {
		System.out.println("Update Sets button was pressed");
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.fetch(FileProcessor.SET_CODES, true);
		String setCodesFile = fileProcessor.load(FileProcessor.SET_CODES);
		List<String> setCodes = new Gson().fromJson(setCodesFile, new TypeToken<List<String>>() {}.getType());
		for (String setCode : setCodes) {
			fileProcessor.fetch(setCode, false);
		}
		System.out.println("Set Update Complete");
	}
	
	public void updateSetList() throws IOException {
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.fetch("SetList", true);
	}
}
