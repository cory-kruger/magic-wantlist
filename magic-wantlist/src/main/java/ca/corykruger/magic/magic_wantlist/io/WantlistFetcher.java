package ca.corykruger.magic.magic_wantlist.io;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;

public class WantlistFetcher {
	
	FileProcessor fileProcessor;
	Gson gson;
	
	public WantlistFetcher() {
		fileProcessor = new FileProcessor();
		gson = new Gson();
	}
	
	WantlistFetcher(FileProcessor fileProcessor, Gson gson) {
		this.fileProcessor = fileProcessor;
		this.gson = gson;
	}
	
	public Wantlist fetch() throws IOException {
		try {
			String fileContents = fileProcessor.load(FileProcessor.WANTLIST, FileProcessor.JSON);
			return gson.fromJson(fileContents, Wantlist.class);
		} catch (FileNotFoundException fnfe) {
			return new Wantlist();
		}
	}

}
