import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RPGCharacterGUI {

    /*
    Make a GUI for your RPG Character builder you made in the last Unit. The user should enter primary stats in input box and the GUI
    should display the character's battle stats. The GUI should have at least 4 label, 4 inputs and a button to click which calculates and displays
    the battle stats.
     */

    static JTextField inputStrengthField, inputDurabilityField, inputBulkField, inputIntelligenceField, inputManaField, inputLevelField, inputNameField;
    static JLabel attackResultLabel, defenseResultLabel, hpResultLabel, mpResultLabel, nameResultLabel;

    public RPGCharacterGUI() {

        JFrame window = new JFrame("RPG Character");
        JPanel panel = new JPanel();

        JLabel strengthLabel = new JLabel("Enter your STRENGTH level: ");
        JLabel durabilityLabel = new JLabel("Enter your DURABILITY level: ");
        JLabel bulkLabel = new JLabel("Enter your BULK level: ");
        JLabel intelligenceLabel = new JLabel("Enter your INTELLIGENCE level: ");
        JLabel manaLabel = new JLabel("Enter your MANA level: ");
        JLabel levelLabel = new JLabel("Enter your LEVEL (INTEGER): ");
        JLabel nameLabel = new JLabel("Enter your NAME: ");
        inputStrengthField = new JTextField(15);
        inputDurabilityField = new JTextField(15);
        inputBulkField = new JTextField(15);
        inputIntelligenceField = new JTextField(15);
        inputManaField = new JTextField(15);
        inputLevelField = new JTextField(15);
        inputNameField = new JTextField(15);

        JButton buttonCalc = new JButton("Calculate Your Stats!");

        JLabel attackLabel = new JLabel("ATTACK STAT: ");
        JLabel defenseLabel = new JLabel("DEFENSE STAT: ");
        JLabel hpLabel = new JLabel("HP STAT: ");
        JLabel mpLabel = new JLabel("MP STAT: ");
        JLabel name2Label = new JLabel("YOUR NAME: ");
        attackResultLabel = new JLabel("00.00");
        defenseResultLabel = new JLabel("00.00");
        hpResultLabel = new JLabel("00.00");
        mpResultLabel = new JLabel("00.00");
        nameResultLabel = new JLabel("");

        window.setSize(275, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        buttonCalc.addActionListener(new ButtonCalcListener());

        panel.add(strengthLabel);
        panel.add(inputStrengthField);
        panel.add(durabilityLabel);
        panel.add(inputDurabilityField);
        panel.add(bulkLabel);
        panel.add(inputBulkField);
        panel.add(intelligenceLabel);
        panel.add(inputIntelligenceField);
        panel.add(manaLabel);
        panel.add(inputManaField);
        panel.add(levelLabel);
        panel.add(inputLevelField);
        panel.add(nameLabel);
        panel.add(inputNameField);

        panel.add(attackLabel);
        panel.add(attackResultLabel);
        panel.add(defenseLabel);
        panel.add(defenseResultLabel);
        panel.add(hpLabel);
        panel.add(hpResultLabel);
        panel.add(mpLabel);
        panel.add(mpResultLabel);
        panel.add(name2Label);
        panel.add(nameResultLabel);

        panel.add(buttonCalc);

        window.add(panel);

        window.setVisible(true);

    }

    private static class ButtonCalcListener implements ActionListener {

        public void actionPerformed(ActionEvent e){

            DecimalFormat roundTo2 = new DecimalFormat(("0.00"));

            double strengthStat = Double.parseDouble(inputStrengthField.getText());
            double durabilityStat = Double.parseDouble(inputDurabilityField.getText());
            double bulkStat = Double.parseDouble(inputBulkField.getText());
            double intelligenceStat = Double.parseDouble(inputIntelligenceField.getText());
            double manaStat = Double.parseDouble(inputManaField.getText());
            double levelStat = Integer.parseInt(inputLevelField.getText());
            String name = inputNameField.getText();

            double defenseStat = (((((durabilityStat + bulkStat) * 2) + (Math.sqrt(durabilityStat*bulkStat)) * levelStat)/100) + levelStat + 5);

            attackResultLabel.setText(String.valueOf(roundTo2.format(((((strengthStat + bulkStat) * 2) + (Math.sqrt(strengthStat*bulkStat)) * levelStat)/100) + levelStat + 5)));
            defenseResultLabel.setText(String.valueOf(roundTo2.format(((((durabilityStat + bulkStat) * 2) + (Math.sqrt(durabilityStat*bulkStat)) * levelStat)/100) + levelStat + 5)));
            hpResultLabel.setText(String.valueOf(roundTo2.format(((((defenseStat + defenseStat) * 2) + (Math.sqrt(defenseStat*defenseStat)) * levelStat)/100) + levelStat + 10)));
            mpResultLabel.setText(String.valueOf(roundTo2.format(((((intelligenceStat + manaStat) * 2) + (Math.sqrt(intelligenceStat*manaStat)) * levelStat)/100) + levelStat + 10)));
            nameResultLabel.setText(name);

        }

    }

}
