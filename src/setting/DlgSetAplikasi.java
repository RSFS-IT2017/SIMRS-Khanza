/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgAdmin.java
 *
 * Created on 21 Jun 10, 20:53:44
 */

package setting;

import bridging.BPJSCekReferensiFaskes;
import fungsi.koneksiDB;
import fungsi.*;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author perpustakaan
 */
public class DlgSetAplikasi extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private BPJSCekReferensiFaskes bpjs=new BPJSCekReferensiFaskes(null,false);

    /** Creates new form DlgAdmin
     * @param parent
     * @param modal */
    public DlgSetAplikasi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(10,10);
        setSize(457,249);

        Object[] row={"Nama Toko","Alamat Toko","Kota","Propinsi","Aktifkan?","Wallpaper","KontaK","Email","Logo","Kode PPK BPJS","Nama PPK BPJS"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };

        tbAdmin.setModel(tabMode);
        //tampil();
        //tbJabatan.setDefaultRenderer(Object.class, new WarnaTable(Scroll.getBackground(),Color.GREEN));
        tbAdmin.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbAdmin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 11; i++) {
            TableColumn column = tbAdmin.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(150);
            }else{
                column.setPreferredWidth(150);
            }
        }

        tbAdmin.setDefaultRenderer(Object.class, new WarnaTable());

        Nm.setDocument(new batasInput((byte)60).getKata(Nm));
        Almt.setDocument(new batasInput((byte)50).getKata(Almt));
        Kota.setDocument(new batasInput((byte)30).getKata(Kota));
        Propinsi.setDocument(new batasInput((byte)30).getKata(Propinsi));
        Kontak.setDocument(new batasInput((byte)50).getKata(Kontak));
        Email.setDocument(new batasInput((byte)50).getKata(Email));
        kdPPK.setDocument(new batasInput((byte)15).getKata(kdPPK));
        bpjs.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(bpjs.getTable().getSelectedRow()!= -1){                   
                    kdPPK.setText(bpjs.getTable().getValueAt(bpjs.getTable().getSelectedRow(),3).toString());
                    NmPPK.setText(bpjs.getTable().getValueAt(bpjs.getTable().getSelectedRow(),4).toString());
                }  
                kdPPK.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        bpjs.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    bpjs.dispose();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });  
    }
    Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    private javax.swing.JFileChooser jfc = new JFileChooser();    
    private javax.swing.JFileChooser jfc2 = new JFileChooser();
    private FileFilter jpgFilter = new FileNameExtensionFilter("Gambar JPEG", "jpg");
    private FileFilter gifFilter = new FileNameExtensionFilter("Gambar GIF", "gif");
    private FileFilter pngFilter = new FileNameExtensionFilter("Gambar PNG", "png");
    private FileFilter bothFilter = new FileNameExtensionFilter("Gambar JPEG dan GIF dan PNG", "jpg", "gif", "png");

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbAdmin = new widget.Table();
        panelisi1 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass1 = new widget.panelGlass();
        label35 = new widget.Label();
        Nm = new widget.TextBox();
        label34 = new widget.Label();
        Almt = new widget.TextBox();
        label36 = new widget.Label();
        Kota = new widget.TextBox();
        label37 = new widget.Label();
        Propinsi = new widget.TextBox();
        scrollPane2 = new widget.ScrollPane();
        PhotoGambar = new Painter();
        BtnCariGb = new widget.Button();
        EGb = new widget.TextBox();
        label38 = new widget.Label();
        label12 = new widget.Label();
        YesNo = new widget.ComboBox();
        label39 = new widget.Label();
        Kontak = new widget.TextBox();
        label40 = new widget.Label();
        Email = new widget.TextBox();
        scrollPane3 = new widget.ScrollPane();
        PhotoLogo = new Painter();
        label41 = new widget.Label();
        ELogo = new widget.TextBox();
        BtnCariLogo = new widget.Button();
        label42 = new widget.Label();
        kdPPK = new widget.TextBox();
        NmPPK = new widget.TextBox();
        BtnPPK = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Setup Aplikasi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbAdmin.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbAdmin.setName("tbAdmin"); // NOI18N
        tbAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAdminMouseClicked(evt);
            }
        });
        tbAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbAdminKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbAdmin);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(100, 54));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelisi1.add(BtnSimpan);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelisi1.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelisi1.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setIconTextGap(3);
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelisi1.add(BtnEdit);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        internalFrame1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        panelGlass1.setName("panelGlass1"); // NOI18N
        panelGlass1.setPreferredSize(new java.awt.Dimension(200, 282));
        panelGlass1.setLayout(null);

        label35.setText("Nama RS :");
        label35.setName("label35"); // NOI18N
        label35.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label35);
        label35.setBounds(0, 10, 70, 23);

        Nm.setHighlighter(null);
        Nm.setName("Nm"); // NOI18N
        Nm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmKeyPressed(evt);
            }
        });
        panelGlass1.add(Nm);
        Nm.setBounds(75, 10, 220, 23);

        label34.setText("Alamat RS :");
        label34.setName("label34"); // NOI18N
        label34.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label34);
        label34.setBounds(0, 40, 70, 23);

        Almt.setName("Almt"); // NOI18N
        Almt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AlmtKeyPressed(evt);
            }
        });
        panelGlass1.add(Almt);
        Almt.setBounds(75, 40, 220, 23);

        label36.setText("Kota :");
        label36.setName("label36"); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label36);
        label36.setBounds(0, 70, 70, 23);

        Kota.setName("Kota"); // NOI18N
        Kota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KotaKeyPressed(evt);
            }
        });
        panelGlass1.add(Kota);
        Kota.setBounds(75, 70, 220, 23);

        label37.setText("Wallpaper :");
        label37.setName("label37"); // NOI18N
        label37.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label37);
        label37.setBounds(0, 130, 70, 23);

        Propinsi.setName("Propinsi"); // NOI18N
        Propinsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PropinsiKeyPressed(evt);
            }
        });
        panelGlass1.add(Propinsi);
        Propinsi.setBounds(75, 100, 220, 23);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane2.setName("scrollPane2"); // NOI18N

        PhotoGambar.setBackground(new java.awt.Color(245, 255, 235));
        PhotoGambar.setForeground(new java.awt.Color(235, 255, 235));
        PhotoGambar.setName("PhotoGambar"); // NOI18N
        scrollPane2.setViewportView(PhotoGambar);

        panelGlass1.add(scrollPane2);
        scrollPane2.setBounds(302, 10, 233, 233);

        BtnCariGb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnCariGb.setMnemonic('C');
        BtnCariGb.setToolTipText("Alt+C");
        BtnCariGb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnCariGb.setName("BtnCariGb"); // NOI18N
        BtnCariGb.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnCariGb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariGbActionPerformed(evt);
            }
        });
        panelGlass1.add(BtnCariGb);
        BtnCariGb.setBounds(270, 130, 25, 23);

        EGb.setEditable(false);
        EGb.setName("EGb"); // NOI18N
        EGb.setPreferredSize(new java.awt.Dimension(207, 23));
        EGb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EGbKeyPressed(evt);
            }
        });
        panelGlass1.add(EGb);
        EGb.setBounds(75, 130, 190, 23);

        label38.setText("Propinsi :");
        label38.setName("label38"); // NOI18N
        label38.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label38);
        label38.setBounds(0, 100, 70, 23);

        label12.setText("Mau Aktifkan Wallpaper ?");
        label12.setName("label12"); // NOI18N
        label12.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass1.add(label12);
        label12.setBounds(0, 160, 220, 23);

        YesNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        YesNo.setName("YesNo"); // NOI18N
        YesNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                YesNoKeyPressed(evt);
            }
        });
        panelGlass1.add(YesNo);
        YesNo.setBounds(225, 160, 70, 23);

        label39.setText("Kontak :");
        label39.setName("label39"); // NOI18N
        label39.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label39);
        label39.setBounds(0, 190, 70, 23);

        Kontak.setName("Kontak"); // NOI18N
        Kontak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KontakKeyPressed(evt);
            }
        });
        panelGlass1.add(Kontak);
        Kontak.setBounds(75, 190, 220, 23);

        label40.setText("Email :");
        label40.setName("label40"); // NOI18N
        label40.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label40);
        label40.setBounds(0, 220, 70, 23);

        Email.setName("Email"); // NOI18N
        Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EmailKeyPressed(evt);
            }
        });
        panelGlass1.add(Email);
        Email.setBounds(75, 220, 220, 23);

        scrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane3.setName("scrollPane3"); // NOI18N

        PhotoLogo.setBackground(new java.awt.Color(245, 255, 235));
        PhotoLogo.setForeground(new java.awt.Color(235, 255, 235));
        PhotoLogo.setName("PhotoLogo"); // NOI18N
        scrollPane3.setViewportView(PhotoLogo);

        panelGlass1.add(scrollPane3);
        scrollPane3.setBounds(550, 40, 233, 203);

        label41.setText("Logo :");
        label41.setName("label41"); // NOI18N
        label41.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label41);
        label41.setBounds(540, 10, 40, 23);

        ELogo.setEditable(false);
        ELogo.setName("ELogo"); // NOI18N
        ELogo.setPreferredSize(new java.awt.Dimension(207, 23));
        ELogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ELogoKeyPressed(evt);
            }
        });
        panelGlass1.add(ELogo);
        ELogo.setBounds(582, 10, 171, 23);

        BtnCariLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnCariLogo.setMnemonic('C');
        BtnCariLogo.setToolTipText("Alt+C");
        BtnCariLogo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnCariLogo.setName("BtnCariLogo"); // NOI18N
        BtnCariLogo.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnCariLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariLogoActionPerformed(evt);
            }
        });
        BtnCariLogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariLogoKeyPressed(evt);
            }
        });
        panelGlass1.add(BtnCariLogo);
        BtnCariLogo.setBounds(757, 10, 25, 23);

        label42.setText("PPK BPJS :");
        label42.setName("label42"); // NOI18N
        label42.setPreferredSize(new java.awt.Dimension(35, 23));
        panelGlass1.add(label42);
        label42.setBounds(0, 250, 70, 23);

        kdPPK.setName("kdPPK"); // NOI18N
        kdPPK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdPPKKeyPressed(evt);
            }
        });
        panelGlass1.add(kdPPK);
        kdPPK.setBounds(75, 250, 110, 23);

        NmPPK.setHighlighter(null);
        NmPPK.setName("NmPPK"); // NOI18N
        panelGlass1.add(NmPPK);
        NmPPK.setBounds(187, 250, 317, 23);

        BtnPPK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnPPK.setMnemonic('X');
        BtnPPK.setToolTipText("Alt+X");
        BtnPPK.setName("BtnPPK"); // NOI18N
        BtnPPK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPPKActionPerformed(evt);
            }
        });
        BtnPPK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPPKKeyPressed(evt);
            }
        });
        panelGlass1.add(BtnPPK);
        BtnPPK.setBounds(506, 250, 28, 23);

        internalFrame1.add(panelGlass1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmKeyPressed
        Valid.pindah(evt,BtnSimpan,Almt);
}//GEN-LAST:event_NmKeyPressed

    private void AlmtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AlmtKeyPressed
        Valid.pindah(evt,Nm,Kota);
}//GEN-LAST:event_AlmtKeyPressed

    private void tbAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAdminMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbAdminMouseClicked

    private void tbAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAdminKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbAdminKeyPressed

    private void KotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KotaKeyPressed
        Valid.pindah(evt,Almt,Propinsi);
    }//GEN-LAST:event_KotaKeyPressed

    private void PropinsiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PropinsiKeyPressed
        Valid.pindah(evt,Kota,YesNo);
    }//GEN-LAST:event_PropinsiKeyPressed

    private void BtnCariGbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariGbActionPerformed
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.addChoosableFileFilter(jpgFilter);
        jfc.addChoosableFileFilter(gifFilter);
        jfc.addChoosableFileFilter(pngFilter);
        jfc.addChoosableFileFilter(bothFilter);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String f = jfc.getSelectedFile().toString();
            EGb.setText(f);
            //lGambar.setIcon(new ImageIcon(f));
            ((Painter) PhotoGambar).setImage(f);

        }
    }//GEN-LAST:event_BtnCariGbActionPerformed

    private void EGbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EGbKeyPressed
        Valid.pindah(evt,Propinsi,BtnSimpan);
    }//GEN-LAST:event_EGbKeyPressed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if(Nm.getText().trim().equals("")){
            Valid.textKosong(Nm,"Nama Toko");
        }else if(EGb.getText().trim().equals("")){
            YesNo.setSelectedItem("No");
            EGb.setText("./setting/wallpaper.jpg");
        }else if(ELogo.getText().trim().equals("")){
            YesNo.setSelectedItem("No");
            ELogo.setText("./setting/logo.jpg");
        }else if(tabMode.getRowCount()==0){
            Sequel.menyimpan("setting","'"+Nm.getText()+"','"+Almt.getText()+"','"+Kota.getText()+
                             "','"+Propinsi.getText()+"','"+Kontak.getText()+"','"+Email.getText()+
                             "','"+YesNo.getSelectedItem()+"','"+kdPPK.getText()+"','"+NmPPK.getText()+"'","Setting",EGb,ELogo);
            tampil();
        }else if(tabMode.getRowCount()>0){
            JOptionPane.showMessageDialog(null,"Maaf, Hanya diijinkan satu Set Aplikasi...!!!!");
            Nm.requestFocus();
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }else{
            Valid.pindah(evt,Email,BtnBatal);
        }
    }//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            emptTeks();
        }else{Valid.pindah(evt, BtnSimpan, BtnHapus);}
    }//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
            Nm.requestFocus();
        }else if(Nm.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        }else if(! Nm.getText().trim().equals("")){
            Sequel.queryu("delete from setting ");
            tampil();
            emptTeks();
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnHapus);
        }
    }//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
          dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnHapus,BtnSimpan);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void YesNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YesNoKeyPressed
        Valid.pindah(evt, Propinsi,Kontak);
    }//GEN-LAST:event_YesNoKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void KontakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KontakKeyPressed
        Valid.pindah(evt,YesNo,Email);
    }//GEN-LAST:event_KontakKeyPressed

    private void EmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailKeyPressed
        Valid.pindah(evt,Kontak,kdPPK);
    }//GEN-LAST:event_EmailKeyPressed

    private void ELogoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ELogoKeyPressed
        Valid.pindah(evt,kdPPK,BtnSimpan);
    }//GEN-LAST:event_ELogoKeyPressed

    private void BtnCariLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariLogoActionPerformed
        jfc2.setAcceptAllFileFilterUsed(false);
        jfc2.addChoosableFileFilter(jpgFilter);
        jfc2.addChoosableFileFilter(gifFilter);
        jfc2.addChoosableFileFilter(pngFilter);
        jfc2.addChoosableFileFilter(bothFilter);
        if (jfc2.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String f = jfc2.getSelectedFile().toString();
            ELogo.setText(f);
            //lGambar.setIcon(new ImageIcon(f));
            ((Painter) PhotoLogo).setImage(f);

        }
    }//GEN-LAST:event_BtnCariLogoActionPerformed

    private void BtnCariLogoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariLogoKeyPressed
        Valid.pindah(evt,Email,BtnSimpan);
    }//GEN-LAST:event_BtnCariLogoKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if(Nm.getText().trim().equals("")){
            Valid.textKosong(Nm,"Nama Toko");
        }else if(EGb.getText().trim().equals("")){
            YesNo.setSelectedItem("No");
            EGb.setText("./setting/wallpaper.jpg");
        }else if(ELogo.getText().trim().equals("")){
            YesNo.setSelectedItem("No");
            ELogo.setText("./setting/logo.jpg");
        }else{  
            Sequel.queryu("delete from setting ");
            Sequel.menyimpan("setting","'"+Nm.getText()+"','"+Almt.getText()+"','"+Kota.getText()+
                             "','"+Propinsi.getText()+"','"+Kontak.getText()+"','"+Email.getText()+
                             "','"+YesNo.getSelectedItem()+"','"+kdPPK.getText()+"','"+NmPPK.getText()+"'","Setting",EGb,ELogo);
            tampil();
        }
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnKeluar);
        }
    }//GEN-LAST:event_BtnEditKeyPressed

    private void kdPPKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdPPKKeyPressed
        Valid.pindah(evt,Email,BtnCariLogo);
    }//GEN-LAST:event_kdPPKKeyPressed

    private void BtnPPKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPPKActionPerformed
        bpjs.setSize(internalFrame1.getWidth()-40,internalFrame1.getHeight()-40);
        bpjs.setLocationRelativeTo(internalFrame1);        
        bpjs.setVisible(true);
    }//GEN-LAST:event_BtnPPKActionPerformed

    private void BtnPPKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPPKKeyPressed
        Valid.pindah(evt,Email,BtnCariLogo);
    }//GEN-LAST:event_BtnPPKKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgSetAplikasi dialog = new DlgSetAplikasi(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.TextBox Almt;
    private widget.Button BtnBatal;
    private widget.Button BtnCariGb;
    private widget.Button BtnCariLogo;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPPK;
    private widget.Button BtnSimpan;
    private widget.TextBox EGb;
    private widget.TextBox ELogo;
    private widget.TextBox Email;
    private widget.TextBox Kontak;
    private widget.TextBox Kota;
    private widget.TextBox Nm;
    private widget.TextBox NmPPK;
    private java.awt.Canvas PhotoGambar;
    private java.awt.Canvas PhotoLogo;
    private widget.TextBox Propinsi;
    private widget.ScrollPane Scroll;
    private widget.ComboBox YesNo;
    private widget.InternalFrame internalFrame1;
    private widget.TextBox kdPPK;
    private widget.Label label12;
    private widget.Label label34;
    private widget.Label label35;
    private widget.Label label36;
    private widget.Label label37;
    private widget.Label label38;
    private widget.Label label39;
    private widget.Label label40;
    private widget.Label label41;
    private widget.Label label42;
    private widget.panelGlass panelGlass1;
    private widget.panelisi panelisi1;
    private widget.ScrollPane scrollPane2;
    private widget.ScrollPane scrollPane3;
    private widget.Table tbAdmin;
    // End of variables declaration//GEN-END:variables

    private void tampil() {
        String sql="select nama_instansi, alamat_instansi, kabupaten, propinsi, aktifkan, wallpaper,kontak,email,logo,kode_ppk,nama_ppk from setting";
        prosesCari(sql);
    }

    private void prosesCari(String sql) {
        Valid.tabelKosong(tabMode);
        try{
            ResultSet rs=koneksi.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Object[] data={rs.getString(1),rs.getString(2),rs.getString(3),
                               rs.getString(4),rs.getString(5),rs.getBlob(6),
                               rs.getString(7),rs.getString(8),rs.getBlob(9),
                               rs.getString(10),rs.getString(11)
                };
                tabMode.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
    }

    private void getData() {
        int row=tbAdmin.getSelectedRow();
        if(row!= -1){
            Nm.setText(tabMode.getValueAt(row,0).toString());
            Almt.setText(tabMode.getValueAt(row,1).toString());
            Kota.setText(tabMode.getValueAt(row,2).toString());
            Propinsi.setText(tabMode.getValueAt(row,3).toString());
            YesNo.setSelectedItem(tabMode.getValueAt(row,4).toString());
            Kontak.setText(tabMode.getValueAt(row,6).toString());
            Email.setText(tabMode.getValueAt(row,7).toString());
            kdPPK.setText(tabMode.getValueAt(row,9).toString());
            NmPPK.setText(tabMode.getValueAt(row,10).toString());
            try {
                ResultSet hasil = koneksi.createStatement().executeQuery(
                        "select wallpaper,logo from setting");
                for (int I = 0; hasil.next(); I++) {
                    ((Painter) PhotoGambar).setImage(gambar(tabMode.getValueAt(row,0).toString()));
                    Blob blob = hasil.getBlob(1);
                    ((Painter) PhotoGambar).setImageIcon(new javax.swing.ImageIcon(
                        blob.getBytes(1, (int) (blob.length()))));
                    blob.free();
                    
                    ((Painter) PhotoLogo).setImage(gambar(tabMode.getValueAt(row,0).toString()));
                    Blob blob2 = hasil.getBlob(2);
                    ((Painter) PhotoLogo).setImageIcon(new javax.swing.ImageIcon(
                        blob2.getBytes(1, (int) (blob2.length()))));
                    blob2.free();
                }
            } catch (Exception ex) {
                cetak(ex.toString());
            }
        }
    }

    public void emptTeks() {
        Nm.setText("");
        Almt.setText("");
        Kota.setText("");
        Propinsi.setText("");
        kdPPK.setText("");        
        NmPPK.setText("");
        ((Painter) PhotoGambar).setImage("");
        EGb.setText("");
        ((Painter) PhotoLogo).setImage("");
        ELogo.setText("");
        YesNo.setSelectedItem("No");
        Nm.requestFocus();
    }
    
    
    private String gambar(String id) {
        return folder + File.separator + id.trim() + ".jpg";
    }

    private String folder;

    public class Painter extends Canvas {

        Image image;

        public void setImage(String file) {
            URL url = null;
            try {
                url = new File(file).toURI().toURL();
            } catch (MalformedURLException ex) {
                cetak(ex.toString());
            }
            image = getToolkit().getImage(url);
            repaint();
        }
        public void setImageIcon(ImageIcon file) {
            image = file.getImage();
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            try {
                double d = image.getHeight(this) / this.getHeight();
                double w = image.getWidth(this) / d;
                double x = this.getWidth() / 2 - w / 2;
                g.drawImage(image, (int) x, 0, (int) (w), this.getHeight(), this);
            } catch (Exception e) {
            }            
        }
    }
    
    private void cetak(String str) {
        System.out.println(str);
    }
    
}
