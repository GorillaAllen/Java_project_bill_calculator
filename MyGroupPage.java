package bill_calculator;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
/*我的群組頁面: 此頁面需要的user可見物: 
該頁面名稱的label, 創建群組的button, 開啟已創建群組的button*/

public class MyGroupPage {
	JFrame f;
	ImageIcon newgroupaddIcon;
	
	
	MyGroupPage(){
		f = new JFrame("我的群組");//JFrame必有
		f.setIconImage(Toolkit.getDefaultToolkit().getImage(MyGroupPage.class.getResource("/bill_calculator/travelBox.png")));
		final JLabel label = new JLabel();
		label.setBounds(200, 100, 200, 10);
		f.getContentPane().setLayout(null);
		
		//創建群組用的Jbutton
		RoundButton newgroupaddButton = new RoundButton();
		newgroupaddButton.setBackground(new Color(241, 241, 169));
		newgroupaddIcon = new ImageIcon(getClass().getResource("/newgroupadd.png"));
		newgroupaddButton.setText("新增群組");
		newgroupaddButton.setIcon(newgroupaddIcon);
		newgroupaddButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		newgroupaddButton.setBounds(150, 400, 100, 100);
		newgroupaddButton.setHorizontalTextPosition(JButton.CENTER);
		newgroupaddButton.setVerticalTextPosition(JButton.BOTTOM);
		
		f.getContentPane().add(newgroupaddButton);
		f.setSize(464, 550);
		f.setVisible(true);
	}
	
	void addButtonToThisPage(){
		JButton button = new JButton("新群組名");
		button.setSize(100, 20);
		this.f.getContentPane().add(button);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyGroupPage mgp = new MyGroupPage();
	}

}