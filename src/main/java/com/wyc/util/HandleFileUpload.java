package com.wyc.util;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

import groovy.util.logging.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

@Import(FdfsClientConfig.class)
@Component

public class HandleFileUpload  implements HandleUpload{
	 @Autowired
	 private FastFileStorageClient storageClient;
	 // 封装图片完整URL地址
	 private String getResAccessUrl(StorePath storePath) {
	        String fileUrl =  storePath.getFullPath();
	        return fileUrl;
	 }

	 public  String uploadFile(MultipartFile file) throws IOException{
		  StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
	      return getResAccessUrl(storePath);
	 }
	
	 public  String uploadFile(String content, String fileExtension){
		byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
        return getResAccessUrl(storePath);
	 }
	
	 public  void deleteFile(String fileUrl){
		 if (StringUtils.isEmpty(fileUrl)) {
	            return;
	        }
	        try {
	            StorePath storePath = StorePath.parseFromUrl(fileUrl);
	            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
	        } catch (FdfsUnsupportStorePathException e) {

	        }
	 }

	/**
	 * @Description:上传图片并生成略缩图
	 * @date 2018年6月20日 下午1:50:21
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String uploadImageAndCrtThumbImage(MultipartFile file) throws IOException {
		StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
				FilenameUtils.getExtension(file.getOriginalFilename()), null);
		return getResAccessUrl(storePath);
	}

	@Override
	public String uploadFile(ByteArrayOutputStream byteArrayOutputStream, String fileExtension) {
		byte[] buff = byteArrayOutputStream.toByteArray();
		ByteArrayInputStream stream = new ByteArrayInputStream(buff);
		StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
		return getResAccessUrl(storePath);
	}
}
