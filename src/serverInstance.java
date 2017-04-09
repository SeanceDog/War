import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverInstance implements Runnable{
	private ServerSocket server;
	int port;

	
	serverInstance(int port) {
		this.port = port;
		
		
		
	}

	@Override
	public void run() {
		try {
			server = new ServerSocket(port);
			Socket clientSocket = server.accept();
			System.out.println("Success!");
			DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream is = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			while(true){
				if(is != null) {
				String testing = is.readUTF();
				System.out.println(testing);
				}

			//System.out.println("Reading...");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	

}
