package com.test.corent.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.corent.message.ResponseFile;
import com.test.corent.message.ResponseMessage;
import com.test.corent.model.FileDB;
import com.test.corent.service.FileStorageService;

@Controller
@CrossOrigin("*")
@RequestMapping("MaaSRestAPI/FileServer/api")
public class FileController {

@Autowired
private FileStorageService storageService;

@PostMapping("/upload")
public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
{
String message = "";
try 
{
storageService.store(file);
message = "Uploaded the file successfully: " + file.getOriginalFilename();
return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
} 
catch (Exception e)
{
message = "Could not upload the file: " + file.getOriginalFilename() + "!";
return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
}
}

@GetMapping("/files")
public ResponseEntity<List<ResponseFile>> getListFiles() {
List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
String fileDownloadUri = ServletUriComponentsBuilder
.fromCurrentContextPath()
.path("MaaSRestAPI/FileServer/api/files/")
.path(dbFile.getId())
.toUriString();

return new ResponseFile(
dbFile.getFileName(),
fileDownloadUri,
dbFile.getFileType(),
dbFile.getData().length);
}).collect(Collectors.toList());

return ResponseEntity.status(HttpStatus.OK).body(files);
}

@GetMapping("/files/{id}")
public ResponseEntity<byte[]> getFile(@PathVariable String id) {
FileDB fileDB = storageService.getFile(id);
System.out.println("The Value of ID is "+id);
return ResponseEntity.ok()
.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileName() + "\"")
.body(fileDB.getData());
}
}
