package bill_calculator;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.lang.Math;
import java.awt.Color;
import java.awt.Toolkit;

public class AddSpend extends JFrame {

//  獨立測試用
//	public static void main(String[] args) {
//		AddSpend AS = new AddSpend();
//	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField expenseTextField;
	private JTextField amountTextField;
	private JTextField NTDShowField;
	private New_group parent;
	ImageIcon addspendIcin,savesharepersonIcon;
	private JTextField amountSharerList;
	private ArrayList<String> name_list = new ArrayList<String>();
	public AddSpend(New_group parent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddSpend.class.getResource("/bill_calculator/travelBox.png")));
		setAlwaysOnTop(true);
		this.parent = parent;
		setTitle("新增花費");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 550);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel1 = new JLabel("品項");
		lblNewLabel1.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel1.setBounds(20, 39, 83, 39);
		contentPane.add(lblNewLabel1);

		expenseTextField = new JTextField(); // 輸入品項名
		expenseTextField.setBounds(249, 41, 162, 36);
		contentPane.add(expenseTextField);
		expenseTextField.setColumns(10);

		JLabel lblNewLabel2 = new JLabel("金額");
		lblNewLabel2.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel2.setBounds(20, 100, 83, 39);
		contentPane.add(lblNewLabel2);

		amountTextField = new JTextField(""); // 輸入金額
		amountTextField.setBounds(249, 100, 162, 36);
		contentPane.add(amountTextField);
		amountTextField.setColumns(10);

		NTDShowField = new JTextField(""); // 輸出等值台幣用的textfield
		NTDShowField.setBounds(278, 156, 126, 36);
		contentPane.add(NTDShowField);
		NTDShowField.setColumns(10);
		NTDShowField.setEditable(false);

		JLabel spendpersonLabel = new JLabel("付款者");
		spendpersonLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		spendpersonLabel.setBounds(20, 215, 83, 36);
		contentPane.add(spendpersonLabel);

		JLabel lblNewLabel4 = new JLabel("分帳者");
		lblNewLabel4.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel4.setBounds(20, 343, 83, 36);
		contentPane.add(lblNewLabel4);

//		JTextArea textArea = new JTextArea();
//		textArea.setFont(new Font("標楷體", Font.PLAIN, 16));
//		textArea.setText("備註:");
//		textArea.setBounds(20, 384, 379, 99);
//		contentPane.add(textArea);

		RoundButton addspendButton = new RoundButton();
		addspendButton.setBackground(new Color(250, 220, 205));
		addspendIcin = new ImageIcon(getClass().getResource("/addspend.png"));
		contentPane.add(addspendButton);
		addspendButton.setText("新增帳款");
		addspendButton.setIcon(addspendIcin);
		addspendButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		addspendButton.setBounds(179, 405, 100, 100);
		addspendButton.setHorizontalTextPosition(JButton.CENTER);
		addspendButton.setVerticalTextPosition(JButton.BOTTOM);
		addspendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String text1 = expenseTextField.getText();
				String text2 = NTDShowField.getText();
				parent.updateTextAreas(text1, text2);
				dispose();
			}
		});

		JComboBox expenseComboBox = new JComboBox();
		expenseComboBox.setFont(new Font("標楷體", Font.PLAIN, 16));
		expenseComboBox.setModel(new DefaultComboBoxModel(new String[] { "餐飲", "伴手禮", "交通", "門票", "醫療", "其他" }));
		expenseComboBox.setBounds(113, 39, 126, 38);

		contentPane.add(expenseComboBox);

		JComboBox amountComboBox = new JComboBox();
		amountComboBox.setFont(new Font("標楷體", Font.PLAIN, 16));
		amountComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "台幣", "美金", "日幣", "韓圓", "人民幣", "歐元", "泰銖", "港幣", "英鎊", "澳幣", "越南盾", "印尼盾" }));
		amountComboBox.setBounds(113, 100, 126, 38);
		contentPane.add(amountComboBox);

		JList list1 = new JList<Object>();
		list1.setModel(new AbstractListModel() {
			String[] values = new String[] { "A", "B", "C" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list1.setBounds(85, 135, 1, 1);
		contentPane.add(list1);

		JList list2 = new JList<Object>();
		list2.setBounds(85, 145, 1, 1);
		contentPane.add(list2);

		JLabel showNTDlabel = new JLabel("1.0");
		showNTDlabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		showNTDlabel.setBounds(113, 155, 89, 37);
		contentPane.add(showNTDlabel);

		JLabel exchangerateLabel = new JLabel("匯率:");
		exchangerateLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		exchangerateLabel.setBounds(20, 154, 72, 39);
		contentPane.add(exchangerateLabel);

		JLabel lblNewLabel_1 = new JLabel("等值台幣:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(179, 157, 89, 33);
		contentPane.add(lblNewLabel_1);

		JComboBox sharespendComboBox = new JComboBox();
		sharespendComboBox.setFont(new Font("標楷體", Font.PLAIN, 16));
		sharespendComboBox.setBounds(113, 272, 126, 38);
		contentPane.add(sharespendComboBox);
		// 添加選項到 JComboBox
		name_list = PrintAllMember.printAllMember();
		for(int i = 0; i < 3; i++ ) {
		sharespendComboBox.addItem(name_list.get(i));
		}

		RoundButton savesharepersonButton = new RoundButton();
		savesharepersonButton.setBackground(new Color(218, 203, 231));
		savesharepersonIcon = new ImageIcon(getClass().getResource("/save.jpg"));
		savesharepersonButton.setText("新增分帳成員");
		savesharepersonButton.setIcon(savesharepersonIcon);
		savesharepersonButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		savesharepersonButton.setBounds(261, 254, 150, 80);
		savesharepersonButton.setHorizontalTextPosition(JButton.CENTER);
		savesharepersonButton.setVerticalTextPosition(JButton.BOTTOM);
		contentPane.add(savesharepersonButton);

		savesharepersonButton.addActionListener(e -> {
			// 獲取 JComboBox 中選中的項目
			String selectedItem = (String) sharespendComboBox.getSelectedItem();

			// 獲取目前 JTextField 中的文本
			String currentText = amountSharerList.getText();

			// 如果目前的文本不是空的，則在附加新項目前加上空格
			if (!currentText.isEmpty()) {
				currentText += "   ";
			}

			// 將新選擇的項目附加到 JTextField 的現有文本之後
			amountSharerList.setText(currentText + selectedItem);
		});

		amountSharerList = new JTextField("");
		amountSharerList.setEditable(false);
		amountSharerList.setColumns(10);
		amountSharerList.setBounds(118, 344, 244, 36);
		contentPane.add(amountSharerList);
		
		JLabel sharepersonLabel = new JLabel("分帳人選");
		sharepersonLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		sharepersonLabel.setBounds(20, 273, 83, 36);
		contentPane.add(sharepersonLabel);
		
		JComboBox amountComboBox_1 = new JComboBox();
		amountComboBox_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		amountComboBox_1.setBounds(113, 214, 126, 38);
		contentPane.add(amountComboBox_1);
		for(int i = 0; i < 3; i++ ) {
		amountComboBox_1.addItem(name_list.get(i));
		}

		addspendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expense = expenseTextField.getText();
				double amount = Double.parseDouble(NTDShowField.getText());
				//String amountSharer = amountSharerList.getText();
				String selectedItem = (String) amountComboBox_1.getSelectedItem();
				InsertExpense IE = new InsertExpense();
				IE.insertExpense(expense, amount, selectedItem);

			}
		});

		amountComboBox.addActionListener(new ActionListener() { // 監聽combobox內容取得匯率
			public void actionPerformed(ActionEvent e) {
				int rate_selection = amountComboBox.getSelectedIndex();
				double exchange_rate = 0;
				switch (rate_selection) {
				case 0:
					exchange_rate = 1;
					break;
				case 1:
					exchange_rate = 32.68;
					break;
				case 2:
					exchange_rate = 0.223;
					break;
				case 3:
					exchange_rate = 0.024;
					break;
				case 4:
					exchange_rate = 4.579;
					break;
				case 5:
					exchange_rate = 35.98;
					break;
				case 6:
					exchange_rate = 0.9832;
					break;
				case 7:
					exchange_rate = 4.209;
					break;
				case 8:
					exchange_rate = 42.35;
					break;
				case 9:
					exchange_rate = 21.75;
					break;
				case 10:
					exchange_rate = 0.00147;
					break;
				case 11:
					exchange_rate = 0.00238;
					break;
				}
				showNTDlabel.setText("" + exchange_rate);
			}
		});

		// 監聽輸入金額變化自動轉成台幣
		amountTextField.getDocument().addDocumentListener(new DocumentListener() {
			protected void showNTD() {
				String currency_amount = amountTextField.getText();
				String rate = showNTDlabel.getText();
				double money = Double.parseDouble(currency_amount) * Double.parseDouble(rate);
				NTDShowField.setText(String.valueOf(Math.round(money)));
			}

			public void changedUpdate(DocumentEvent e) {
				try {
					showNTD();
				} catch (Exception e1) {
					NTDShowField.setText("請重新輸入");
				}
			}

			public void insertUpdate(DocumentEvent e) {
				try {
					showNTD();
				} catch (Exception e1) {
					NTDShowField.setText("請重新輸入");
				}
			}

			public void removeUpdate(DocumentEvent e) {
				try {
					showNTD();
				} catch (Exception e1) {
					NTDShowField.setText("請重新輸入");
				}
			}
		});

	}
}