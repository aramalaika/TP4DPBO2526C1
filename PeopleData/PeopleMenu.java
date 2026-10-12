import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class PeopleMenu {
    private JPanel mainPanel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField tahuField;
    private JComboBox kategoriComboBox;
    private JComboBox jeniskelaminComboBox;
    private JButton tambahButton;
    private JButton updateButton;
    private JButton hapusButton;
    private JButton clearButton;
    private JTable peopleTable;
    private JLabel judulLabel;

    private ArrayList<Person> peopleList;

    public PeopleMenu() {
        peopleList = new ArrayList<>();

        kategoriComboBox.addItem("Mahasiswa");
        kategoriComboBox.addItem("Dosen");
        kategoriComboBox.addItem("Alumni");

        jeniskelaminComboBox.addItem("Laki-laki");
        jeniskelaminComboBox.addItem("Perempuan");

        populateList();
        setTable();

        tambahButton.addActionListener(e -> insertData());
        updateButton.addActionListener(e -> updateData());
        hapusButton.addActionListener(e -> deleteData());
        clearButton.addActionListener(e -> clearForm());

        peopleTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = peopleTable.getSelectedRow();

                if (row != -1) {
                    idField.setText(peopleTable.getValueAt(row, 0).toString());
                    nameField.setText(peopleTable.getValueAt(row, 1).toString());
                    tahuField.setText(peopleTable.getValueAt(row, 2).toString());
                    kategoriComboBox.setSelectedItem(peopleTable.getValueAt(row, 3).toString());
                    jeniskelaminComboBox.setSelectedItem(peopleTable.getValueAt(row, 4).toString());

                    idField.setEditable(false);
                }
            }
        });

        // Font Poppins
                Font poppins = new Font("Poppins", Font.PLAIN, 14);
                Font poppinsBold = new Font("Poppins", Font.BOLD, 14);
                Font poppinsTitle = new Font("Poppins", Font.BOLD, 24);

        // Font untuk judul
        judulLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        judulLabel.setForeground(new Color(80, 50, 60));

        // Font untuk teks input
                idField.setFont(poppins);
                nameField.setFont(poppins);
                tahuField.setFont(poppins);

        // Font untuk tombol CRUD
                tambahButton.setFont(poppinsBold);
                updateButton.setFont(poppinsBold);
                hapusButton.setFont(poppinsBold);
                clearButton.setFont(poppinsBold);

        // Font untuk pilihan kategori dan jenis kelamin
                kategoriComboBox.setFont(poppins);
                jeniskelaminComboBox.setFont(poppins);

        // Font header tabel
                peopleTable.getTableHeader().setFont(poppinsBold);

        // Font isi tabel
                peopleTable.setFont(poppins);

        // Warna background utama
        mainPanel.setBackground(new Color(255, 247, 240));

        // Tombol tambah - soft pink
                tambahButton.setBackground(new Color(248, 200, 220));
                tambahButton.setForeground(new Color(80, 50, 60));
                tambahButton.setOpaque(true);
                tambahButton.setBorderPainted(false);

        // Tombol update - butter yellow
                updateButton.setBackground(new Color(249, 231, 162));
                updateButton.setForeground(new Color(80, 65, 40));
                updateButton.setOpaque(true);
                updateButton.setBorderPainted(false);

        // Tombol hapus - rose pink
                hapusButton.setBackground(new Color(236, 165, 194));
                hapusButton.setForeground(new Color(80, 40, 55));
                hapusButton.setOpaque(true);
                hapusButton.setBorderPainted(false);

        peopleTable.setBackground(new Color(255, 247, 240));
        peopleTable.setForeground(new Color(80, 50, 60));

        peopleTable.getTableHeader()
                .setBackground(new Color(249, 231, 162));

        peopleTable.getTableHeader()
                .setForeground(new Color(80, 65, 40));
    }

    public void populateList() {
        peopleList.add(new Person(1, "Ara", 2006, "Mahasiswa", "Perempuan"));
        peopleList.add(new Person(2, "Budi", 2005, "Mahasiswa", "Laki-laki"));
        peopleList.add(new Person(3, "Citra", 2004, "Alumni", "Perempuan"));
    }

    public void setTable() {
        String[] columnNames = {
                "ID", "Nama", "Tahun Lahir", "Kategori", "Jenis Kelamin"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Person person : peopleList) {
            Object[] rowData = {
                    person.getId(),
                    person.getNama(),
                    person.getTahunLahir(),
                    person.getKategori(),
                    person.getJenisKelamin()
            };

            model.addRow(rowData);
        }

        peopleTable.setModel(model);
    }

    public void insertData() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String nama = nameField.getText().trim();
            int tahun = Integer.parseInt(tahuField.getText().trim());
            String kategori = kategoriComboBox.getSelectedItem().toString();
            String jenisKelamin = jeniskelaminComboBox.getSelectedItem().toString();

            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Nama tidak boleh kosong!");
                return;
            }

            for (Person person : peopleList) {
                if (person.getId() == id) {
                    JOptionPane.showMessageDialog(mainPanel, "ID sudah digunakan!");
                    return;
                }
            }

            peopleList.add(new Person(id, nama, tahun, kategori, jenisKelamin));
            setTable();
            clearForm();

            JOptionPane.showMessageDialog(mainPanel, "Data berhasil ditambahkan!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel, "ID dan tahun lahir harus berupa angka!");
        }
    }

    public void updateData() {
        int row = peopleTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(mainPanel, "Pilih data yang ingin diubah!");
            return;
        }

        try {
            String nama = nameField.getText().trim();
            int tahun = Integer.parseInt(tahuField.getText().trim());
            String kategori = kategoriComboBox.getSelectedItem().toString();
            String jenisKelamin = jeniskelaminComboBox.getSelectedItem().toString();
            int id = Integer.parseInt(idField.getText().trim());

            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Nama tidak boleh kosong!");
                return;
            }

            for (Person person : peopleList) {
                if (person.getId() == id) {
                    person.setNama(nama);
                    person.setTahunLahir(tahun);
                    person.setKategori(kategori);
                    person.setJenisKelamin(jenisKelamin);
                    break;
                }
            }

            setTable();
            clearForm();

            JOptionPane.showMessageDialog(mainPanel, "Data berhasil diubah!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainPanel, "Tahun lahir harus berupa angka!");
        }
    }

    public void deleteData() {
        int row = peopleTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(mainPanel, "Pilih data yang ingin dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                mainPanel,
                "Apakah kamu yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(peopleTable.getValueAt(row, 0).toString());

            peopleList.removeIf(person -> person.getId() == id);

            setTable();
            clearForm();

            JOptionPane.showMessageDialog(mainPanel, "Data berhasil dihapus!");
        }
    }

    public void clearForm() {
        idField.setText("");
        nameField.setText("");
        tahuField.setText("");
        kategoriComboBox.setSelectedIndex(0);
        jeniskelaminComboBox.setSelectedIndex(0);
        idField.setEditable(true);
        peopleTable.clearSelection();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PeopleData");

        PeopleMenu peopleMenu = new PeopleMenu();

        frame.setContentPane(peopleMenu.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
