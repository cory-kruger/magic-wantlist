package ca.corykruger.magic.magic_wantlist.mtgjson;

public class JsonSet {
	
	private String name;
	private String code;
	private String releaseDate;
	
	public JsonSet(String name, String code, String releaseDate) {
		this.name = name;
		this.code = code;
		this.releaseDate = releaseDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
