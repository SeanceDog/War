import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	int port;
	String IP;
	private Socket connection;
	Client(String info) {
		String splitted[] = info.split(":");
		IP = splitted[0];
		port = Integer.parseInt(splitted[1]);
	}

	@Override
	public void run() {
		try {
			connection = new Socket(IP, port);
			DataOutputStream os = new DataOutputStream(connection.getOutputStream());
			InputStream is = connection.getInputStream();
			while(true){
				os.writeUTF("something");
				os.flush();
				
			
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
				connection.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

}
