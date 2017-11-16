/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package czd;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Calculators extends JFrame{
private JTextField textField;//JTextField ��һ�������������������༭�����ı����й�ʹ���ı��ֶε���Ϣ��ʾ��
private double v1,v2,value;//v1,v2���ڴ���ı����е�ֵ��value ������������
private char operator;
private boolean reop =false;//�����ж��Ƿ��û�����=��


private void init() {
	  textField = new JTextField();
	  textField.setEditable(false); 
	  textField.setHorizontalAlignment(JTextField.RIGHT);//�Ҷ���
	  JPanel panel = new JPanel();
	  panel.setLayout(new GridLayout(4,4));//������������ʾ�����������ռ���в���
	  
	  Container container = getContentPane();
	  container.add(textField, BorderLayout.NORTH);//�� ���� ���������
	  container.add(panel,BorderLayout.CENTER);
	  
	  panel.add(useButton('7'));//��Ӱ�ť��������7
	  panel.add(useButton('8'));
	  panel.add(useButton('9'));
	  panel.add(useButton('+'));//���պ�����ư�ť��˳����Ӻ��ʵİ�ť������7 8 9 +
	  panel.add(useButton('4'));
	  panel.add(useButton('5'));
	  panel.add(useButton('6'));
	  panel.add(useButton('-')); // 4 5 6 -
	  panel.add(useButton('1'));
	  panel.add(useButton('2'));
	  panel.add(useButton('3'));
	  panel.add(useButton('*'));
	  panel.add(useButton('0'));
	  panel.add(useButton('.'));
	  panel.add(useButton('='));
	  panel.add(useButton('/'));
	  

}



public JButton useButton(final char key)//����ť����¼�����
{
	JButton button=new JButton(String.valueOf(key));
	
	button.addActionListener(new ActionListener()//����ť����¼�����
			{
		public void actionPerformed(ActionEvent event) {//�Ե�����ť����
			JButton btn=(JButton) event.getSource();
			char key2 =btn.getText().charAt(0);
			action(key2);
		}
			});
	button.addKeyListener(new KeyAdapter(){//�����KeyAdapter������д
		
	  public void keyReleased(KeyEvent event) {
		  char key2 = event.getKeyChar();//��key2�����ڴ洢�����������¼�
	      action(key2);//ִ��key2���¼�
	  }
		
  });
	
	return button;
}
	
	
	
	
	
private void action(char key2)//key2�����жϽ���ʲô����
{
	if(reop)
	{
		textField.setText("");
		reop = false;
	}
	
	switch(key2)
	{
	case '+':
	    v1=Double.parseDouble(textField.getText());//����ǰ��Ļ��������ֱ��浽v1,ͨ��String����ת����int����
	    textField.setText("");//��ʱ����Ļ���
	    operator ='+';//���������Ϊ+
	    break;//������ֱ���˳�������ִ��
	case '-':
	    v1=Double.parseDouble(textField.getText());//��String����ת����int����
	    textField.setText("");//��ʱ����Ļ���
	    operator ='-';//���������Ϊ-
	    break;//������ֱ���˳�������ִ��
	case '*':
	    v1=Double.parseDouble(textField.getText());//��String����ת����int����
	    textField.setText("");//��ʱ����Ļ���
	    operator ='*';//���������Ϊ*
	    break;//������ֱ���˳�������ִ��
	case '/':
	    v1=Double.parseDouble(textField.getText());//��String����ת����int����
	    textField.setText("");//��ʱ����Ļ���
	    operator ='/';//���������Ϊ+
	    break;//������ֱ���˳�������ִ��
	case '=':
	    reop = true;
	    v2=Double.parseDouble(textField.getText());//�û�����Ӽ��˳�����ٴ��������ݣ���ʱ��������ݱ��棬��ת��DOUBLE����
	       switch(operator)//���µ��ںž�Ҫ������Ӧ�ļ�����
	       {
	       case '+':
	    	   value = v1 + v2;
	    	   break;
	       case '-':
	    	   value = v1 - v2;
	    	   break;
	       case'*':
	    	   value = v1 * v2;
	    	   break;
	       case'/':
	    	   value = v1 / v2;
	    	   break;
	       
	       
	       }
	       textField.setText(String.valueOf(value));//�������Ļ������������ΪsetText����ֻ����String���ͣ�������һ����ʽת��
	       break;
	case '1':
	case '2':
	case '3':
	case '4':
	case '5':
	case '6':
	case '7':
	case '8':
	case '9':
	case '0':
	case '.':
		String text =textField.getText() + key2;//��Ϊswitch���﷨������ֻҪ��key2��1 2 3 4 5 6 7 8 9 0 . ���������д���
		textField.setText(text);
		break;
	}   
	       	
	
}

public static void main(String[] args) { 
Calculators frame = new Calculators();//����Calculators���Ͷ������ڶ�����������Ϊ�̳���JFrame

frame.setTitle("Calculator");//��������
frame.setSize(240, 320);//���ô��ڳ��Ϳ�
frame.setResizable(false);//���ÿ�ܲ��������û�����
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//���û�close����ʱ�͹ر�
frame.init();
frame.setVisible(true);//��SHOW FRAME ��࣬������ʾ���
	
}

}

