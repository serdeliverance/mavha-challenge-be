package com.mavha.mavhachallengetodobespring.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	/**
	 * Stores a file
	 * 
	 * @param file
	 * @return the fileName of the stored file
	 */
	String storeFile(MultipartFile file);

	Resource loadFileAsResource(String filename);
}
