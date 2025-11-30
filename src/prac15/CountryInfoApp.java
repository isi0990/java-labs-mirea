package prac15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountryInfoApp extends JFrame {
    private JComboBox<String> countryComboBox;
    private JLabel infoLabel;

    public CountryInfoApp() {
        super("Country Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        String[] countries = {"Germany", "Norway", "Russia", "China"};
        countryComboBox = new JComboBox<>(countries);

        infoLabel = new JLabel("Select a country");

        countryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryComboBox.getSelectedItem();
                String info = getCountryInfo(selectedCountry);
                infoLabel.setText(info);
            }
        });

        add(new JLabel("Countries: "));
        add(countryComboBox);
        add(infoLabel);

        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String getCountryInfo(String country) {
        switch (country) {
            case "Germany":
                return "Столица: Берлин; Население: 83,8 млн.";
            case "China":
                return "Столица: Пекин; Население: 1,4 млрд.";
            case "Russia":
                return "Столица: Москва; Население: 144 млн.";
            case "Norway":
                return "Столица: Осло; Население: 5,5 млн.";
            default:
                return "Информация отсутствует";
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CountryInfoApp();
            }
        });
    }
}
