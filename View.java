package pl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	FileWriter fw =null;
	StringBuilder txt = new StringBuilder();
	JTextArea DisplayTextArea;
	JTextArea EditTextArea;
	static JTextArea InTextArea;
	String sname = null;
	Font font = new Font("宋体", Font.PLAIN, 18);
	public static View view;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view=new View();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1296, 704);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		File file = new File("F:\\cording/text.txt");
		try {
			file.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		JScrollPane DisplayText = new JScrollPane();
		DisplayText.setBounds(807, 27, 386, 586);
		frame.getContentPane().add(DisplayText);
		
		DisplayTextArea = new JTextArea();
		DisplayText.setViewportView(DisplayTextArea);
		DisplayTextArea.setEditable(false);
		DisplayTextArea.setFont(font);
		
		JScrollPane EditText = new JScrollPane();
		EditText.setBounds(265, 27, 492, 323);
		frame.getContentPane().add(EditText);
		
		EditTextArea = new JTextArea();
		EditText.setViewportView(EditTextArea);
		EditTextArea.setFont(font);
		
		JScrollPane InText = new JScrollPane();
		InText.setBounds(265, 378, 492, 235);
		frame.getContentPane().add(InText);
		
		InTextArea = new JTextArea();
		InText.setViewportView(InTextArea);
		InTextArea.setFont(font);
		
		JButton btnNewButton = new JButton("提交运行");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = EditTextArea.getText();
				try {
					fw = new FileWriter(file);
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == 10) {
							fw.write(13);// 写入\r
							fw.write(10);// 写入\n
						} else {
							fw.write(str.charAt(i));
						}
					}
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				sname = "F:\\cording/text.txt";
				BufferedReader fin;
				try {
					fin = new BufferedReader(new FileReader(sname), 4096);
					PL0 pl = new PL0(fin, view);
					pl.start(pl);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				if(Err.judge){
					FileReader fr;
					try {
						fr = new FileReader("fa2.tmp");
						SetInText(fr);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(42, 83, 171, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("虚拟机代码");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader fr;
				try {
					fr = new FileReader("fa.tmp");
					DisplaySetText(fr);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(42, 176, 171, 58);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("源文件显示");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader fr;
				try {
					fr = new FileReader("fa1.tmp");
					DisplaySetText(fr);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(42, 281, 171, 58);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("结果显示");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader fr;
				try {
					fr = new FileReader("fa2.tmp");
					DisplaySetText(fr);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(42, 387, 171, 58);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("符号表显示");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader fr;
				try {
					fr = new FileReader("fas.tmp");
					DisplaySetText(fr);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(42, 495, 171, 58);
		frame.getContentPane().add(button_3);
	}
	//DisPlayText显示文本控制
	public void DisplaySetText(FileReader fr) {
		BufferedReader br = new BufferedReader(fr);
		txt.delete(0, txt.length());
		try {
			String str = br.readLine();
			while(str != null) {
				txt.append(str);
				txt.append("\r\n");
				str = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DisplayTextArea.setText(txt.toString());
	}
	
	//EditTextArea文本控制
	public void EditText(String str) {
		EditTextArea.setText(str);
	}
	
	//InTextArea文本控制
	public static void InText(String str) {
		InTextArea.setText(str);
	}
	//结果显示控制台上
	public void SetInText(FileReader fr) {
		BufferedReader br = new BufferedReader(fr);
		txt.delete(0, txt.length());
		try {
			String str = br.readLine();
			while(str != null) {
				txt.append(str);
				txt.append("\r\n");
				str = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InTextArea.setText(txt.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
