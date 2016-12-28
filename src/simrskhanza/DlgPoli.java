/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgPenyakit.java
 *
 * Created on May 23, 2010, 12:57:16 AM
 */

package simrskhanza;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.var;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dosen
 */
public final class DlgPoli extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Connection koneksi=koneksiDB.condb();
    private int i=0;
    private PreparedStatement stat;
    private ResultSet rs;
    /** Creates new form DlgPenyakit
     * @param parent
     * @param modal */
    public DlgPoli(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(10,2);
        setSize(628,674);

        Object[] row={"P","Kode Unit","Nama Unit","Registrasi Baru","Registrasi Lama"};
        tabMode=new DefaultTableModel(null,row){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbKamar.setModel(tabMode);
        //tbPenyakit.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbPenyakit.getBackground()));
        tbKamar.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbKamar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 5; i++) {
            TableColumn column = tbKamar.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(25);
            }else if(i==1){
                column.setPreferredWidth(90);
            }else if(i==2){
                column.setPreferredWidth(250);
            }else if(i==3){
                column.setPreferredWidth(120);
            }else if(i==4){
                column.setPreferredWidth(120);
            }
        }
        tbKamar.setDefaultRenderer(Object.class, new WarnaTable());
        
        Kd.setDocument(new batasInput((byte)5).getKata(Kd));
        By.setDocument(new batasInput((byte)13).getOnlyAngka(By));
        ByLm.setDocument(new batasInput((byte)13).getOnlyAngka(ByLm));
        Nm.setDocument(new batasInput((byte)30).getKata(Nm));
        TCari.setDocument(new batasInput((byte)100).getKata(TCari));        
        if(koneksiDB.cariCepat().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {tampil(" order by kd_poli");}
                @Override
                public void removeUpdate(DocumentEvent e) {tampil(" order by kd_poli");}
                @Override
                public void changedUpdate(DocumentEvent e) {tampil(" order by kd_poli");}
            });
        }  
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Popup = new javax.swing.JPopupMenu();
        ppSimpan = new javax.swing.JMenuItem();
        ppGanti = new javax.swing.JMenuItem();
        ppHapus = new javax.swing.JMenuItem();
        ppCetak = new javax.swing.JMenuItem();
        ppOrder = new javax.swing.JMenu();
        ppOrderKode = new javax.swing.JMenuItem();
        ppOrderNama = new javax.swing.JMenuItem();
        ppOrderKtg = new javax.swing.JMenuItem();
        Kd2 = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbKamar = new widget.Table();
        panelisi4 = new widget.panelisi();
        label34 = new widget.Label();
        label32 = new widget.Label();
        Kd = new widget.TextBox();
        By = new widget.TextBox();
        label36 = new widget.Label();
        Nm = new widget.TextBox();
        label33 = new widget.Label();
        ByLm = new widget.TextBox();
        jPanel1 = new javax.swing.JPanel();
        panelisi3 = new widget.panelisi();
        label9 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();
        label10 = new widget.Label();
        LCount = new widget.Label();
        panelisi1 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();

        Popup.setName("Popup"); // NOI18N

        ppSimpan.setBackground(new java.awt.Color(242, 242, 242));
        ppSimpan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppSimpan.setForeground(new java.awt.Color(102, 51, 0));
        ppSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        ppSimpan.setText("Simpan");
        ppSimpan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppSimpan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppSimpan.setIconTextGap(8);
        ppSimpan.setName("ppSimpan"); // NOI18N
        ppSimpan.setPreferredSize(new java.awt.Dimension(150, 25));
        ppSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        Popup.add(ppSimpan);

        ppGanti.setBackground(new java.awt.Color(242, 242, 242));
        ppGanti.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppGanti.setForeground(new java.awt.Color(102, 51, 0));
        ppGanti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        ppGanti.setText("Ganti");
        ppGanti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppGanti.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppGanti.setIconTextGap(8);
        ppGanti.setName("ppGanti"); // NOI18N
        ppGanti.setPreferredSize(new java.awt.Dimension(150, 25));
        ppGanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        Popup.add(ppGanti);

        ppHapus.setBackground(new java.awt.Color(242, 242, 242));
        ppHapus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppHapus.setForeground(new java.awt.Color(102, 51, 0));
        ppHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        ppHapus.setText("Hapus");
        ppHapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppHapus.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppHapus.setIconTextGap(8);
        ppHapus.setName("ppHapus"); // NOI18N
        ppHapus.setPreferredSize(new java.awt.Dimension(150, 25));
        ppHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        Popup.add(ppHapus);

        ppCetak.setBackground(new java.awt.Color(242, 242, 242));
        ppCetak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppCetak.setForeground(new java.awt.Color(102, 51, 0));
        ppCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        ppCetak.setText("Cetak");
        ppCetak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppCetak.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppCetak.setIconTextGap(8);
        ppCetak.setName("ppCetak"); // NOI18N
        ppCetak.setPreferredSize(new java.awt.Dimension(150, 25));
        ppCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        Popup.add(ppCetak);

        ppOrder.setBackground(new java.awt.Color(242, 242, 242));
        ppOrder.setForeground(new java.awt.Color(102, 51, 0));
        ppOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        ppOrder.setText("Urutkan Berdasar");
        ppOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppOrder.setIconTextGap(8);
        ppOrder.setName("ppOrder"); // NOI18N

        ppOrderKode.setBackground(new java.awt.Color(242, 242, 242));
        ppOrderKode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppOrderKode.setForeground(new java.awt.Color(102, 51, 0));
        ppOrderKode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        ppOrderKode.setText("Kode Unit");
        ppOrderKode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppOrderKode.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppOrderKode.setIconTextGap(8);
        ppOrderKode.setName("ppOrderKode"); // NOI18N
        ppOrderKode.setPreferredSize(new java.awt.Dimension(150, 25));
        ppOrderKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppOrderKodeActionPerformed(evt);
            }
        });
        ppOrder.add(ppOrderKode);

        ppOrderNama.setBackground(new java.awt.Color(242, 242, 242));
        ppOrderNama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppOrderNama.setForeground(new java.awt.Color(102, 51, 0));
        ppOrderNama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        ppOrderNama.setText("Nama Unit");
        ppOrderNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppOrderNama.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppOrderNama.setIconTextGap(8);
        ppOrderNama.setName("ppOrderNama"); // NOI18N
        ppOrderNama.setPreferredSize(new java.awt.Dimension(150, 25));
        ppOrderNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppOrderNamaActionPerformed(evt);
            }
        });
        ppOrder.add(ppOrderNama);

        ppOrderKtg.setBackground(new java.awt.Color(242, 242, 242));
        ppOrderKtg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ppOrderKtg.setForeground(new java.awt.Color(102, 51, 0));
        ppOrderKtg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        ppOrderKtg.setText("Registrasi");
        ppOrderKtg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppOrderKtg.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppOrderKtg.setIconTextGap(8);
        ppOrderKtg.setName("ppOrderKtg"); // NOI18N
        ppOrderKtg.setPreferredSize(new java.awt.Dimension(150, 25));
        ppOrderKtg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppOrderKtgActionPerformed(evt);
            }
        });
        ppOrder.add(ppOrderKtg);

        Popup.add(ppOrder);

        Kd2.setHighlighter(null);
        Kd2.setName("Kd2"); // NOI18N
        Kd2.setSelectionColor(new java.awt.Color(255, 255, 255));
        Kd2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Kd2KeyPressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data Unit ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setComponentPopupMenu(Popup);
        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbKamar.setAutoCreateRowSorter(true);
        tbKamar.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbKamar.setComponentPopupMenu(Popup);
        tbKamar.setName("tbKamar"); // NOI18N
        tbKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKamarMouseClicked(evt);
            }
        });
        tbKamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbKamarKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbKamar);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 77));
        panelisi4.setLayout(null);

        label34.setText("Kode Unit :");
        label34.setName("label34"); // NOI18N
        label34.setPreferredSize(new java.awt.Dimension(35, 23));
        panelisi4.add(label34);
        label34.setBounds(0, 12, 85, 23);

        label32.setText("Registrasi Baru :");
        label32.setName("label32"); // NOI18N
        label32.setPreferredSize(new java.awt.Dimension(35, 23));
        panelisi4.add(label32);
        label32.setBounds(194, 12, 110, 23);

        Kd.setHighlighter(null);
        Kd.setName("Kd"); // NOI18N
        Kd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdKeyPressed(evt);
            }
        });
        panelisi4.add(Kd);
        Kd.setBounds(89, 12, 100, 23);

        By.setText("0");
        By.setHighlighter(null);
        By.setName("By"); // NOI18N
        By.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ByKeyPressed(evt);
            }
        });
        panelisi4.add(By);
        By.setBounds(308, 12, 100, 23);

        label36.setText("Nama Unit :");
        label36.setName("label36"); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(35, 23));
        panelisi4.add(label36);
        label36.setBounds(0, 42, 85, 23);

        Nm.setHighlighter(null);
        Nm.setName("Nm"); // NOI18N
        Nm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmKeyPressed(evt);
            }
        });
        panelisi4.add(Nm);
        Nm.setBounds(89, 42, 528, 23);

        label33.setText("Registrasi Lama :");
        label33.setName("label33"); // NOI18N
        label33.setPreferredSize(new java.awt.Dimension(35, 23));
        panelisi4.add(label33);
        label33.setBounds(413, 12, 100, 23);

        ByLm.setText("0");
        ByLm.setHighlighter(null);
        ByLm.setName("ByLm"); // NOI18N
        ByLm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ByLmKeyPressed(evt);
            }
        });
        panelisi4.add(ByLm);
        ByLm.setBounds(517, 12, 100, 23);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(816, 100));
        jPanel1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi3.setName("panelisi3"); // NOI18N
        panelisi3.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label9.setText("Key Word :");
        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(70, 23));
        panelisi3.add(label9);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(350, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi3.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('1');
        BtnCari.setToolTipText("Alt+1");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi3.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('2');
        BtnAll.setToolTipText("Alt+2");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelisi3.add(BtnAll);

        label10.setText("Record :");
        label10.setName("label10"); // NOI18N
        label10.setPreferredSize(new java.awt.Dimension(70, 23));
        panelisi3.add(label10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi3.add(LCount);

        jPanel1.add(panelisi3, java.awt.BorderLayout.PAGE_START);

        panelisi1.setName("panelisi1"); // NOI18N
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

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

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

        jPanel1.add(panelisi1, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdKeyPressed
        Valid.pindah(evt,TCari,Nm);
}//GEN-LAST:event_KdKeyPressed

    private void ByKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ByKeyPressed
        Valid.pindah(evt,Nm,ByLm);
}//GEN-LAST:event_ByKeyPressed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if(Kd.getText().trim().equals("")){
            Valid.textKosong(Kd,"Kode Unit");
        }else if(By.getText().trim().equals("")){
            Valid.textKosong(By,"Biaya Registrasi Pasien Baru");
        }else if(ByLm.getText().trim().equals("")){
            Valid.textKosong(ByLm,"Biaya Registrasi Pasien Lama");
        }else if(Nm.getText().trim().equals("")){
            Valid.textKosong(Nm,"Nama Unit");
        }else{
            Sequel.menyimpan("poliklinik","'"+Kd.getText()+"','"+
                    Nm.getText()+"','"+
                    By.getText()+"','"+
                    ByLm.getText()+"'","Kode Unit");
            BtnCariActionPerformed(evt);
            emptTeks();
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }else{
            Valid.pindah(evt,ByLm,BtnBatal);
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
        for(i=0;i<tbKamar.getRowCount();i++){ 
            if(tbKamar.getValueAt(i,0).toString().equals("true")){
                Sequel.meghapus("poliklinik","kd_poli",tbKamar.getValueAt(i,1).toString());
            }
        } 
        BtnCariActionPerformed(evt);
        emptTeks();
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if(Kd.getText().trim().equals("")){
            Valid.textKosong(Kd,"Kode Unit");
        }else if(By.getText().trim().equals("")){
            Valid.textKosong(By,"Biaya");
        }else if(Nm.getText().trim().equals("")){
            Valid.textKosong(Nm,"Nama Unit");
        }else{
            Valid.editTable(tabMode,"poliklinik","kd_poli",Kd2,"registrasi='"+By.getText()+
                    "',nm_poli='"+Nm.getText()+"',registrasilama='"+ByLm.getText()+
                    "',kd_poli='"+Kd.getText()+"'");
            if(tabMode.getRowCount()!=0){BtnCariActionPerformed(evt);}
            emptTeks();
        }
}//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnPrint);
        }
}//GEN-LAST:event_BtnEditKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnEdit,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BtnCariActionPerformed(evt);
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            BtnBatal.requestFocus();
        }else if(tabMode.getRowCount()!=0){     
                    Map<String, Object> param = new HashMap<>();  
                    param.put("namars",var.getnamars());
                    param.put("alamatrs",var.getalamatrs());
                    param.put("kotars",var.getkabupatenrs());
                    param.put("propinsirs",var.getpropinsirs());
                    param.put("kontakrs",var.getkontakrs());
                    param.put("emailrs",var.getemailrs());   
                    param.put("logo",Sequel.cariGambar("select logo from setting"));        
            Valid.MyReport("rptPoli.jrxml","report","::[ Data Unit ]::","select kd_poli, nm_poli, registrasi, registrasilama "+
                " from poliklinik where  kd_poli like '%"+TCari.getText().trim()+"%' or "+
                " nm_poli like '%"+TCari.getText().trim()+"%' order by kd_poli",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil(" order by kd_poli");
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil(" order by kd_poli");
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCari, TCari);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbKamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKamarMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbKamarMouseClicked

    private void tbKamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbKamarKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbKamarKeyPressed

private void NmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmKeyPressed
   Valid.pindah(evt,Kd,By);
}//GEN-LAST:event_NmKeyPressed

    private void ppOrderKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppOrderKodeActionPerformed
        tampil(" order by kd_poli");
    }//GEN-LAST:event_ppOrderKodeActionPerformed

    private void ppOrderNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppOrderNamaActionPerformed
        tampil(" order by nm_poli");
    }//GEN-LAST:event_ppOrderNamaActionPerformed

    private void ppOrderKtgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppOrderKtgActionPerformed
        tampil(" order by registrasi");
    }//GEN-LAST:event_ppOrderKtgActionPerformed

    private void Kd2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Kd2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Kd2KeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil("");
    }//GEN-LAST:event_formWindowOpened

    private void ByLmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ByLmKeyPressed
        Valid.pindah(evt,By,BtnSimpan);
    }//GEN-LAST:event_ByLmKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgPoli dialog = new DlgPoli(new javax.swing.JFrame(), true);
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
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.TextBox By;
    private widget.TextBox ByLm;
    private widget.TextBox Kd;
    private widget.TextBox Kd2;
    private widget.Label LCount;
    private widget.TextBox Nm;
    private javax.swing.JPopupMenu Popup;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.InternalFrame internalFrame1;
    private javax.swing.JPanel jPanel1;
    private widget.Label label10;
    private widget.Label label32;
    private widget.Label label33;
    private widget.Label label34;
    private widget.Label label36;
    private widget.Label label9;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi3;
    private widget.panelisi panelisi4;
    private javax.swing.JMenuItem ppCetak;
    private javax.swing.JMenuItem ppGanti;
    private javax.swing.JMenuItem ppHapus;
    private javax.swing.JMenu ppOrder;
    private javax.swing.JMenuItem ppOrderKode;
    private javax.swing.JMenuItem ppOrderKtg;
    private javax.swing.JMenuItem ppOrderNama;
    private javax.swing.JMenuItem ppSimpan;
    private widget.Table tbKamar;
    // End of variables declaration//GEN-END:variables

    private void tampil(String order) {
        String sql="";
        if(TCari.getText().equals("")){
            sql="select kd_poli, nm_poli, registrasi,registrasilama "+
                   "from poliklinik "+order;
        }else if(!TCari.getText().equals("")){
            sql="select kd_poli, nm_poli, registrasi,registrasilama "+
                " from poliklinik where kd_poli like '%"+TCari.getText().trim()+"%' or "+
                " nm_poli like '%"+TCari.getText().trim()+"%' "+order;
        } 
        prosesCari(sql);
    }

    private void prosesCari(String sql) {
        Valid.tabelKosong(tabMode);
        try {
            stat=koneksi.prepareStatement(sql);
            try{
                rs=stat.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{false,rs.getString(1),
                                   rs.getString(2),
                                   rs.getDouble(3),
                                   rs.getDouble(4)});
                }
            }catch(SQLException e){
                System.out.println("Notifikasi : "+e);
            }finally{
                if( rs != null){
                    rs.close();
                }
                
                if( stat != null){
                    stat.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : "+e);
        }
            
        LCount.setText(""+tabMode.getRowCount());
    }

    public void emptTeks() {
        Kd.setText("");
        Kd2.setText("");
        By.setText("0");
        ByLm.setText("0");
        Nm.setText("");
        Kd.requestFocus();        
        Valid.autoNomer("poliklinik","U",4,Kd);
    }

    private void getData() {
        if(tbKamar.getSelectedRow()!= -1){
            Kd.setText(tbKamar.getValueAt(tbKamar.getSelectedRow(),1).toString());
            Kd2.setText(tbKamar.getValueAt(tbKamar.getSelectedRow(),1).toString());
            Nm.setText(tbKamar.getValueAt(tbKamar.getSelectedRow(),2).toString());
            By.setText(Valid.SetAngka2(Double.parseDouble(tbKamar.getValueAt(tbKamar.getSelectedRow(),3).toString())));
            ByLm.setText(Valid.SetAngka2(Double.parseDouble(tbKamar.getValueAt(tbKamar.getSelectedRow(),4).toString())));
        }
    }

    public JTextField getTextField(){
        return Kd;
    }

    public JButton getButton(){
        return BtnKeluar;
    }
    
    public void isCek(){
        BtnSimpan.setEnabled(var.getregistrasi());
        BtnHapus.setEnabled(var.getregistrasi());
        BtnEdit.setEnabled(var.getregistrasi());
        BtnPrint.setEnabled(var.getregistrasi());
    }
}
