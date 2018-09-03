package ca.corykruger.magic.magic_wantlist.io;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;

public class WantlistExporter {
	
	public void export() throws IOException {
		FileProcessor fileProcessor = new FileProcessor();
		Gson gson = new Gson();
		// TODO:  Exception if file !exists
		Wantlist wantlist;
		try {
			wantlist = gson.fromJson(fileProcessor.load("wantlist"), Wantlist.class);
		} catch (FileNotFoundException fnfe) {
			wantlist = new Wantlist();
			fileProcessor.save("wantlist.json", gson.toJson(wantlist));
		}
		fileProcessor.exportWantlist(wantlist);
	}
	
}
