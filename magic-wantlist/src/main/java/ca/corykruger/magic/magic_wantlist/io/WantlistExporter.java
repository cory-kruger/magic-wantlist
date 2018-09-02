package ca.corykruger.magic.magic_wantlist.io;

import java.io.IOException;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;

public class WantlistExporter {
	
	public void export() throws IOException {
		FileProcessor fileProcessor = new FileProcessor();
		Wantlist wantlist = new Gson().fromJson(fileProcessor.load("wantlist"), Wantlist.class);
		fileProcessor.exportWantlist(wantlist);
	}
	
}
