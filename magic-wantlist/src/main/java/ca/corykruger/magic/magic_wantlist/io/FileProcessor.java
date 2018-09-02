package ca.corykruger.magic.magic_wantlist.io;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_wantlist.wantlist.Card;
import ca.corykruger.magic.magic_wantlist.wantlist.Set;
import ca.corykruger.magic.magic_wantlist.wantlist.Wantlist;

public class FileProcessor {
	public static final String SET_CODES = "SetCodes";
	
	private final String LOCAL_DIR = "C:\\Users\\Admin\\Desktop\\Wantlist\\";
	private final String MTG_JSON = "https://mtgjson.com/json/";
	private final String CONFLUX = "CON";
	
	public void fetch(String fileName, boolean overwrite) throws MalformedURLException, IOException {
		fileName = processSpecialCases(fileName);
		File file = new File(LOCAL_DIR + fileName + ".json");
		if (!(file.exists() && !overwrite)) {
			FileUtils.copyURLToFile(new URL(MTG_JSON + fileName + ".json"), file);
		}
	}
	
	public String load(String file) throws IOException {
		file = processSpecialCases(file);
		return FileUtils.readFileToString(new File(LOCAL_DIR + file + ".json"));
	}
	
	void save(String fileName, String content) throws IOException {
		fileName = processSpecialCases(fileName);
		FileUtils.writeStringToFile(new File(LOCAL_DIR + fileName), content);
	}
	
	public void saveWantlist(Wantlist wantlist) throws IOException {
		String json = new Gson().toJson(wantlist);
		save("wantlist.json", json);
	}
	
	public void exportWantlist(Wantlist wantlist) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.CANADA).withZone(ZoneId.of("America/Toronto"));
		String start = "<html><head><title>Magic:  The Gathering Card Wantlist</title></head><body>";
		String date = "<div><p>Last Updated:  " + formatter.format(wantlist.getUpdated()) + "</p></div><br />";
		String content = "<div><ul>";
		for (Set set : wantlist.getWantedCards()) {
			content += "<li>" + set.getName() + "<ul>";
			for (Card card : set.getCards()) {
				content += "<li>" + card.toString() + "</li>";
			}
			content += "</ul></li>";
		}
		content += "</ul></div>";
		String end = "</body></html>";
		save("wantlist.html", start + date + content + end);
	}
	
	String processSpecialCases(String file) {
		if (StringUtils.startsWith(file, CONFLUX)) {
			return StringUtils.replace(file, CONFLUX, CONFLUX + "_");
		}
		return file;
	}
	
}
