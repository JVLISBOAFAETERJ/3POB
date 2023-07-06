package albergue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class quarto {
    private int id;
    private String nomeQuarto;
    private int qtdeCamas;
    private boolean temBanheiro;
    private String descricao;

    public quarto(int id, String nomeQuarto, int qtdeCamas, boolean temBanheiro, String descricao) {
        this.id = id;
        this.nomeQuarto = nomeQuarto;
        this.qtdeCamas = qtdeCamas;
        this.temBanheiro = temBanheiro;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeQuarto() {
        return nomeQuarto;
    }

    public void setNomeQuarto(String nomeQuarto) {
        this.nomeQuarto = nomeQuarto;
    }

    public int getQtdeCamas() {
        return qtdeCamas;
    }

    public void setQtdeCamas(int qtdeCamas) {
        this.qtdeCamas = qtdeCamas;
    }

    public boolean isTemBanheiro() {
        return temBanheiro;
    }

    public void setTemBanheiro(boolean temBanheiro) {
        this.temBanheiro = temBanheiro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static void incluirQuarto(quarto quarto) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("quartos.txt", true));
            writer.write(quarto.getId() + "," + quarto.getNomeQuarto() + "," + quarto.getQtdeCamas() + ","
                    + quarto.isTemBanheiro() + "," + quarto.getDescricao());
            writer.newLine();
            writer.close();
            System.out.println("Quarto adicionado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar quarto: " + e.getMessage());
        }
    }

    public static void alterarQuarto(int id, quarto novoQuarto) {
        try {
            File inputFile = new File("quartos.txt");
            File tempFile = new File("quartos_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int quartoId = Integer.parseInt(data[0]);

                if (quartoId == id) {
                    writer.write(novoQuarto.getId() + "," + novoQuarto.getNomeQuarto() + ","
                            + novoQuarto.getQtdeCamas() + "," + novoQuarto.isTemBanheiro() + ","
                            + novoQuarto.getDescricao());
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    throw new IOException("Falha ao renomear o arquivo temporário.");
                }
                System.out.println("Quarto alterado com sucesso.");
            } else {
                throw new IOException("Falha ao excluiro arquivo original.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao alterar quarto: " + e.getMessage());
        }
    }

    public static void excluirQuarto(int id) {
        try {
            File inputFile = new File("quartos.txt");
            File tempFile = new File("quartos_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean quartoEncontrado = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int quartoId = Integer.parseInt(data[0]);

                if (quartoId != id) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    quartoEncontrado = true;
                }
            }

            reader.close();
            writer.close();

            if (quartoEncontrado) {
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        throw new IOException("Falha ao renomear o arquivo temporário.");
                    }
                    System.out.println("Quarto excluído com sucesso.");
                } else {
                    throw new IOException("Falha ao excluir o arquivo original.");
                }
            } else {
                tempFile.delete();
                System.out.println("Quarto não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir quarto: " + e.getMessage());
        }
    }

    public static void listarQuartos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("quartos.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String nomeQuarto = data[1];
                int qtdeCamas = Integer.parseInt(data[2]);
                boolean temBanheiro = Boolean.parseBoolean(data[3]);
                String descricao = data[4];

                quarto quarto = new quarto(id, nomeQuarto, qtdeCamas, temBanheiro, descricao);
                System.out.println(quarto);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar quartos: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Quarto{" +
                "id=" + id +
                ", nomeQuarto='" + nomeQuarto + '\'' +
                ", qtdeCamas=" + qtdeCamas +
                ", temBanheiro=" + temBanheiro +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
