package javaSimpleSocket;
import java.net.*;
import java.io.*;
import java.util.*;
public class JavaSocketClient {

	public static void main(String[] args) throws IOException{
		Scanner scn = new Scanner(System.in);
		Socket socket = new Socket("localhost", 5001);
		
		InputStream in = socket.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataOut= new DataOutputStream(out);
		
		String outText="";
		
		while(!((outText).equals("exit"))){
			System.out.print("Client1 : ");
			outText= scn.nextLine();
			dataOut.writeUTF(outText);	
			String inText = new String(dataIn.readUTF());
		    System.out.println("Client2 : "+inText);
		
			
			
		}
		
		
		socket.close();
		in.close();
		out.close();
		dataOut.close();
		dataIn.close();
		System.exit(0);

	}

}
