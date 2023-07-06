package albergue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class cama {
    private int id;
    private String codigoCama;
    private boolean ehBeliche;
    private String posicao;
    private String descricao;

    public cama(int id, String codigoCama, boolean ehBeliche, String posicao, String descricao) {
        this.id = id;
        this.codigoCama = codigoCama;
        this.ehBeliche = ehBeliche;
        this.posicao = posicao;
        this.descricao = descricao;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoCama() {
        return codigoCama;
    }

    public void setCodigoCama(String codigoCama) {
        this.codigoCama = codigoCama;
    }

    public boolean isEhBeliche() {
        return ehBeliche;
    }

    public void setEhBeliche(boolean ehBeliche) {
        this.ehBeliche = ehBeliche;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public static void incluirCama(cama cama) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("camas.txt", true));
            writer.write(cama.getId() + "," + cama.getCodigoCama() + "," + cama.isEhBeliche() + ","
                    + cama.getPosicao() + "," + cama.getDescricao());
            writer.newLine();
            writer.close();
            System.out.println("Cama adicionada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar cama: " + e.getMessage());
        }
    }

    public static void alterarCama(int id, cama novaCama) {
        try {
            File inputFile = new File("camas.txt");
            File tempFile = new File("camas_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int camaId = Integer.parseInt(data[0]);

                if (camaId == id) {
                    writer.write(novaCama.getId() + "," + novaCama.getCodigoCama() + ","
                            + novaCama.isEhBeliche() + "," + novaCama.getPosicao() + ","
                            + novaCama.getDescricao());
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
                System.out.println("Cama alterada com sucesso.");
            } else {
                throw new IOException("Falha ao excluir o arquivo original.");
            }
       } catch (IOException e) {
            System.out.println("Erro ao alterar cama: " + e.getMessage());
        }
    }

    public static void excluirCama(int id) {
        try {
            File inputFile = new File("camas.txt");
            File tempFile = new File("camas_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean camaEncontrada = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int camaId = Integer.parseInt(data[0]);

                if (camaId != id) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    camaEncontrada = true;
                }
            }

            reader.close();
            writer.close();

            if (camaEncontrada) {
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        throw new IOException("Falha ao renomear o arquivo temporário.");
                    }
                    System.out.println("Cama excluída com sucesso.");
                } else {
                    throw new IOException("Falha ao excluir o arquivo original.");
                }
            } else {
                tempFile.delete();
                System.out.println("Cama não encontrada.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir cama: " + e.getMessage());
        }
    }

    public static void listarCamas() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("camas.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String codigoCama = data[1];
                boolean ehBeliche = Boolean.parseBoolean(data[2]);
                String posicao = data[3];
                String descricao = data[4];

                cama cama = new cama(id, codigoCama, ehBeliche, posicao, descricao);
                System.out.println(cama);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar camas: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Cama{" +
                "id=" + id +
                ", codigoCama='" + codigoCama + '\'' +
                ", ehBeliche=" + ehBeliche +
                ", posicao='" + posicao + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

