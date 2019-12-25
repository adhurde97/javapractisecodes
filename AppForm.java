

import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppForm extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	JComboBox cb1,cb2;
	JButton b;
		
	public AppForm() {
		
		setSize(300,300);
		setVisible(true);
		Panel p=new Panel();
		
		
		l1=new JLabel("Directory");
		l2=new JLabel("files in directory");
		
		cb1=new JComboBox();
		cb2=new JComboBox();
		
		b=new JButton("open");
		
		p.add(l1);
		p.add(cb1);
		p.add(l2);
		p.add(cb2);
		p.add(b);
		
		add(p);
		
		b.addActionListener(this);
		
		File f=new File("d:/");
		String str[]= {};
		if(f.isDirectory()) {
			str=f.list();
		}
		for(String s:str) {
			s="d:/"+s;
			cb1.addItem(s);
			System.out.println(s);
		}
		
		 cb1.addItemListener((ItemListener) new ItemListener() {
	            public void itemStateChanged(ItemEvent ie) {
	                
	                            cb2.removeAllItems();
	                    		String dir_selected=cb1.getSelectedItem().toString();
	                    		
	                    		File f1=new File(dir_selected);
	                    		String files[]= {};
	                    		if(f1.isDirectory()) {
	                    			files=f1.list();
	                    		}
	                    		
	                    		for(String s:files) {
	                    			cb2.addItem(s);
	                    		}
	            }
		 });
				
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String filepath=cb1.getSelectedItem().toString()+"/"+cb2.getSelectedItem().toString();
//		System.out.println(filepath);
		File openfile=new File(filepath);
		Desktop desktop=Desktop.getDesktop();
		try {
			desktop.open(openfile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void main(String [] args) {
		AppForm a=new AppForm();
	}

}

