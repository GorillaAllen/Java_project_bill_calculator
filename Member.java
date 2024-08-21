package bill_calculator;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

//新增成員
public class Member {
	JFrame a;
	ImageIcon keyinIcon,keylistIcon;
	

	Member() {
		a = new JFrame("新建成員");// title
		a.setIconImage(Toolkit.getDefaultToolkit().getImage(Member.class.getResource("/bill_calculator/travelBox.png")));
		final JLabel label = new JLabel();
		label.setBounds(200, 100, 200, 10);

		JTextField name; // 輸入姓名
		a.getContentPane().setLayout(null);
		name = new JTextField("");
		name.setFont(new Font("標楷體", Font.PLAIN, 16));
		name.setBounds(89, 64, 190, 33);
				
		JLabel MemberLabel = new JLabel("請輸入成員姓名");
		MemberLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		MemberLabel.setBounds(41, 26, 154, 28);
		
		JTextArea showAllMemberArea = new JTextArea();
		showAllMemberArea.setFont(new Font("標楷體", Font.PLAIN, 20));
		showAllMemberArea.setLineWrap(true);
		showAllMemberArea.setEnabled(false);
		showAllMemberArea.setBackground(new Color(240, 240, 240));
		showAllMemberArea.setBounds(21, 204, 406, 217);
		
		RoundButton keyinButton = new RoundButton(); 
		keyinButton.setBackground(new Color(194, 210, 241));
		keyinIcon = new ImageIcon(getClass().getResource("/keyin.png"));
		keyinButton.setText("確認輸入");
		keyinButton.setIcon(keyinIcon);
		keyinButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		keyinButton.setBounds(158, 107, 100, 54);
		keyinButton.setHorizontalTextPosition(JButton.CENTER);
		keyinButton.setVerticalTextPosition(JButton.BOTTOM);
		keyinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = name.getText(); // 取得輸入的文字
                showAllMemberArea.append(text + "\n");// 把輸入的文字加入到textarea 取得新文字後換行 
                InsertMember IM = new InsertMember();//把人名放進expenses資料表
                IM.insertMember(text);
                AddMemberToMemberList AMTML = new AddMemberToMemberList(); //把人名放進allmemberlist資料表
                AMTML.addMemberToMemberList(text);
                name.setText("");//輸入完後自動清空                
              
            }
        });
		RoundButton keylistButton = new RoundButton();
		keylistButton.setBackground(new Color(217, 193, 242));
		keylistIcon = new ImageIcon(getClass().getResource("/checklist.png"));
		keylistButton.setText("輸入完成");
		keylistButton.setIcon(keylistIcon);
		keylistButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		keylistButton.setBounds(158, 430, 120, 70);
		keylistButton.setHorizontalTextPosition(JButton.CENTER);
		keylistButton.setVerticalTextPosition(JButton.BOTTOM);
		keylistButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 當按下 "輸入完成" 時，創建 Checkout 視窗並傳遞 textArea 的內容
                String members = showAllMemberArea.getText();
                new Checkout(members);
                a.dispose(); // 關閉當前視窗
            }
        });
		a.getContentPane().add(MemberLabel);
		a.setSize(464, 550);
		a.getContentPane();
		a.getContentPane().add(name);		
		a.getContentPane().add(showAllMemberArea);
		a.setVisible(true);
		a.getContentPane().add(keyinButton);
		a.getContentPane().add(keylistButton);
		
		
	}

	public static void main(String[] args) {
		new Member();
}
}