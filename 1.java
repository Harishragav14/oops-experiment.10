import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Question_1 {
public static void main(String[] args) { SwingUtilities.invokeLater(RegisterFrame::new);
}
}

/* ------------ First JFrame: Student Registration	*/
class RegisterFrame extends JFrame {

private final JTextField txtName	= new JTextField(18); private final JTextField txtRollNo = new JTextField(12);

private final JRadioButton rbMale	= new JRadioButton("Male"); private final JRadioButton rbFemale = new JRadioButton("Female");

private final JCheckBox cbSports = new JCheckBox("Sports"); private final JCheckBox cbMusic = new JCheckBox("Music"); private final JCheckBox cbCoding = new JCheckBox("Coding"); private final JCheckBox cbArt	= new JCheckBox("Art");

private final JComboBox<String> cmbDept =
new JComboBox<>(new String[]{"CSE", "AI & DS", "ECE", "EEE", "MECH",
"CIVIL"});

public RegisterFrame() { super("Student Registration");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setResizable(false);

// group gender
ButtonGroup bg = new ButtonGroup(); bg.add(rbMale); bg.add(rbFemale); rbMale.setSelected(true);

JPanel form = new JPanel(new GridBagLayout()); GridBagConstraints gc = new GridBagConstraints(); gc.insets = new Insets(8, 12, 8, 12);
 
gc.anchor = GridBagConstraints.WEST; int r = 0;
// Name
gc.gridx = 0; gc.gridy = r; form.add(new JLabel("Name:"), gc); gc.gridx = 1; form.add(txtName, gc); r++;

// Roll No
gc.gridx = 0; gc.gridy = r; form.add(new JLabel("Roll No:"), gc); gc.gridx = 1; form.add(txtRollNo, gc); r++;

// Gender
gc.gridx = 0; gc.gridy = r; form.add(new JLabel("Gender:"), gc);
JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)); genderPanel.add(rbMale); genderPanel.add(rbFemale);
gc.gridx = 1; form.add(genderPanel, gc); r++;

// Hobbies (checkboxes)
gc.gridx = 0; gc.gridy = r; form.add(new JLabel("Hobbies:"), gc);
JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)); hobbiesPanel.add(cbSports); hobbiesPanel.add(cbMusic); hobbiesPanel.add(cbCoding); hobbiesPanel.add(cbArt);
gc.gridx = 1; form.add(hobbiesPanel, gc); r++;

// Department (dropdown)
gc.gridx = 0; gc.gridy = r; form.add(new JLabel("Department:"), gc); gc.gridx = 1; form.add(cmbDept, gc); r++;

// Submit button
JButton btnSubmit = new JButton("Submit"); btnSubmit.addActionListener(this::onSubmit);
gc.gridx = 0; gc.gridy = r; gc.gridwidth = 2; gc.anchor = GridBagConstraints.CENTER;
form.add(btnSubmit, gc);

setContentPane(form); pack(); setLocationRelativeTo(null); setVisible(true);
}

private void onSubmit(ActionEvent e) {
 
String name = txtName.getText().trim(); String roll = txtRollNo.getText().trim();

if (name.isEmpty()) { JOptionPane.showMessageDialog(this, "Enter name"); return;
}
if (roll.isEmpty()) {
JOptionPane.showMessageDialog(this, "Enter roll number"); return;
}
String gender = rbMale.isSelected() ? "Male" : "Female"; StringBuilder hobbies = new StringBuilder();
if (cbSports.isSelected()) hobbies.append("Sports, ");
if (cbMusic.isSelected()) hobbies.append("Music, "); if (cbCoding.isSelected()) hobbies.append("Coding, "); if (cbArt.isSelected())	hobbies.append("Art, ");
String hobbyStr = hobbies.length() > 0 ? hobbies.substring(0, hobbies.length() - 2) : "None";

String dept = (String) cmbDept.getSelectedItem();

new DisplayFrame(name, roll, gender, hobbyStr, dept);
}
}

class DisplayFrame extends JFrame {
public DisplayFrame(String name, String roll, String gender, String hobbies, String dept) {
super("Student Details"); setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); setResizable(false);

JPanel panel = new JPanel(new BorderLayout(10, 10)); panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

JLabel icon = new JLabel(UIManager.getIcon("OptionPane.informationIcon"));
icon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 12)); panel.add(icon, BorderLayout.WEST);
 

JTextArea area = new JTextArea( "Name: " + name + "\n" + "Roll No: " + roll + "\n" + "Gender: " + gender + "\n" +
"Hobbies: " + hobbies + "\n" + "Department: " + dept
);
area.setEditable(false); area.setFont(new JLabel().getFont()); panel.add(area, BorderLayout.CENTER);

JButton ok = new JButton("OK"); ok.addActionListener(e -> dispose());
JPanel btn = new JPanel(new FlowLayout(FlowLayout.RIGHT)); btn.add(ok);
panel.add(btn, BorderLayout.SOUTH);

setContentPane(panel); pack(); setLocationRelativeTo(null); setVisible(true);
}
}
