package ca.corykruger.magic.magic_wantlist.mtgjson;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SetCode {
	
	private String code;
	
	public SetCode(String code) {
		this.code = code;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (obj instanceof SetCode) {
			SetCode aSetCode = (SetCode) obj;
			if (StringUtils.equals(code, aSetCode.getCode())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(83, 241)
				.append(code)
				.toHashCode();
	}
	
	@Override
	public String toString() {
		return code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

}
