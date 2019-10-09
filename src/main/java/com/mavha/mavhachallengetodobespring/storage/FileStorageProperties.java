package com.mavha.mavhachallengetodobespring.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Profile({"dev", "default"})
@ConfigurationProperties(prefix = "file")
@Data
@NoArgsConstructor
public class FileStorageProperties {
    private String uploadDir;
}
