package javaSimpleSocket;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class JavaSocketServer {

	public static void main(String[] args) throws IOException{
	Scanner scn = new Scanner(System.in);
	ServerSocket serverSocket = new ServerSocket(5001);
	Socket socket = serverSocket.accept();
	
	System.out.println(socket.getLocalAddress() + " baglandý.");
	
	OutputStream out = socket.getOutputStream();
	DataOutputStream dataOut = new DataOutputStream(out);
	InputStream in = socket.getInputStream();
	DataInputStream dataIn = new DataInputStream(in);
	
	String inText="",outText=" ";
	
		while((inText= dataIn.readUTF())!=null){
			
			if(inText.equals("exit")){
				serverSocket.close();
				socket.close();
				in.close();
				out.close();
				dataOut.close();
				dataIn.close();
				System.exit(0);
			}
			System.out.println("Client : "+inText);
			
			System.out.print("Server : ");
			outText= scn.nextLine();
			dataOut.writeUTF(outText);
			
		}
		

		
		
		
	}

}
