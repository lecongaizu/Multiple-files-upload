package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.message.ResponseFile;
import net.javaguides.springboot.message.ResponseMessage;
import net.javaguides.springboot.model.InformationFile;
import net.javaguides.springboot.repository.InformationFileRepository;
import net.javaguides.springboot.service.FileService;
/**
 * @author CongLV
 *
 */
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/")
public class FileController {
	
	@Autowired
	private FileService storageService;
	
	@Autowired
	private InformationFileRepository informationFileRepository;
	
	// Post for upload file
	@PostMapping("/files")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.store(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			// TODO: handle exception
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	// Get list files
	@GetMapping("/files")
	public List<InformationFile> getListFiles() {
		return informationFileRepository.findAll();
	}
	
	// Get file by id
	@GetMapping("/files/{id}")
	public ResponseEntity <InformationFile> getEmployeeById(@PathVariable Long id) {
		InformationFile informationFile = informationFileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("File not exist with id:" + id) );
		return ResponseEntity.ok(informationFile);
	}
	 
	// Delete file in list by id
	 @DeleteMapping("/files/{id}")
	 public ResponseEntity<Map<String, Boolean>> deleteFiles(@PathVariable(value = "id") Long id) {
		 InformationFile informationFile = informationFileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("File not exist with id:" + id));
		  
		 informationFileRepository.delete(informationFile);
		 Map<String, Boolean> response = new HashMap<>();
		 response.put("deleted", Boolean.TRUE);
		 return ResponseEntity.ok(response);
	  }
	
}