/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import static Main.Main.controller;
import Model.Conexao;
import Model.Empresa;
import Model.Funcionario;
import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author alunolages
 */
public class MenuFuncionarios extends javax.swing.JPanel {

    private ImageIcon ImagemLupa;
    private String imagem = "/Image/Lupa-removebg-preview.png";
    private int Enter = 0;
    private Conexao conexao = new Conexao();
    double salarioTotal = 0;
    
    
    DefaultListModel ModeloLista;
    /**
     * Creates new form LoginUsuario
     */
    public MenuFuncionarios() {
        initComponents();
        
        int larguraMaxima = 53; // Largura máxima da JLabel
        int alturaMaxima = 47; // Altura máxima da JLabel

        ImageIcon icon = new ImageIcon(getClass().getResource(this.imagem));
        Image img = icon.getImage();
        
        Image novaImagem = img.getScaledInstance(larguraMaxima, alturaMaxima, Image.SCALE_SMOOTH);

        ImageIcon imagemRedimensionada = new ImageIcon(novaImagem);
        JL_Lupa.setIcon(imagemRedimensionada);
        
        Lista.setVisible(false);
        
        ModeloLista = new DefaultListModel();
        
        Lista.setModel(ModeloLista);
        
        this.conexao = Main.Main.controller.getConexao();
        
        this.salarioTotal = 0;
        
        for(Funcionario funcionario : Main.Main.controller.getFuncionarios()){
            this.salarioTotal += funcionario.getSalario();
        }
        
        String salarioString = String.valueOf(this.salarioTotal);
        
        CampoDeTexto_TotalSalario.setText(salarioString);;
        
        CampoDeTexto_TotalSalario.setEditable(false);
        
    }
    
    public void ListaDePesquisa() {
        try {
            String pesquisa = CampoDeTexto_Pesquisa.getText().toLowerCase();
            ModeloLista.removeAllElements();
            int v = 0;

            for (Funcionario funcionario : controller.getFuncionarios()) {
                if (funcionario.getNome().toLowerCase().startsWith(pesquisa) && v < 4) {
                    ModeloLista.addElement(funcionario.getNome());
                    v++;
                }
            }

            Lista.setVisible(v >= 1);

            ResultadoPesquisa();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " + erro.getMessage());
        }
    }

    public void MostrarPesquisa() {
        int linha = Lista.getSelectedIndex();
        if (linha >= 0) {
            String nome = (String) ModeloLista.getElementAt(linha);
            for (Funcionario funcionario : controller.getFuncionarios()) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    CampoDeTexto_Nome.setText(funcionario.getNome());
                    CampoDeTexto_DataNascimento.setText(Main.Main.controller.dateParaString(funcionario.getData_nascimento()));
                    CampoDeTexto_CPF.setText(funcionario.getCpf());
                    CampoDeTexto_Cargo.setText(funcionario.getCargo());
                    String salario = String.valueOf(funcionario.getSalario());
                    CampoDeTexto_Salario.setText(salario);
                    CampoDeTexto_Beneficios.setText(funcionario.getBeneficios());
                    break;
                }
            }
        }
    }
    
    public void ResultadoPesquisa(){
        int linha = Lista.getSelectedIndex();
        if (linha >= 0) {
            String nome = (String) ModeloLista.getElementAt(linha);
            for (Funcionario funcionario : controller.getFuncionarios()) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                CampoDeTexto_Nome.setText(funcionario.getNome());
                CampoDeTexto_DataNascimento.setText(Main.Main.controller.dateParaString(funcionario.getData_nascimento()));
                CampoDeTexto_CPF.setText(funcionario.getCpf());
                CampoDeTexto_Cargo.setText(funcionario.getCargo());
                String salario = String.valueOf(funcionario.getSalario());
                CampoDeTexto_Salario.setText(salario);
                CampoDeTexto_Beneficios.setText(funcionario.getBeneficios());
                break;
                }
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        JL_MenuFuncionarios1 = new javax.swing.JLabel();
        JL_DataNascimento = new javax.swing.JLabel();
        BT_Voltar = new javax.swing.JButton();
        BT_Cadastrar = new javax.swing.JButton();
        BT_Editar = new javax.swing.JButton();
        JL_Nome = new javax.swing.JLabel();
        CampoDeTexto_Nome = new javax.swing.JTextField();
        Painel_Pesquisa1 = new javax.swing.JPanel();
        JL_Lupa = new javax.swing.JLabel();
        CampoDeTexto_Pesquisa = new javax.swing.JTextField();
        Lista = new javax.swing.JList<>();
        JL_Beneficios = new javax.swing.JLabel();
        JL_CPF = new javax.swing.JLabel();
        JL_Cargo = new javax.swing.JLabel();
        JL_Salario = new javax.swing.JLabel();
        CampoDeTexto_CPF = new javax.swing.JTextField();
        CampoDeTexto_Cargo = new javax.swing.JTextField();
        CampoDeTexto_Salario = new javax.swing.JTextField();
        JL_TotalSalario = new javax.swing.JLabel();
        CampoDeTexto_TotalSalario = new javax.swing.JTextField();
        CampoDeTexto_DataNascimento = new javax.swing.JFormattedTextField();
        BT_Excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CampoDeTexto_Beneficios = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(577, 674));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        JL_MenuFuncionarios1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        JL_MenuFuncionarios1.setText("Menu Funcionarios");

        JL_DataNascimento.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_DataNascimento.setText("Data Nascimento:");

        BT_Voltar.setBackground(new java.awt.Color(0, 255, 255));
        BT_Voltar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BT_Voltar.setText("Voltar");
        BT_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_VoltarMouseClicked(evt);
            }
        });

        BT_Cadastrar.setBackground(new java.awt.Color(0, 255, 255));
        BT_Cadastrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BT_Cadastrar.setText("Cadastrar");
        BT_Cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_CadastrarMouseClicked(evt);
            }
        });

        BT_Editar.setBackground(new java.awt.Color(0, 255, 255));
        BT_Editar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BT_Editar.setText("Editar");
        BT_Editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_EditarMouseClicked(evt);
            }
        });

        JL_Nome.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_Nome.setText("Nome:");

        CampoDeTexto_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeTexto_NomeActionPerformed(evt);
            }
        });

        Painel_Pesquisa1.setBackground(new java.awt.Color(153, 255, 255));

        JL_Lupa.setText("jLabel1");

        CampoDeTexto_Pesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CampoDeTexto_PesquisaMouseClicked(evt);
            }
        });
        CampoDeTexto_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDeTexto_PesquisaActionPerformed(evt);
            }
        });
        CampoDeTexto_Pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CampoDeTexto_PesquisaKeyReleased(evt);
            }
        });

        Lista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Painel_Pesquisa1Layout = new javax.swing.GroupLayout(Painel_Pesquisa1);
        Painel_Pesquisa1.setLayout(Painel_Pesquisa1Layout);
        Painel_Pesquisa1Layout.setHorizontalGroup(
            Painel_Pesquisa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_Pesquisa1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(JL_Lupa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel_Pesquisa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoDeTexto_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        Painel_Pesquisa1Layout.setVerticalGroup(
            Painel_Pesquisa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_Pesquisa1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Painel_Pesquisa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CampoDeTexto_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(JL_Lupa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JL_Beneficios.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_Beneficios.setText("Benefícios:");

        JL_CPF.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_CPF.setText("CPF:");

        JL_Cargo.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_Cargo.setText("Cargo:");

        JL_Salario.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_Salario.setText("Salario:");

        JL_TotalSalario.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        JL_TotalSalario.setText("Total Salario:");

        try {
            CampoDeTexto_DataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CampoDeTexto_DataNascimento.setToolTipText("<html>Digite somente os numeros,<br> sem usar \".\" ou \",\"<html>");

        BT_Excluir.setBackground(new java.awt.Color(0, 255, 255));
        BT_Excluir.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BT_Excluir.setText("Excluir");
        BT_Excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_ExcluirMouseClicked(evt);
            }
        });

        CampoDeTexto_Beneficios.setColumns(20);
        CampoDeTexto_Beneficios.setRows(5);
        jScrollPane2.setViewportView(CampoDeTexto_Beneficios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(JL_Cargo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CampoDeTexto_Cargo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(JL_CPF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CampoDeTexto_CPF))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(JL_Nome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CampoDeTexto_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(JL_DataNascimento)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CampoDeTexto_DataNascimento))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BT_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BT_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(JL_TotalSalario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CampoDeTexto_TotalSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(JL_Beneficios))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(JL_Salario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CampoDeTexto_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(JL_MenuFuncionarios1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(Painel_Pesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(JL_MenuFuncionarios1)
                .addGap(18, 18, 18)
                .addComponent(Painel_Pesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JL_Nome)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(CampoDeTexto_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JL_DataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CampoDeTexto_DataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_CPF)
                    .addComponent(CampoDeTexto_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Cargo)
                    .addComponent(CampoDeTexto_Cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Salario)
                    .addComponent(CampoDeTexto_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Beneficios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_TotalSalario)
                    .addComponent(CampoDeTexto_TotalSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CampoDeTexto_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeTexto_PesquisaActionPerformed
        Lista.setVisible(true);
        Enter = 1;
    }//GEN-LAST:event_CampoDeTexto_PesquisaActionPerformed

    private void CampoDeTexto_PesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoDeTexto_PesquisaKeyReleased
        if(Enter == 0){
            ListaDePesquisa();
        }
        else{
            Enter = 0;
        }
    }//GEN-LAST:event_CampoDeTexto_PesquisaKeyReleased

    private void ListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMousePressed
        MostrarPesquisa();
        Lista.setVisible(true);
    }//GEN-LAST:event_ListaMousePressed

    private void CampoDeTexto_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDeTexto_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDeTexto_NomeActionPerformed

    private void BT_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_VoltarMouseClicked
        Main.Main.controller.BT_VoltarMenuFuncionarios();
    }//GEN-LAST:event_BT_VoltarMouseClicked

    private void BT_CadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_CadastrarMouseClicked
        double salario = Double.parseDouble(CampoDeTexto_Salario.getText());
        Date data = Main.Main.controller.stringParaDate(CampoDeTexto_DataNascimento.getText());
        Main.Main.controller.CadastrarFuncionario(CampoDeTexto_Nome.getText(), data, CampoDeTexto_CPF.getText(), CampoDeTexto_Cargo.getText(), salario, CampoDeTexto_Beneficios.getText());
        
        this.salarioTotal = 0;
        
        for(Funcionario funcionario : Main.Main.controller.getFuncionarios()){
            this.salarioTotal += funcionario.getSalario();
        }
        
        String salarioString = String.valueOf(this.salarioTotal);
        
        CampoDeTexto_TotalSalario.setText(salarioString);
        
    }//GEN-LAST:event_BT_CadastrarMouseClicked

    private void BT_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_EditarMouseClicked
        double salario = Double.parseDouble(CampoDeTexto_Salario.getText());
        Main.Main.controller.editarFuncionario(CampoDeTexto_Nome.getText(), CampoDeTexto_CPF.getText(), CampoDeTexto_Cargo.getText(), salario, CampoDeTexto_Beneficios.getText());
        
        this.salarioTotal = 0;
        
        for(Funcionario funcionario : Main.Main.controller.getFuncionarios()){
            this.salarioTotal += funcionario.getSalario();
        }
        
        String salarioString = String.valueOf(this.salarioTotal);
        
        CampoDeTexto_TotalSalario.setText(salarioString);
    }//GEN-LAST:event_BT_EditarMouseClicked

    private void BT_ExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_ExcluirMouseClicked
        Main.Main.controller.excluirFuncionario(CampoDeTexto_Nome.getText(), CampoDeTexto_CPF.getText());
        
        this.salarioTotal = 0;
        
        for(Funcionario funcionario : Main.Main.controller.getFuncionarios()){
            this.salarioTotal += funcionario.getSalario();
        }
        
        String salarioString = String.valueOf(this.salarioTotal);
        
        CampoDeTexto_TotalSalario.setText(salarioString);
    }//GEN-LAST:event_BT_ExcluirMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Lista.setVisible(false);

        ModeloLista = new DefaultListModel();

        Lista.setModel(ModeloLista);

        Enter = 0;
    }//GEN-LAST:event_jPanel1MouseClicked

    private void CampoDeTexto_PesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CampoDeTexto_PesquisaMouseClicked
        if(Enter == 0){
            ListaDePesquisa();
        }
        else{
            Enter = 0;
        }
    }//GEN-LAST:event_CampoDeTexto_PesquisaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Cadastrar;
    private javax.swing.JButton BT_Editar;
    private javax.swing.JButton BT_Excluir;
    private javax.swing.JButton BT_Voltar;
    private javax.swing.JTextArea CampoDeTexto_Beneficios;
    private javax.swing.JTextField CampoDeTexto_CPF;
    private javax.swing.JTextField CampoDeTexto_Cargo;
    private javax.swing.JFormattedTextField CampoDeTexto_DataNascimento;
    private javax.swing.JTextField CampoDeTexto_Nome;
    private javax.swing.JTextField CampoDeTexto_Pesquisa;
    private javax.swing.JTextField CampoDeTexto_Salario;
    private javax.swing.JTextField CampoDeTexto_TotalSalario;
    private javax.swing.JLabel JL_Beneficios;
    private javax.swing.JLabel JL_CPF;
    private javax.swing.JLabel JL_Cargo;
    private javax.swing.JLabel JL_DataNascimento;
    private javax.swing.JLabel JL_Lupa;
    private javax.swing.JLabel JL_MenuFuncionarios1;
    private javax.swing.JLabel JL_Nome;
    private javax.swing.JLabel JL_Salario;
    private javax.swing.JLabel JL_TotalSalario;
    private javax.swing.JList<String> Lista;
    private javax.swing.JPanel Painel_Pesquisa1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
