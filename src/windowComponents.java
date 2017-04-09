import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.*;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.*;

public class windowComponents extends JFrame{
	JPanel mainPanel;
	JButton client;
	JButton host;
	JButton connect;
	JTextArea IP;
	JTextArea portNumber;
	JLabel prompt;
	serverInstance server;
	Client clientConnect;
	private static boolean clientOrHost;	
	
	windowComponents() {
		mainPanel = new JPanel(new MigLayout("align center"));
		this.setSize(800, 700);
		
	
		
		
	}
	public void initalize() {
		this.setVisible(true);
		client = new JButton("Client");
		host = new JButton("Host");
		prompt = new JLabel ("Are you the Host or the Client?");
		ButtonListener bl = new ButtonListener();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		client.addActionListener(bl);
		host.addActionListener(bl);
		mainPanel.add(prompt, "wrap");
		mainPanel.add(client, "align center, wrap");
		mainPanel.add(host, "align center");
		this.add(mainPanel);

		
	}
	public boolean getClientOrHost() {
		return clientOrHost;
	}
	private class ButtonListener implements ActionListener {
	
		public void removeClientHost() {
			mainPanel.remove(client);
			mainPanel.remove(host);
			mainPanel.remove(prompt);
			mainPanel.revalidate();
			mainPanel.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == connect) {
				if(clientOrHost) {
				server = new serverInstance(Integer.parseInt(portNumber.getText()));
				new Thread(server).start();
				}else{
					clientConnect = new Client(portNumber.getText());
					new Thread(clientConnect).start();
					
				}
			}
			
			if(e.getSource() == client) {
				removeClientHost();
				clientOrHost = false;
				prompt.setText("Please enter Host IP&Port (Ex. 192.168.0.0:8000)");
				portNumber = new JTextArea("IP&Port");
				mainPanel.add(prompt, "align center, wrap");
				connect = new JButton("Connect");
				connect.addActionListener(this);
				mainPanel.add(connect, "align center, wrap");
				mainPanel.add(portNumber, new CC().minWidth("125").maxWidth("125").alignX("center").wrap());
			}else if (e.getSource() == host) {
				//true == host
				removeClientHost();
				clientOrHost = true;
				prompt.setText("Please set Port");
			    JLabel IP = new JLabel("");
			    mainPanel.add(prompt, "align center, wrap");
				
				try {
					URL whatismyip = new URL("http://checkip.amazonaws.com");
					BufferedReader in = new BufferedReader(new InputStreamReader(
					                whatismyip.openStream()));
					String ip = in.readLine(); //you get the IP as a String
					System.out.println(ip);
					IP.setText("IP: "+ip);
					mainPanel.add(IP, "align center, wrap");
					portNumber = new JTextArea("Port");
					connect = new JButton("Start");
					mainPanel.add(portNumber, new CC().minWidth("50").maxWidth("50").alignX("center").wrap());
					mainPanel.add(connect, "align center");
					connect.addActionListener(this);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
				
			
			
			// TODO Auto-generated method stub
			
		}
		
	}

}
