/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import models.DetailTransaksi;
import models.Transaksi;
import tools.KoneksiDB;
import tools.JDPaneBg;

/**
 *
 * @author ERIK
 */
public class Home extends javax.swing.JFrame {
    
    Transaksi trans = new Transaksi();
    public static  boolean frBus, frJadwal, frKursi, frLaporan, frSupir, frTiket, frUser;
    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    String vid_user, vnama_user, vpass, vlev_user;
    String sqlselect;

    /**
     * Creates new form Home1
     */
    public Home() {
        initComponents();
        
        mnBar.setVisible(false);
        mnBar.setEnabled(false);
        txtNamaUser.requestFocus(true);
        jpAdmin.setVisible(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        vid_user = txtNamaUser.getText().replaceAll("'", "");
    }
    
    private void aksiLogin(){
        vnama_user = txtNamaUser.getText().replaceAll("'", "");
        vpass = txtPass.getText().replaceAll("'", "");
        
        if (txtNamaUser.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nama user belum diisi!",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            txtNamaUser.requestFocus(true);
        }else if(txtPass.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Password belum diisi!",
                    "Informasi", JOptionPane.INFORMATION_MESSAGE);
            txtPass.requestFocus(true);
        }else{
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqlselect = "select * from tb_user where nama_user='"+vnama_user+"' "
                        +" and password='"+vpass+"' ";
                Statement stat = _Cnn.createStatement();
                ResultSet res = stat.executeQuery(sqlselect);
                if(res.first()){
                    vnama_user = res.getString("nama_user");
                    vid_user = res.getString("id_user");
                    jpLogin.setVisible(false);
                    lblIdNama.setText(vid_user+" - "+vnama_user);
                    jpAdmin.setVisible(true);
                    jpInfo.setVisible(false);
                    mnBar.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(this, "ID. User dan Password salah!",
                            "Informasi", JOptionPane.INFORMATION_MESSAGE);
                }

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "error method aksiLogin() :"+ex);
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpHome = new javax.swing.JDesktopPane();
        jpLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNamaUser = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpAdmin = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblIdNama = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jpInfo = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnClose2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        mnBar = new javax.swing.JMenuBar();
        mnSistem = new javax.swing.JMenu();
        mnUser = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnKeluar = new javax.swing.JMenuItem();
        mnMaster = new javax.swing.JMenu();
        mnJadwal = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnSupir = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnBus = new javax.swing.JMenuItem();
        mnKursi = new javax.swing.JMenuItem();
        mnTiket = new javax.swing.JMenu();
        nmTiket = new javax.swing.JMenuItem();
        nmLaporan = new javax.swing.JMenu();
        mnLaporan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyBus v.1.0");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/source/Bus_30px_1.png")).getImage());
        setSize(new java.awt.Dimension(1366, 768));

        jpHome.setBackground(new java.awt.Color(51, 51, 51));
        jpHome = new JDPaneBg();

        jpLogin.setBackground(new java.awt.Color(106, 27, 154));

        jLabel2.setFont(new java.awt.Font("Baloo", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MyBus");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Bus_100px_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Versi 1.0");

        jPanel1.setBackground(new java.awt.Color(156, 42, 225));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(106, 27, 154), 1, true)));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama User");

        txtNamaUser.setBackground(new java.awt.Color(156, 42, 225));
        txtNamaUser.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        txtNamaUser.setForeground(new java.awt.Color(255, 255, 255));
        txtNamaUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNamaUser.setBorder(null);
        txtNamaUser.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNamaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNamaUser.setOpaque(false);
        txtNamaUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamaUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNamaUserFocusLost(evt);
            }
        });
        txtNamaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaUserActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kata Sandi");

        txtPass.setBackground(new java.awt.Color(156, 42, 225));
        txtPass.setFont(new java.awt.Font("Ubuntu Condensed", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPass.setBorder(null);
        txtPass.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPass.setOpaque(false);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/ic_person_white_48dp.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(21, 184, 90));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(21, 184, 90));
        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/ic_lock_open_white_18dp.png"))); // NOI18N
        jLabel15.setText("Masuk");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel15)
                .addGap(5, 5, 5))
        );

        jPanel5.setBackground(new java.awt.Color(240, 50, 95));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/ic_cancel_white_18dp.png"))); // NOI18N
        jLabel13.setText("Batal");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel13)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3)
                                .addComponent(txtNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(txtNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/bus_1.png"))); // NOI18N

        jpAdmin.setBackground(new java.awt.Color(156, 42, 225));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/ic_person_white_48dp.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Selamat Datang");

        lblIdNama.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblIdNama.setForeground(new java.awt.Color(255, 255, 255));
        lblIdNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdNama.setText("ID - Nama User");

        jPanel4.setBackground(new java.awt.Color(106, 27, 154));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/ic_cancel_white_18dp.png"))); // NOI18N
        btnClose.setToolTipText("Tutup Info");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(2, 2, 2))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(btnClose)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jpAdminLayout = new javax.swing.GroupLayout(jpAdmin);
        jpAdmin.setLayout(jpAdminLayout);
        jpAdminLayout.setHorizontalGroup(
            jpAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAdminLayout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpAdminLayout.setVerticalGroup(
            jpAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAdminLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(2, 2, 2)
                .addComponent(lblIdNama)
                .addGap(16, 16, 16))
        );

        jpInfo.setBackground(new java.awt.Color(156, 42, 225));

        jPanel7.setBackground(new java.awt.Color(106, 27, 154));

        btnClose2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/ic_cancel_white_18dp.png"))); // NOI18N
        btnClose2.setToolTipText("Tutup Info");
        btnClose2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClose2MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("MyBus App");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose2)
                .addGap(2, 2, 2))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(btnClose2))
                .addGap(2, 2, 2))
        );

        jLabel16.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MyBus App adalah sistem informasi penjualan tiket bus di pool Sinar Jaya terminal Kajen");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("yang dibuat oleh kelompok 4 dengan anggota :");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("2. Dewi Sakinah (161530006)");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("3. Erik Wibowo (161530009)");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("1. Afrizal Ahmed A (161530001)");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("4. Qomariyah (161530018)");

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInfoLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(5, 5, 5)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(1, 1, 1)
                .addComponent(jLabel22)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jpHome.setLayer(jpLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpHome.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpHome.setLayer(jpAdmin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpHome.setLayer(jpInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addComponent(jpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHomeLayout.createSequentialGroup()
                        .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHomeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        mnBar.setBackground(new java.awt.Color(106, 27, 154));
        mnBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mnBar.setForeground(new java.awt.Color(255, 255, 255));
        mnBar.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnBar.setOpaque(false);

        mnSistem.setBackground(new java.awt.Color(255, 255, 255));
        mnSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Windows Phone Store_30px.png"))); // NOI18N
        mnSistem.setText("Sistem");
        mnSistem.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnSistem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSistemActionPerformed(evt);
            }
        });

        mnUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mnUser.setBackground(new java.awt.Color(255, 255, 255));
        mnUser.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Person_30px_1.png"))); // NOI18N
        mnUser.setText("Data User");
        mnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUserActionPerformed(evt);
            }
        });
        mnSistem.add(mnUser);
        mnSistem.add(jSeparator1);

        mnKeluar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnKeluar.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Exit_30px_1.png"))); // NOI18N
        mnKeluar.setText("Keluar");
        mnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKeluarActionPerformed(evt);
            }
        });
        mnSistem.add(mnKeluar);

        mnBar.add(mnSistem);

        mnMaster.setBackground(new java.awt.Color(255, 255, 255));
        mnMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Data Grid_30px_1.png"))); // NOI18N
        mnMaster.setText("Master");
        mnMaster.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        mnJadwal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        mnJadwal.setBackground(new java.awt.Color(255, 255, 255));
        mnJadwal.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnJadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Calendar_30px_1.png"))); // NOI18N
        mnJadwal.setText("Data Jadwal");
        mnJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJadwalActionPerformed(evt);
            }
        });
        mnMaster.add(mnJadwal);
        mnMaster.add(jSeparator2);

        mnSupir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnSupir.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnSupir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Driver_30px_1.png"))); // NOI18N
        mnSupir.setText("Data Supir");
        mnSupir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSupirActionPerformed(evt);
            }
        });
        mnMaster.add(mnSupir);
        mnMaster.add(jSeparator5);

        mnBus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        mnBus.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnBus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Bus_30px_1.png"))); // NOI18N
        mnBus.setText("Data Bus");
        mnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBusActionPerformed(evt);
            }
        });
        mnMaster.add(mnBus);

        mnKursi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        mnKursi.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnKursi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Barber Chair_30px.png"))); // NOI18N
        mnKursi.setText("Data Kursi");
        mnKursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKursiActionPerformed(evt);
            }
        });
        mnMaster.add(mnKursi);

        mnBar.add(mnMaster);

        mnTiket.setBackground(new java.awt.Color(255, 255, 255));
        mnTiket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Ticket_30px_1.png"))); // NOI18N
        mnTiket.setText("Tiket");
        mnTiket.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        nmTiket.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        nmTiket.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        nmTiket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Ticket_30px_1.png"))); // NOI18N
        nmTiket.setText("Penjualan Tiket");
        nmTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmTiketActionPerformed(evt);
            }
        });
        mnTiket.add(nmTiket);

        mnBar.add(mnTiket);

        nmLaporan.setBackground(new java.awt.Color(255, 255, 255));
        nmLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/News_30px_1.png"))); // NOI18N
        nmLaporan.setText("Laporan");
        nmLaporan.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        nmLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmLaporanActionPerformed(evt);
            }
        });

        mnLaporan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        mnLaporan.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        mnLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/News_30px_1.png"))); // NOI18N
        mnLaporan.setText("Cetak Laporan Penjualan Tiket");
        mnLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLaporanActionPerformed(evt);
            }
        });
        nmLaporan.add(mnLaporan);

        mnBar.add(nmLaporan);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJadwalActionPerformed
        if (frJadwal == false) {
            IfrJadwal fr = new IfrJadwal();
            frJadwal = true;
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnJadwalActionPerformed

    private void mnSupirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSupirActionPerformed
        if (frSupir == false) {
            frSupir = true;
            IfrSupir fr = new IfrSupir();
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnSupirActionPerformed

    private void mnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBusActionPerformed
        if (frBus == false) {
            frBus = true;
            IfrBus fr = new IfrBus();
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnBusActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        aksiLogin();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        aksiLogin();
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost

    }//GEN-LAST:event_txtPassFocusLost

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained

    }//GEN-LAST:event_txtPassFocusGained

    private void txtNamaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaUserActionPerformed
        txtPass.requestFocus(true);
    }//GEN-LAST:event_txtNamaUserActionPerformed

    private void txtNamaUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaUserFocusLost

    }//GEN-LAST:event_txtNamaUserFocusLost

    private void txtNamaUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamaUserFocusGained

    }//GEN-LAST:event_txtNamaUserFocusGained

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        jpAdmin.setVisible(false);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void mnKursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKursiActionPerformed
        if (frKursi == false) {
            frKursi = true;
            IfrKursi fr = new IfrKursi();
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnKursiActionPerformed

    private void btnClose2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClose2MouseClicked
        jpInfo.setVisible(false);
    }//GEN-LAST:event_btnClose2MouseClicked

    private void mnSistemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSistemActionPerformed
        jpInfo.setVisible(true);
        jpHome.add(jpInfo);
    }//GEN-LAST:event_mnSistemActionPerformed

    private void mnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUserActionPerformed
        if (frUser == false) {
            frUser = true;
            IfrUser fr = new IfrUser();
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnUserActionPerformed

    private void nmLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmLaporanActionPerformed
        if (frLaporan == false) {
            frLaporan = true;
            IfrLaporan fr = new IfrLaporan();
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_nmLaporanActionPerformed

    private void nmTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmTiketActionPerformed
        if (frTiket == false) {
            frTiket = true;
            IfrTiket fr = new IfrTiket(vid_user);
            jpHome.add(fr);
            fr.setVisible(true);
            try {
                fr.setMaximum(true);
            } catch (PropertyVetoException e) {
                // Vetoed by internalFrame
                // ... possibly add some handling for this case
            }
        }
    }//GEN-LAST:event_nmTiketActionPerformed

    private void mnLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLaporanActionPerformed
        if (frLaporan == false) {
            frLaporan = true;
            IfrLaporan fr = new IfrLaporan();
            jpHome.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnLaporanActionPerformed

    private void mnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKeluarActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan keluar dari sistem?", "Informasi",
                JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            mnBar.setVisible(false);
            System.exit(0);
        }
    }//GEN-LAST:event_mnKeluarActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        txtNamaUser.setText("");
        txtNamaUser.requestFocus(true);
        txtPass.setText("");
    }//GEN-LAST:event_jPanel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnClose2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPanel jpAdmin;
    private javax.swing.JDesktopPane jpHome;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JLabel lblIdNama;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JMenuItem mnBus;
    private javax.swing.JMenuItem mnJadwal;
    private javax.swing.JMenuItem mnKeluar;
    private javax.swing.JMenuItem mnKursi;
    private javax.swing.JMenuItem mnLaporan;
    private javax.swing.JMenu mnMaster;
    private javax.swing.JMenu mnSistem;
    private javax.swing.JMenuItem mnSupir;
    private javax.swing.JMenu mnTiket;
    private javax.swing.JMenuItem mnUser;
    private javax.swing.JMenu nmLaporan;
    private javax.swing.JMenuItem nmTiket;
    private javax.swing.JTextField txtNamaUser;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
