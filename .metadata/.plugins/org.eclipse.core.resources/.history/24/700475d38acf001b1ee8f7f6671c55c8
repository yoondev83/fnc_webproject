package com.webprj.project_green.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadResultDto {
	private String fileName;
	private String uuid;
	private String folderPath;
	
	public String getImageURL() {
		try {
			return URLEncoder.encode(folderPath + "/" + uuid + "_" + fileName, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "";
	}
}
