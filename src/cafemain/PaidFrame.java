package cafemain;

import dao.DaoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Paid;
import model.Sifaris;
import model.Sifaris_Masa;

public class PaidFrame extends javax.swing.JFrame {

    private DaoImpl dao;
    private Long selectedRow;
    private float price = 0;

    public PaidFrame() {
        initComponents();
    }

    PaidFrame(DaoImpl dao, Long selectedRow) {
        try {
            initComponents();
            this.dao = dao;
            this.selectedRow = selectedRow;
            Sifaris_Masa sifarisMasa = dao.getSifarisMasaById(selectedRow);
            rezervTxt.setText(sifarisMasa.getSifaris().getResName());
            masaTxt.setText(sifarisMasa.getCafeTable().getName());
            List<Sifaris_Masa> sifarisMasaList = dao.getSifarisMasaByMasaId(sifarisMasa.getCafeTable().getId());
            for (Sifaris_Masa sifarisMasa1 : sifarisMasaList) {
                orderTxt.append(sifarisMasa1.getSifaris().getSifaris() + " --- " + sifarisMasa1.getSifaris().getPrice() + " AZN\n");
                price += sifarisMasa1.getSifaris().getPrice();
            }
            priceTxt.setText(String.valueOf(price));

        } catch (Exception ex) {
            Logger.getLogger(PaidFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rezervTxt = new javax.swing.JTextField();
        masaTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTxt = new javax.swing.JTextArea();
        priceTxt = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("REZERV");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setText("MASA");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setText("SİFARİŞ");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("HESAB");

        rezervTxt.setEditable(false);

        masaTxt.setEditable(false);

        orderTxt.setEditable(false);
        orderTxt.setColumns(20);
        orderTxt.setRows(5);
        jScrollPane1.setViewportView(orderTxt);

        priceTxt.setEditable(false);

        addbtn.setBackground(new java.awt.Color(0, 255, 102));
        addbtn.setFont(new java.awt.Font("Cambria", 0, 48)); // NOI18N
        addbtn.setText("ÖDƏ");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(masaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(rezervTxt)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(124, 124, 124))))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rezervTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(masaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(60, 60, 60)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        try {
            Paid paid = new Paid();
            Sifaris_Masa sifarisMasa = new Sifaris_Masa();
            sifarisMasa.setId(selectedRow);
            paid.setSifarisMasa(sifarisMasa);
            paid.setPrice(price);

            boolean isAdded = dao.add(paid);
            if (isAdded) {
                JOptionPane.showMessageDialog(null, "Ödənildi...");
                Sifaris_Masa sifarisMasa1 = dao.getSifarisMasaById(selectedRow);
                List<Sifaris_Masa> sifarisMasaList = dao.getSifarisMasaByMasaId(sifarisMasa1.getCafeTable().getId());
                for (Sifaris_Masa sifarisMasa2 : sifarisMasaList) {
                    boolean deleteSifaris = dao.deleteSifarisByMasaId(sifarisMasa2.getSifaris().getId());
                }
                boolean isDelete = dao.deleteSifarisMasaForMasaId(sifarisMasa1.getCafeTable().getId());
                boolean changeTableStatus = dao.updateTableStatusForEmpty(sifarisMasa1.getCafeTable().getId());

            }
        } catch (Exception ex) {
            Logger.getLogger(PaidFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField masaTxt;
    private javax.swing.JTextArea orderTxt;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField rezervTxt;
    // End of variables declaration//GEN-END:variables
}
