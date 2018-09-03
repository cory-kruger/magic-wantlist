package ca.corykruger.magic.magic_wantlist.mtgjson;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.corykruger.magic.magic_wantlist.io.FileProcessor;

public class SetsUpdater {
	
	private FileProcessor fileProcessor;
	private Gson gson;
	
	public SetsUpdater() {
		fileProcessor = new FileProcessor();
		gson = new Gson();
	}
	
	public SetsUpdater(FileProcessor fileProcessor, Gson gson) {
		this.fileProcessor = fileProcessor;
		this.gson = gson;
	}

	public void updateSetCodes() throws IOException {
		// TODO:  Add loading indicator
		fileProcessor.fetch(FileProcessor.SET_CODES, FileProcessor.JSON, true);
		String setCodesFile = fileProcessor.load(FileProcessor.SET_CODES, FileProcessor.JSON);
		List<String> setCodes = gson.fromJson(setCodesFile, new TypeToken<List<String>>() {}.getType());
		for (String setCode : setCodes) {
			fileProcessor.fetch(setCode, FileProcessor.JSON, false);
		}
	}
	
	public void updateSetList() throws IOException {
		fileProcessor.fetch(FileProcessor.SET_LIST, FileProcessor.JSON, true);
	}
}
