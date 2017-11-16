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
private JTextField textField;//JTextField 是一个轻量级组件，它允许编辑单行文本。有关使用文本字段的信息和示例
private double v1,v2,value;//v1,v2用于存放文本框中的值，value 用书存放运算结果
private char operator;
private boolean reop =false;//用来判断是否用户按下=号


private void init() {
	  textField = new JTextField();
	  textField.setEditable(false); 
	  textField.setHorizontalAlignment(JTextField.RIGHT);//右对齐
	  JPanel panel = new JPanel();
	  panel.setLayout(new GridLayout(4,4));//用面板管理器的示例来对容器空间进行布局
	  
	  Container container = getContentPane();
	  container.add(textField, BorderLayout.NORTH);//向 容器 派生类组件
	  container.add(panel,BorderLayout.CENTER);
	  
	  panel.add(useButton('7'));//添加按钮，名字是7
	  panel.add(useButton('8'));
	  panel.add(useButton('9'));
	  panel.add(useButton('+'));//按照横排设计按钮的顺序添加合适的按钮所以是7 8 9 +
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



public JButton useButton(final char key)//给按钮添加事件方法
{
	JButton button=new JButton(String.valueOf(key));
	
	button.addActionListener(new ActionListener()//给按钮添加事件方法
			{
		public void actionPerformed(ActionEvent event) {//对单击按钮方法
			JButton btn=(JButton) event.getSource();
			char key2 =btn.getText().charAt(0);
			action(key2);
		}
			});
	button.addKeyListener(new KeyAdapter(){//下面对KeyAdapter进行重写
		
	  public void keyReleased(KeyEvent event) {
		  char key2 = event.getKeyChar();//给key2（用于存储运算符）添加事件
	      action(key2);//执行key2的事件
	  }
		
  });
	
	return button;
}
	
	
	
	
	
private void action(char key2)//key2用于判断进行什么运算
{
	if(reop)
	{
		textField.setText("");
		reop = false;
	}
	
	switch(key2)
	{
	case '+':
	    v1=Double.parseDouble(textField.getText());//将当前屏幕上面的数字保存到v1,通过String类型转化成int类型
	    textField.setText("");//暂时将屏幕清空
	    operator ='+';//另运算符号为+
	    break;//结束，直接退出不向下执行
	case '-':
	    v1=Double.parseDouble(textField.getText());//把String类型转化成int类型
	    textField.setText("");//暂时将屏幕清空
	    operator ='-';//另运算符号为-
	    break;//结束，直接退出不向下执行
	case '*':
	    v1=Double.parseDouble(textField.getText());//把String类型转化成int类型
	    textField.setText("");//暂时将屏幕清空
	    operator ='*';//另运算符号为*
	    break;//结束，直接退出不向下执行
	case '/':
	    v1=Double.parseDouble(textField.getText());//把String类型转化成int类型
	    textField.setText("");//暂时将屏幕清空
	    operator ='/';//另运算符号为+
	    break;//结束，直接退出不向下执行
	case '=':
	    reop = true;
	    v2=Double.parseDouble(textField.getText());//用户按完加减乘除后会再次输入数据，这时候将这个数据保存，并转成DOUBLE类型
	       switch(operator)//按下等于号就要进行相应的计算了
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
	       textField.setText(String.valueOf(value));//最后在屏幕上输出结果，因为setText参数只能是String类型，所以用一下形式转换
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
		String text =textField.getText() + key2;//因为switch的语法，所以只要是key2是1 2 3 4 5 6 7 8 9 0 . 都运行下列代码
		textField.setText(text);
		break;
	}   
	       	
	
}

public static void main(String[] args) { 
Calculators frame = new Calculators();//建立Calculators类型对象，属于顶级容器，因为继承了JFrame

frame.setTitle("Calculator");//标题名字
frame.setSize(240, 320);//设置窗口长和宽
frame.setResizable(false);//设置框架不可以由用户调整
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//当用户close窗口时就关闭
frame.init();
frame.setVisible(true);//和SHOW FRAME 差不多，就是显示矿口
	
}

}

