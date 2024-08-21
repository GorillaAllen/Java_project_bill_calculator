package bill_calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class Top extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon creatgroupIcon;
	ImageIcon mygroupIcon;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Top frame = new Top();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
//	 Create the frame.
	
	public Top() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Top.class.getResource("/bill_calculator/travelBox.png")));
				
	    setTitle("旅遊分帳");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		RoundButton creatgroupButton = new RoundButton();
		creatgroupButton.setBackground(new Color(170, 213, 213));
		contentPane.add(creatgroupButton);
		creatgroupIcon = new ImageIcon(getClass().getResource("/creatgroup.png"));
		creatgroupButton.setText("建立群組");
		creatgroupButton.setFont(new Font("標楷體", Font.PLAIN, 20));
		creatgroupButton.setBounds(97, 10, 240, 240);
		creatgroupButton.setIcon(creatgroupIcon);
		creatgroupButton.setHorizontalTextPosition(JButton.CENTER);
		creatgroupButton.setVerticalTextPosition(JButton.BOTTOM);

		
		
		 // 添加 ActionListener 到 btnNewButton1 來打開 GroupCreationPage_R1
        creatgroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 當按鈕被點擊時，打開 GroupCreationPage_R1 視窗
                new GroupCreationPage_R1();
                dispose();//關閉當前視窗
            }
        });
		
		
        RoundButton mygroupButton = new RoundButton();
		mygroupButton.setBackground(new Color(249, 204, 187));
		setContentPane(contentPane);
		contentPane.add(mygroupButton);
		creatgroupIcon = new ImageIcon(getClass().getResource("/mygroup.png"));
		mygroupButton.setText("我的群組");
		mygroupButton.setFont(new Font("標楷體", Font.PLAIN, 20));
		mygroupButton.setBounds(97, 263, 240, 240);
		mygroupButton.setIcon(creatgroupIcon);
		mygroupButton.setHorizontalTextPosition(JButton.CENTER);
		mygroupButton.setVerticalTextPosition(JButton.BOTTOM);
//		btnNewButton2.setIconTextGap(-20);
		mygroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 當按鈕被點擊時，打開 GroupCreationPage_R1 視窗
                new New_group();
                dispose();//關閉當前視窗
                
            }
        });
		}
}