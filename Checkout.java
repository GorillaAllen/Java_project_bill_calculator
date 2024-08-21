package bill_calculator;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Checkout {
	JFrame c;
	ImageIcon backIcon;
	
	Checkout(String members) {
		c = new JFrame("分帳畫面");// title
		c.setIconImage(Toolkit.getDefaultToolkit().getImage(Checkout.class.getResource("/bill_calculator/travelBox.png")));
		final JLabel label = new JLabel();
		label.setBounds(200, 100, 200, 10);
		c.getContentPane().setLayout(null);
		ArrayList<String> member_list = new ArrayList<String>();
		member_list = PrintAllMember.printAllMember();
		JTextArea MemberTextArea = new JTextArea();
		MemberTextArea.setFont(new Font("標楷體", Font.PLAIN, 22));
		for(int i = 0; i < 3; i++) {
			String name = member_list.get(i);
			MemberTextArea.append(name+"\n");
		};
        MemberTextArea.setBounds(29, 85, 164, 258);
        MemberTextArea.setLineWrap(true); // 設置自動換行
        MemberTextArea.setWrapStyleWord(true); // 換行時不斷字
        MemberTextArea.setEditable(false); // 禁止編輯
        MemberTextArea.setBackground(UIManager.getColor("Label.background")); // 背景顏色與 JLabel 一致
        MemberTextArea.setBorder(null); // 移除邊框，使其更像 JLabel
		
        
		
		JLabel MemberLabel_1 = new JLabel("成員姓名");
		MemberLabel_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		MemberLabel_1.setBounds(43, 24, 105, 37);
		
		
		JLabel MemberLabel_1_1 = new JLabel("應付帳款");
		MemberLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		MemberLabel_1_1.setBounds(231, 24, 105, 37);
		
		
		//SelectFromDatabase na = new SelectFromDatabase();
		//String pre_paid = na.selectFrom();
		String AAA = "AAA";
		double aa = 0.0;
		String BBB = "BBB";
		double bb = 0.0;
		String CCC = "CCC";
		double cc = 0.0;
		
		SelectAmount sa = new SelectAmount();
		ArrayList<Double> amount_list = SelectAmount.selectAmount();
		ArrayList<String> name_list = SelectNameOfPrepaid.selectNameOfPrepaid();
		for(int i = 0; i < amount_list.size(); i++) {
			double amount = amount_list.get(i);
			String name = name_list.get(i);
			if( name.equals("AAA")) {
				aa += (amount/3)*2 ;
				bb += -(amount/3) ;
				cc += -(amount/3) ;
			}
			if ( name.equals("BBB")) {
				aa += -(amount/3) ;
				bb += (amount/3)*2;
				cc += -(amount/3) ;
			}
			if ( name.equals("CCC")) {
				aa += -(amount/3) ;
				bb += -(amount/3) ;
				cc += (amount/3)*2;
			};
		}
		
		
		
		
		//System.out.print(pre_paid);
		JTextArea MemberTextArea_1 = new JTextArea();
		MemberTextArea_1.setFont(new Font("標楷體", Font.PLAIN, 22));
		MemberTextArea_1.append(""+aa);
		MemberTextArea_1.append("\n"+bb);
		MemberTextArea_1.append("\n"+cc);
		MemberTextArea_1.setWrapStyleWord(true);
		MemberTextArea_1.setLineWrap(true);
		MemberTextArea_1.setEditable(false);
		MemberTextArea_1.setBorder(null);
		MemberTextArea_1.setBackground(UIManager.getColor("Button.background"));
		MemberTextArea_1.setBounds(231, 83, 164, 258);
		c.getContentPane().add(MemberTextArea_1);
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(10, 187, 264, 163);
		
		c.setSize(464, 550);
		c.setVisible(true);
		c.getContentPane().add(MemberTextArea);
		c.getContentPane().add(MemberLabel_1);
		c.getContentPane().add(MemberLabel_1_1);
		
		RoundButton backButton = new RoundButton();
		backButton.setBackground(new Color(228, 216, 205));
		backIcon = new ImageIcon(getClass().getResource("/back.png"));
		backButton.setIcon(backIcon);
		backButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		backButton.setBounds(160, 405, 100, 100);
		backButton.setHorizontalTextPosition(JButton.CENTER);
		backButton.setVerticalTextPosition(JButton.BOTTOM);
		c.getContentPane().add(backButton);
		
		
		backButton.addActionListener(e -> {
            // Hide Checkout window
            c.setVisible(false);

            // Create and show Top window
            Top topPage = new Top();
            topPage.setVisible(true);

            // Optionally dispose of Checkout if you don't need it anymore
            c.dispose();
        });
	}
	public static void main(String[] args) {
		new Checkout(""); // 使用空參數，因為沒有來自其他窗口的資料
}
}