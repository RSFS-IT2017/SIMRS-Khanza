/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgLhtBiaya.java
 *
 * Created on 12 Jul 10, 16:21:34
 */

package keuangan;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.var;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import simrskhanza.DlgReg;

/**
 *
 * @author perpustakaan
 */
public final class DlgLhtBiaya extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement pstampil;
    private ResultSet rstampil;

    /** Creates new form DlgLhtBiaya
     * @param parent
     * @param modal */
    public DlgLhtBiaya(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,674);

        Object[] rowRwJlDr={"Keterangan",
                            "Tagihan/Tindakan/Terapi",
                            "",
                            "Biaya",
                            "Jumlah",
                            "Tambahan",
                            "Total Biaya"};
        tabMode=new DefaultTableModel(null,rowRwJlDr){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
              Class[] types = new Class[] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, 
                java.lang.Double.class, 
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbBangsal.setModel(tabMode);
        //tbBangsal.setDefaultRenderer(Object.class, new WarnaTable(jPanel2.getBackground(),tbBangsal.getBackground()));
        tbBangsal.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbBangsal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 7; i++) {
            TableColumn column = tbBangsal.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(130);
            }else if(i==1){
                column.setPreferredWidth(370);
            }else if(i==2){
                column.setPreferredWidth(15);
            }else if(i==3){
                column.setPreferredWidth(100);
            }else if(i==4){
                column.setPreferredWidth(50);
            }else if(i==5){
                column.setPreferredWidth(100);
            }else if(i==6){
                column.setPreferredWidth(140);
            }
        }
        tbBangsal.setDefaultRenderer(Object.class, new WarnaTable());

        TKd.setDocument(new batasInput((byte)20).getKata(TKd));
        
        datareg.getButton().addActionListener((ActionEvent e) -> {
            KdRw.setText(datareg.getTextField().getText());
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,' ',pasien.nm_pasien) from "+
                    "pasien inner join reg_periksa on pasien.no_rkm_medis=reg_periksa.no_rkm_medis "+
                    "where no_rawat=? ",TPasien,KdRw.getText());
            tampil();
        });
        
        try {
           pstampil=koneksi.prepareStatement(
                   "select billing.no,billing.nm_perawatan, if(billing.biaya<>0,billing.biaya,null) as satu, "+
                   "if(billing.jumlah<>0,billing.jumlah,null) as dua,"+
                   "if(billing.tambahan<>0,billing.tambahan,null) as tiga, "+
                   "if(billing.totalbiaya<>0,billing.totalbiaya,null) as empat,billing.pemisah "+
                   "from billing where billing.no_rawat not in(select piutang_pasien.no_rawat from piutang_pasien group by piutang_pasien.no_rawat) "+
                   "and billing.no_rawat like ? and billing.tgl_byr between ? and ?  order by billing.noindex"); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private DlgReg datareg=new DlgReg(null,false);
    
    private double all=0,y=0;
    private int i=0;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TKd = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbBangsal = new widget.Table();
        panelGlass5 = new widget.panelisi();
        jLabel10 = new javax.swing.JLabel();
        LCount = new javax.swing.JLabel();
        BtnHapus = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();
        panelisi4 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label18 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        label17 = new widget.Label();
        KdRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        BtnSeek2 = new widget.Button();
        BtnCari = new widget.Button();

        TKd.setForeground(new java.awt.Color(255, 255, 255));
        TKd.setName("TKd"); // NOI18N
        TKd.setSelectionColor(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Rekap Data Tagihan Masuk ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbBangsal.setAutoCreateRowSorter(true);
        tbBangsal.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbBangsal.setName("tbBangsal"); // NOI18N
        tbBangsal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBangsalMouseClicked(evt);
            }
        });
        tbBangsal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbBangsalKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbBangsal);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelGlass5.setName("panelGlass5"); // NOI18N
        panelGlass5.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Total Tagihan Masuk :");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(130, 30));
        panelGlass5.add(jLabel10);

        LCount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LCount.setForeground(new java.awt.Color(153, 0, 51));
        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(310, 30));
        panelGlass5.add(LCount);

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
        panelGlass5.add(BtnHapus);

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
        panelGlass5.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
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
        panelGlass5.add(BtnAll);

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
        panelGlass5.add(BtnKeluar);

        internalFrame1.add(panelGlass5, java.awt.BorderLayout.PAGE_END);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label11.setText("Tgl.Tagihan :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(80, 23));
        panelisi4.add(label11);

        Tgl1.setEditable(false);
        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(100, 23));
        panelisi4.add(Tgl1);

        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("s.d.");
        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(30, 23));
        panelisi4.add(label18);

        Tgl2.setEditable(false);
        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setName("Tgl2"); // NOI18N
        Tgl2.setPreferredSize(new java.awt.Dimension(100, 23));
        panelisi4.add(Tgl2);

        label17.setText("No.Rawat :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(70, 23));
        panelisi4.add(label17);

        KdRw.setName("KdRw"); // NOI18N
        KdRw.setPreferredSize(new java.awt.Dimension(150, 23));
        KdRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdRwKeyPressed(evt);
            }
        });
        panelisi4.add(KdRw);

        TPasien.setEditable(false);
        TPasien.setName("TPasien"); // NOI18N
        TPasien.setPreferredSize(new java.awt.Dimension(233, 23));
        panelisi4.add(TPasien);

        BtnSeek2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek2.setMnemonic('3');
        BtnSeek2.setToolTipText("Alt+3");
        BtnSeek2.setName("BtnSeek2"); // NOI18N
        BtnSeek2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek2ActionPerformed(evt);
            }
        });
        BtnSeek2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSeek2KeyPressed(evt);
            }
        });
        panelisi4.add(BtnSeek2);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
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
        panelisi4.add(BtnCari);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
         tampil();
         Valid.hapusTable(tabMode,KdRw,"billing","no_rawat");
         int reply2 = JOptionPane.showConfirmDialog(rootPane,"Anda sudah melakukan penghapusan data tagihan pasien.....!!!!\n"+
                                                             "Silahkan lakukan 'Jurnal Penyesuaian' agar transaksi akuntansi tetap balance.\n"+
                                                             "agar jumlah barang tetap valid. Anda ingin melakukan 'Jurnal Penyesuaian' sekarang...??",
                                                             "Konfirmasi",JOptionPane.YES_NO_OPTION);
         if (reply2 == JOptionPane.YES_OPTION) {
             this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
             Sequel.menyimpan("tampjurnal","'42000','PEMBAYARAN PASIEN','"+all+"','0'","Rekening");    
             Sequel.menyimpan("tampjurnal","'11120','KAS DI TANGAN','0','"+all+"'","Rekening"); 
             DlgJurnal form=new DlgJurnal(null,false);
             form.emptTeks();  
             form.setData(KdRw.getText());
             form.tampil();
             form.setSize(internalFrame1.getWidth(), internalFrame1.getHeight());
             form.setLocationRelativeTo(internalFrame1);
             form.setVisible(true);
             this.setCursor(Cursor.getDefaultCursor());
        }
         
        KdRw.setText("");
        tampil();
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, KdRw, BtnPrint);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Sequel.AutoComitFalse();
            Sequel.queryu("delete from temporary");
            int row=tabMode.getRowCount();
            String biaya,tambahan,total,jumlah;
            for(i=0;i<row;i++){  
                    try{
                        biaya=Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,3).toString()));
                    }catch(Exception e){
                        biaya="";
                    }           
                    
                    try{
                        jumlah=Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,4).toString()));
                    }catch(Exception e){
                        jumlah="";
                    }
                    
                    try{
                        tambahan=Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,5).toString()));
                    }catch(Exception e){
                        tambahan="";
                    }
                    
                    try{
                        total=Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i,6).toString()));
                    }catch(Exception e){
                        total="";
                    }
                    Sequel.menyimpan("temporary","'0','"+
                                    tabMode.getValueAt(i,0).toString().replaceAll("'","`") +"','"+
                                    tabMode.getValueAt(i,1).toString().replaceAll("'","`")+"','"+
                                    tabMode.getValueAt(i,2).toString().replaceAll("'","`")+"','"+
                                    biaya+"','"+
                                    jumlah+"','"+
                                    tambahan+"','"+
                                    total+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Rekap Nota Pembayaran");
            }
            Sequel.menyimpan("temporary","'0','TOTAL TAGIHAN','',':','','','','"+LCount.getText()+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Rekap Harian Tindakan Dokter"); 
            Sequel.AutoComitTrue();
            Map<String, Object> param = new HashMap<>();                 
            param.put("namars",var.getnamars());
            param.put("alamatrs",var.getalamatrs());
            param.put("kotars",var.getkabupatenrs());
            param.put("propinsirs",var.getpropinsirs());
            param.put("kontakrs",var.getkontakrs());
            param.put("emailrs",var.getemailrs());   
            param.put("logo",Sequel.cariGambar("select logo from setting")); 
            Valid.MyReport("rptRTagihanMasuk.jrxml","report","::[ Rekap Tagihan Masuk ]::",
                "select no, temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14 from temporary order by no asc",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnAll);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TKd);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        KdRw.setText("");
        tampil();

}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbBangsalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBangsalMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbBangsalMouseClicked

    private void tbBangsalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBangsalKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbBangsalKeyPressed

private void KdRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdRwKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,' ',pasien.nm_pasien) from "+
                              "pasien inner join reg_periksa on pasien.no_rkm_medis=reg_periksa.no_rkm_medis "+
                              "where no_rawat=? ",TPasien,KdRw.getText());
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,' ',pasien.nm_pasien) from "+
                              "pasien inner join reg_periksa on pasien.no_rkm_medis=reg_periksa.no_rkm_medis "+
                              "where no_rawat=? ",TPasien,KdRw.getText());
            Tgl2.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,' ',pasien.nm_pasien) from "+
                              "pasien inner join reg_periksa on pasien.no_rkm_medis=reg_periksa.no_rkm_medis "+
                              "where no_rawat=? ",TPasien,KdRw.getText());
            BtnHapus.requestFocus();
        }
}//GEN-LAST:event_KdRwKeyPressed

private void BtnSeek2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek2ActionPerformed
        datareg.tampil();
        datareg.isCek();
        datareg.emptTeks();
        datareg.setSize(internalFrame1.getWidth(),internalFrame1.getHeight());
        datareg.setLocationRelativeTo(internalFrame1);
        datareg.setAlwaysOnTop(false);
        datareg.setVisible(true);
}//GEN-LAST:event_BtnSeek2ActionPerformed

private void BtnSeek2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSeek2KeyPressed
    Valid.pindah(evt,Tgl2,TKd);
}//GEN-LAST:event_BtnSeek2KeyPressed

private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            tampil();
        }else{
            Valid.pindah(evt, TKd, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgLhtBiaya dialog = new DlgLhtBiaya(new javax.swing.JFrame(), true);
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
    private widget.Button BtnCari;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSeek2;
    private widget.TextBox KdRw;
    private javax.swing.JLabel LCount;
    private widget.ScrollPane Scroll;
    private widget.TextBox TKd;
    private widget.TextBox TPasien;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.InternalFrame internalFrame1;
    private javax.swing.JLabel jLabel10;
    private widget.Label label11;
    private widget.Label label17;
    private widget.Label label18;
    private widget.panelisi panelGlass5;
    private widget.panelisi panelisi4;
    private widget.Table tbBangsal;
    // End of variables declaration//GEN-END:variables

    private void tampil(){
        Valid.tabelKosong(tabMode);
        try{            
            pstampil.setString(1,"%"+KdRw.getText()+"%");
            pstampil.setString(2,Valid.SetTgl(Tgl1.getSelectedItem()+""));
            pstampil.setString(3,Valid.SetTgl(Tgl2.getSelectedItem()+""));
            rstampil=pstampil.executeQuery();
            while(rstampil.next()){
                if((!rstampil.getString("no").contains("Tagihan + PPN"))&&(!rstampil.getString("no").contains("Total Tagihan"))){
                    if(rstampil.getString("no").contains("PPN(")){
                        tabMode.addRow(new Object[]{rstampil.getString("no"),
                                            rstampil.getString("nm_perawatan"),
                                            rstampil.getString("pemisah"),
                                            rstampil.getObject("satu"),
                                            rstampil.getObject("dua"),
                                            rstampil.getObject("tiga"),
                                            rstampil.getObject("empat")});
                        tabMode.addRow(new Object[]{"","","",null,null,null,null});
                    }else{
                        tabMode.addRow(new Object[]{rstampil.getString("no"),
                                        rstampil.getString("nm_perawatan"),
                                        rstampil.getString("pemisah"),
                                        rstampil.getObject("satu"),
                                        rstampil.getObject("dua"),
                                        rstampil.getObject("tiga"),
                                        rstampil.getObject("empat")});
                    }
                }
            }
            //rs.close();
            all=0;y=0;
            for(i=0;i<tabMode.getRowCount();i++){ 
                try {                
                    y=Double.parseDouble(tabMode.getValueAt(i,6).toString());  
                 } catch (Exception e) {
                     y=0; 
                 }
                 all=all+y;  
            }
            LCount.setText(Valid.SetAngka(all));
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
    }

    private void getData() {
        if(tbBangsal.getSelectedRow()!= -1){
            TKd.setText(tabMode.getValueAt(tbBangsal.getSelectedRow(),0).toString());
            KdRw.setText(tabMode.getValueAt(tbBangsal.getSelectedRow(),1).toString().replaceAll(" ","").replaceAll(":",""));
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,' ',pasien.nm_pasien) from "+
                              "pasien inner join reg_periksa on pasien.no_rkm_medis=reg_periksa.no_rkm_medis "+
                              "where no_rawat=? ",TPasien,KdRw.getText());
        }
    }

}
