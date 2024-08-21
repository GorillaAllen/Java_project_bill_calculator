package bill_calculator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

/*創建群組頁面: 此頁面需要的user可見物: 
輸入群組名稱的欄位*1, 下拉式選單選貨幣*1, 備註用Jtextarea*1, 創建群組用jbutton*/
public class GroupCreationPage_R1 {
	JFrame f;
	ImageIcon addnewgroupIcon;
	
	GroupCreationPage_R1() {
		f = new JFrame("創建群組");// JFrame必有
		f.setIconImage(Toolkit.getDefaultToolkit().getImage(GroupCreationPage_R1.class.getResource("/bill_calculator/travelBox.png")));
		final JLabel label = new JLabel();
		label.setBounds(200, 100, 200, 10);

		// 表示下方textfield是用來輸入群組名稱的
		JLabel nameLabel = new JLabel("輸入群組名");
		nameLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		nameLabel.setBounds(53, 28, 109, 30);

		JTextField tf = new JTextField();
		;// 輸入群組名稱的欄位
		tf.setBounds(91, 78, 248, 41);

		// 表示右方combobox是用來選擇貨幣別的
		JLabel currencyLabel = new JLabel("選擇貨幣別");
		currencyLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		currencyLabel.setBounds(53, 174, 93, 42);

		// 下拉式選單選貨幣
		String currency[] = { "台幣", "美金", "日幣", "韓圓", "人民幣", "歐元", "泰銖", "港幣", "英鎊", "澳幣", "越南盾", "印尼盾" };
		final JComboBox<?> currency_box = new JComboBox<Object>(currency);
		currency_box.setFont(new Font("標楷體", Font.PLAIN, 16));
		currency_box.setBounds(208, 172, 153, 47);

		// 備註用Jtextarea
//		JTextArea textarea = new JTextArea("備註:");
//		textarea.setFont(new Font("標楷體", Font.PLAIN, 16));
//		textarea.setBounds(50, 234, 377, 208);

		// 創建群組用的Jbutton
		RoundButton GroupCreationButton = new RoundButton();
		GroupCreationButton.setBackground(new Color(242, 239, 179));
		addnewgroupIcon = new ImageIcon(getClass().getResource("/newgroupadd.png"));
		GroupCreationButton.setText("新增群組");
		GroupCreationButton.setIcon(addnewgroupIcon);
		GroupCreationButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		GroupCreationButton.setBounds(150, 400, 100, 100);
		GroupCreationButton.setHorizontalTextPosition(JButton.CENTER);
		GroupCreationButton.setVerticalTextPosition(JButton.BOTTOM);
		// 加入新增群組button的action listener
		GroupCreationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Member();
				f.dispose();
			}
		});

		f.getContentPane().add(tf);
		f.getContentPane().add(nameLabel);
		f.getContentPane().add(currencyLabel);
		f.getContentPane().add(currency_box);
//		f.getContentPane().add(textarea);
		f.getContentPane().add(GroupCreationButton);
		f.getContentPane().setLayout(null);
		f.setSize(464, 550);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new GroupCreationPage_R1();
	}

}