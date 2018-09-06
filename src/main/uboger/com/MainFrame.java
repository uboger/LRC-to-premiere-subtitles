package main.uboger.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.dom4j.Document;

import technology.uboger.dao.XMLDom;
import technology.uboger.dao.XMLTools;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 366332625892346852L;
	
	private JTextField textField;
	private JButton btn ;
	private JFileChooser jf;
	private String path;
	private String conver;
	private Document doc ;
	
	/**
	 * 
	 * @throws HeadlessException
	 */

	 MainFrame(){
		
		this.setLayout(new BorderLayout());
		jf=new JFileChooser();
		textField = new JTextField();
		btn = new JButton("打开LRC文件");
		btn.setFont(new Font("宋体",Font.BOLD,60));
		jf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				path = jf.getSelectedFile().getPath();
				if(path.endsWith(".lrc")){
					try {
						XMLDom xd = new XMLDom(path);
						
						doc = xd.getNewXMLDom();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					try {
						XMLTools.write(doc, path);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		/**
		 * 当鼠标单击按钮时
		 */
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				//
				if(btn.getText().equals("打开LRC文件")){
					btn.setText("另存为");
					// TODO Auto-generated method stub
					jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					jf.setFileFilter(new FileFilter() {
						
						@Override
						public String getDescription() {
							// TODO Auto-generated method stub
							return "mp3歌词文件(.lrc)";
						}
						
						@Override
						public boolean accept(File arg0) {
							// TODO Auto-generated method stub
							if(arg0.getName().endsWith(".lrc")||arg0.isDirectory()){
								return true;
							}else{
								return false;
							}
						}
					});
					jf.showDialog(new Label(), "选择");
					jf.setVisible(true);
					conver = jf.getSelectedFile().getName();
					return;
				}
				if(btn.getText().equals("另存为")){
					btn.setText("打开LRC文件");
					jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					jf.setFileFilter(new FileFilter() {
						
						@Override
						public String getDescription() {
							// TODO Auto-generated method stub
							jf.setSelectedFile(new File(conver.replace(".lrc", "")+".xml")); //设置默认文件名
							return "Premiere Pro cc 字幕文件（*.xml)";
						}
						
						@Override
						public boolean accept(File arg0) {
							// TODO Auto-generated method stub
							if(arg0.getName().endsWith(".xml")||arg0.isDirectory()){
								return true;
							}else{
							return false;
							}
						}
					});
					jf.showSaveDialog(null);
					jf.setVisible(true);
					return;
				}

			}
		});
		
		textField.setSize(350, 150);
		textField.setBackground(Color.cyan);
		//this.add(btn,BorderLayout.NORTH);
		//this.add(textField,BorderLayout.SOUTH);
		this.add(btn);
		
		this.setTitle("Premiere CC LRC 格式 转换器  BY  Uboger 出品");
		this.setSize(700,350);
		/**
		 * 界面背景色黑色
		 */
		this.getContentPane().setBackground(Color.blue);
		this.setBackground(Color.black);
		//this.getContentPane().setVisible(false);
		this.setResizable(false);//不可改变窗体大小
		this.setLocationRelativeTo(this);//居中显示
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public static void main(String[] args){
		new MainFrame();
	}

}
