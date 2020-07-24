package com.wyc.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public interface HandleUpload {
	/**
	 * 上传文件
	 * 
	 * @param file 文件对象
	 * @return 文件访问地址
	 * @throws IOException
	 */
	String uploadFile(MultipartFile file) throws IOException;

	/**
	 * 将一段字符串生成一个文件上传
	 * 
	 * @param content       文件内容
	 * @param fileExtension
	 * @return
	 */
	String uploadFile(String content, String fileExtension);

	/**
	 * 删除文件
	 * 
	 * @param fileUrl 文件访问地址
	 * @return
	 */
	void deleteFile(String fileUrl);
	String uploadFile(ByteArrayOutputStream byteArrayOutputStream, String fileExtension);
}
