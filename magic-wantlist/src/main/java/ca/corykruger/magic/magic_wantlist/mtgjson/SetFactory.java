package ca.corykruger.magic.magic_wantlist.mtgjson;

import java.io.IOException;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.io.FileProcessor;
import ca.corykruger.magic.magic_wantlist.wantlist.Card;
import ca.corykruger.magic.magic_wantlist.wantlist.Set;

public class SetFactory {

	public Set getSet(String setCode) throws IOException {
		FileProcessor fileProcessor = new FileProcessor();
		Gson gson = new Gson();
		String setFile = fileProcessor.load(setCode);
		Set set = gson.fromJson(setFile, Set.class);
		for (Card card : set.getCards()) {
			card.setSet(setCode);
		}
		return set;
	}
}
