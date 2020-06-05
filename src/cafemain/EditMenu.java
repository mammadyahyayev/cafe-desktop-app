package cafemain;

import dao.DaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Menu;
import model.MenuIn;

public class EditMenu extends javax.swing.JFrame {

    private int id;
    private Long selectedRow;

    public EditMenu() {
        initComponents();
    }

    EditMenu(Long selectedRow, int id) {
        initComponents();
        this.selectedRow = selectedRow;
        this.id = id;
        OldData(selectedRow, id);
        if (id == 0) {
            priceLbl.setVisible(false);
            priceTxt.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        mealNameLbl = new javax.swing.JLabel();
        mealNametxt = new javax.swing.JTextField();
        priceLbl = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        mealNameLbl.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        mealNameLbl.setText("YEMƏK ADI");

        mealNametxt.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        priceLbl.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        priceLbl.setText("QİYMƏTİ");

        priceTxt.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        priceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTxtActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 255, 0));
        updateBtn.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        updateBtn.setText("DÜZƏLİŞ ET");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(255, 102, 102));
        clearBtn.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        clearBtn.setText("TƏMİZLƏ");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mealNameLbl)
                    .addComponent(priceLbl))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(mealNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mealNameLbl)
                    .addComponent(mealNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceLbl)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void priceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTxtActionPerformed

    }//GEN-LAST:event_priceTxtActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            DaoImpl dao = new DaoImpl();
            if (id == 0) {
                String mealName = mealNametxt.getText();
                Menu menu = new Menu();
                menu.setName(mealName);
                boolean isUpdated = dao.update(menu, selectedRow);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Dəyişikliklər edildi...");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Dəyişikliklər edilmədi!!!");
                }

            } else {

                String mealName = mealNametxt.getText();
                Float price = Float.valueOf(priceTxt.getText());
                MenuIn menuIn = new MenuIn();
                menuIn.setMenyuInName(mealName);
                menuIn.setPrice(price);

                boolean isUpdated = dao.update(menuIn, selectedRow, (long) id);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Dəyişikliklər edildi...");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Dəyişikliklər edilmədi!!!");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(EditMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        mealNametxt.setText("");
        priceTxt.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel mealNameLbl;
    private javax.swing.JTextField mealNametxt;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void OldData(Long selectedRow, int id) {
        try {
            DaoImpl dao = new DaoImpl();
            if (id == 0) {
                Menu menu = dao.getMenuById(selectedRow);
                mealNametxt.setText(menu.getName());
            } else {
                MenuIn menuIn = dao.getMenuInById(selectedRow, (long) id);
                mealNametxt.setText(menuIn.getMenyuInName());
                priceTxt.setText(menuIn.getPrice().toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(EditMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
