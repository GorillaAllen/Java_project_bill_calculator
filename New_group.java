package bill_calculator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

// 新增成員
public class New_group {
	JFrame b;
	JTextArea textArea;
	JTextArea textArea_1;
	ImageIcon addIcon, checkmemberIcon, checkoutIcon;
	JTextArea textArea_1_1;

	New_group() {
		b = new JFrame("群組名"); // title
		b.setIconImage(Toolkit.getDefaultToolkit().getImage(New_group.class.getResource("/bill_calculator/travelBox.png")));
		b.setTitle("帳單計算");
		b.getContentPane().setEnabled(false);
		final JLabel label = new JLabel();
		label.setBounds(200, 100, 200, 10);
		b.getContentPane().setLayout(null);

		textArea = new JTextArea(); // 初始化 textArea
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setLineWrap(true);
		textArea.setEnabled(false);
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(35, 185, 123, 229);
		b.getContentPane().add(textArea);

		textArea_1 = new JTextArea(); // 初始化 textArea_1
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_1.setLineWrap(true);
		textArea_1.setEnabled(false);
		textArea_1.setBackground(new Color(240, 240, 240));
		textArea_1.setBounds(245, 185, 130, 229);
		b.getContentPane().add(textArea_1);

		RoundButton checkmemberButton = new RoundButton();
		checkmemberIcon = new ImageIcon(getClass().getResource("/checkmember.png"));
		checkmemberButton.setBackground(new Color(194, 241, 214));
		checkmemberButton.setText("確認人員");
		checkmemberButton.setIcon(checkmemberIcon);
		checkmemberButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkmemberButton.setBounds(28, 27, 130, 76);
		checkmemberButton.setHorizontalTextPosition(JButton.CENTER);
		checkmemberButton.setVerticalTextPosition(JButton.BOTTOM);
		checkmemberButton.addActionListener(e -> {
			
			new Member();
			b.setVisible(false);
			b.dispose();
		});


		RoundButton checkoutButton = new RoundButton(); // 餘額確認
		checkoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkoutButton.setBackground(new Color(194, 210, 241));
		checkoutIcon = new ImageIcon(getClass().getResource("/checkout.png"));
		checkoutButton.setText("結帳");
		checkoutButton.setIcon(checkoutIcon);
		checkoutButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		checkoutButton.setBounds(245, 27, 130, 76);
		checkoutButton.setHorizontalTextPosition(JButton.CENTER);
		checkoutButton.setVerticalTextPosition(JButton.BOTTOM);
		checkoutButton.addActionListener(e -> {
			
			String members = textArea.getText(); // + "\n" + textArea_1.getText();
			new Checkout(members);
			b.setVisible(false);
			b.dispose();
		});

		RoundButton addButton = new RoundButton();
		addIcon = new ImageIcon(getClass().getResource("/add.png"));
		addButton.setBounds(185, 445, 60, 60);
		addButton.setIcon(addIcon);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddSpend(New_group.this).setVisible(true);
				// b.dispose();
				
			}
		});

		JLabel MemberLabel_1 = new JLabel("物品");
		MemberLabel_1.setBackground(new Color(194, 210, 241));
		MemberLabel_1.setBounds(35, 138, 105, 37);
		b.getContentPane().add(MemberLabel_1);

		JLabel MemberLabel_1_1 = new JLabel("金額");
		MemberLabel_1_1.setBounds(245, 138, 105, 37);

		b.getContentPane().add(MemberLabel_1_1);
		b.setSize(464, 550);
		b.getContentPane();
		b.setVisible(true);
		b.getContentPane().add(checkmemberButton);
		b.getContentPane().add(addButton);
		b.getContentPane().add(checkoutButton);

	}

	// 用於接收 AddSpend 回傳數據的方法
	public void updateTextAreas(String text1, String text2) {
		textArea.append(text1 + "\n");
		textArea_1.append(text2 + "\n");
	}
	
	
	public static void main(String[] args) {
		new New_group();
	}
}