
package Visao.Excluir;

import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.FuncionarioDAO;
import Modelo.Cliente;
import Modelo.Funcionario;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ExcluirFuncionario extends javax.swing.JFrame {
            private void AtualizaCombo(){
            Connection con = Conexao.AbrirConexao();
            ClienteDAO sql = new ClienteDAO(con);
            List<Cliente> lista = new ArrayList<>();
            lista = sql.ListarComboCliente();
            jCB_Nome.addItem("");
            
            for (Cliente b : lista){
                jCB_Nome.addItem(b.getNome());
            }
            Conexao.FecharConexao(con);
        }
     public ExcluirFuncionario() {
        initComponents();
        setLocationRelativeTo(this);
        AtualizaCombo();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCB_Nome = new javax.swing.JComboBox<>();
        jTF_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("                          Excluir Funcionários");

        jCB_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_NomeActionPerformed(evt);
            }
        });

        jTF_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_codigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCB_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCB_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_codigoActionPerformed

    }//GEN-LAST:event_jTF_codigoActionPerformed

    private void jCB_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_NomeActionPerformed
    Connection con = Conexao.AbrirConexao();
    ClienteDAO sql = new ClienteDAO(con);
    List<Cliente> lista = new ArrayList<>();
    String nome = jCB_Nome.getSelectedItem().toString();
    
    lista = sql.ConsultarCodigoCliente(nome);
    
    for (Cliente b : lista){
        int a = b.getCodigo();
        jTF_codigo.setText("" + a);
    }
    Conexao.FecharConexao(con);
    
    }//GEN-LAST:event_jCB_NomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            String codigo = jTF_codigo.getText();
            String nome = jCB_Nome.getSelectedItem().toString();
            
            Connection con = Conexao.AbrirConexao();
            FuncionarioDAO sql = new FuncionarioDAO(con);
            Funcionario a = new Funcionario();
            if (nome.equals("")) {
                JOptionPane.showMessageDialog(null, "Nenhum Nome selecionado",
                        "Video Locadora", JOptionPane.WARNING_MESSAGE);
            } else {
                    int b = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir"
                    + " \n ("+ codigo + ") ("+ nome + ") ", "Video Locadora",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (b == 0) {
                        int cod = Integer.parseInt(codigo);
                        a.setNome(nome);
                        a.setCod(cod);
                        sql.Excluir_Funcionario(a);
                        Conexao.FecharConexao(con);
                        dispose();
                    }
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcluirFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCB_Nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTF_codigo;
    // End of variables declaration//GEN-END:variables
}
