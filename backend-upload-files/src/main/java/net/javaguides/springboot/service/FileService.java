package net.javaguides.springboot.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.model.InformationFile;
import net.javaguides.springboot.repository.InformationFileRepository;

/**
 * @author CongLV
 *
 */

@Service
public class FileService {
	
	@Autowired
	private InformationFileRepository informationFileRepository;
	
	public InformationFile store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		InformationFile InformationFile = new InformationFile(fileName, file.getContentType(), file.getBytes());
		return informationFileRepository.save(InformationFile);
	}
	
	public InformationFile getFile(Long id) {
		return informationFileRepository.findById(id).get();
	}
	
	public Stream<InformationFile> getAllFiles(){
		return informationFileRepository.findAll().stream();
	}

}
