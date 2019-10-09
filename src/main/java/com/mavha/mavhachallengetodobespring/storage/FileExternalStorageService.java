package com.mavha.mavhachallengetodobespring.storage;

import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Profile("prod")
@Component
public class FileExternalStorageService implements StorageService {

	@Override
	public String storeFile(MultipartFile file) {
		// TODO implement this method
		return null;
	}

	@Override
	public Resource loadFileAsResource(String filename) {
		// TODO implement this method
		return null;
	}

}
