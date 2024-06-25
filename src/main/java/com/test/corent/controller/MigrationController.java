package com.test.corent.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("MaaSRestAPI/MigrationController/Taskapi")
public class MigrationController
{
@PostMapping("/downloadagent")
public void startAgentInstallation()
{
String CMD="powershell.exe  Invoke-WebRequest -Uri \"https://secondtestdoc.s3.amazonaws.com/API.ps1\" -OutFile API.ps1 -UseBasicParsing; invoke-expression -Command \"./API.ps1\";";

System.out.println(CMD);
try
{		
System.out.println("<<<<<<<Command to Trigger the Agent Installation>>>>>>>>>>"+ "\n" + CMD);
ProcessBuilder pb=new ProcessBuilder("cmd.exe","/c",CMD);
pb.redirectErrorStream(true);
Process process=pb.start();
BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
String s;
StringBuilder vaultkey = new StringBuilder();
while ((s = stdInput.readLine()) != null)
{
vaultkey.append(s);
}
System.out.println(vaultkey);
} 
catch (Exception e) 
{
System.out.println(e);
throw new ResponseStatusException(HttpStatus.NOT_FOUND);	
}
}

@PostMapping("/agentinstall")
public void installConfigServerAgent()
{

String CMD = "java -jar  C:\\Users\\Administrator\\dist\\AzureSiteRecoveryAgent.jar";

System.out.println(CMD);
try
{		
System.out.println("<<<<<<<Command to Start the Agent Installation>>>>>>>>>>"+ "\n" + CMD);
ProcessBuilder pb=new ProcessBuilder("cmd.exe","/c",CMD);
pb.redirectErrorStream(true);
Process process=pb.start();
BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
String s;
StringBuilder vaultkey = new StringBuilder();
while ((s = stdInput.readLine()) != null)
{
vaultkey.append(s);
}
System.out.println(vaultkey);
} 
catch (Exception e) 
{
System.out.println(e);
throw new ResponseStatusException(HttpStatus.NOT_FOUND);	
}	
}

}
