package albergue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class cliente {
    private int id;
    private String nome;
    private String endereco;
    private String postalCode;
    private String pais;
    private String cpf;
    private String passaporte;
    private String email;
    private String dataNascimento;

    public cliente(int id, String nome, String endereco, String postalCode, String pais, String cpf,
                   String passaporte, String email, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.postalCode = postalCode;
        this.pais = pais;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public static void incluirCliente(cliente cliente) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt", true));
            writer.write(cliente.getId() + "," + cliente.getNome() + "," + cliente.getEndereco() + ","
                    + cliente.getPostalCode() + "," + cliente.getPais() + "," + cliente.getCpf() + ","
                    + cliente.getPassaporte() + "," + cliente.getEmail() + "," + cliente.getDataNascimento());
            writer.newLine();
            writer.close();
            System.out.println("Cliente adicionado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    public static void alterarCliente(int id, cliente novoCliente) {
        try {
            File inputFile = new File("clientes.txt");
            File tempFile = new File("clientes_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line =reader.readLine()) != null) {
                String[] data = line.split(",");
                int clienteId = Integer.parseInt(data[0]);

                if (clienteId == id) {
                    writer.write(novoCliente.getId() + "," + novoCliente.getNome() + "," + novoCliente.getEndereco()
                            + "," + novoCliente.getPostalCode() + "," + novoCliente.getPais() + ","
                            + novoCliente.getCpf() + "," + novoCliente.getPassaporte() + ","
                            + novoCliente.getEmail() + "," + novoCliente.getDataNascimento());
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
                System.out.println("Cliente alterado com sucesso.");
            } else {
                throw new IOException("Falha ao excluir o arquivo original.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao alterar cliente: " + e.getMessage());
        }
    }

    public static void excluirCliente(int id) {
        try {
            File inputFile = new File("clientes.txt");
            File tempFile = new File("clientes_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean clienteEncontrado = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int clienteId = Integer.parseInt(data[0]);

                if (clienteId != id) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    clienteEncontrado = true;
                }
            }

            reader.close();
            writer.close();

            if (clienteEncontrado) {
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        throw new IOException("Falha ao renomear o arquivo temporário.");
                    }
                    System.out.println("Cliente excluído com sucesso.");
                } else {
                    throw new IOException("Falha ao excluir o arquivo original.");
                }
            } else {
                tempFile.delete();
                System.out.println("Cliente não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    public static void listarClientes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String nome = data[1];
                String endereco = data[2];
                String postalCode = data[3];
                String pais = data[4];
                String cpf = data[5];
                String passaporte = data[6];
                String email = data[7];
                String dataNascimento = data[8];

                cliente cliente = new cliente(id, nome, endereco, postalCode, pais, cpf, passaporte, email,
                        dataNascimento);
                System.out.println(cliente);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", pais='" + pais + '\'' +
                ", cpf='" + cpf +'\'' +
                ", passaporte='" + passaporte + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
