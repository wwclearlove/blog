package com.wyc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author LMS
 *  工具类
 */
/**
 * @author LMS
 *
 */

/**
 * @author LMS
 *
 */
@Service
public class AcceptUploadFile {

	private static final Logger log = LoggerFactory.getLogger(AcceptUploadFile.class);
	@Autowired
	private HandleUpload handleupload;

	public List<String> acceptFiles(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		String url = null;
		List<String> urlList = new ArrayList<String>();
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multipartRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile file = multipartRequest.getFile(iterator.next());
				try {
					if (!file.isEmpty()) {
						url = handleupload.uploadFile(file);
						log.info("上传文件：++++————————++++ {}", url);
						urlList.add(url);
					}

				} catch (IOException e) {
					e.printStackTrace();
					log.info("上传文件异常：++++————————++++ {}", url);
				}
			}
		}
		return urlList;
	}

	public Map<String, String> acceptImgAndVedio(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		String url = null;
		Map<String, String> urlList = new HashMap<String, String>();
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multipartRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile file = multipartRequest.getFile(iterator.next());
				try {
					if (!file.isEmpty()) {
						url = handleupload.uploadFile(file);
						log.info("上传文件：++++————————++++ {}", url);
						// if (file.getName().equals("video")) {
						urlList.put(file.getName(), url);
						// urlList.put("originalName", file.getOriginalFilename());
						// }
					}
				} catch (IOException e) {
					e.printStackTrace();
					log.info("上传文件异常：++++————————++++ {}", url);
				}
			}
		}
		return urlList;
	}

	public HashMap<String, String> acceptFilesForMobile(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		String url = null;
		HashMap<String, String> urlList = new HashMap<String, String>();
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multipartRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile file = multipartRequest.getFile(iterator.next());
				try {
					if (!file.isEmpty()) {
						url = handleupload.uploadFile(file);
						String fileName = file.getOriginalFilename();
						log.info("上传文件：++++————————++++ {}", url);
						urlList.put(url, fileName);
					}

				} catch (IOException e) {
					e.printStackTrace();
					log.info("上传文件异常：++++————————++++ {}", url);
				}
			}
		}
		return urlList;
	}

	public String acceptFiles(String content, String fileExtension) {
		return handleupload.uploadFile(content, fileExtension);
	}

	public String uploadFile(ByteArrayOutputStream byteArrayOutputStream, String fileExtension) {
		String url = null;
		url = handleupload.uploadFile(byteArrayOutputStream, fileExtension);
		return url;
	}

	public void deleteFile(String imgUrl) {
		handleupload.deleteFile(imgUrl);
	}
}
