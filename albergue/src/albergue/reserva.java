package albergue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class reserva {
    private int id;
    private int idQuarto;
    private int idCama;
    private int idCliente;
    private String dataEntrada;
    private String dataSaida;

    public reserva(int id, int idQuarto, int idCama, int idCliente, String dataEntrada, String dataSaida) {
        this.id = id;
        this.idQuarto = idQuarto;
        this.idCama = idCama;
        this.idCliente = idCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

   
    public static void incluirReserva(reserva reserva) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("reservas.txt", true));
            writer.write(reserva.getId() + "," + reserva.getIdQuarto() + "," + reserva.getIdCama() + ","
                    + reserva.getIdCliente() + "," + reserva.getDataEntrada() + "," + reserva.getDataSaida());
            writer.newLine();
            writer.close();
            System.out.println("Reserva adicionada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar reserva: " + e.getMessage());
        }
    }

    public static void alterarReserva(int id, reserva novaReserva) {
        try {
            File inputFile = new File("reservas.txt");
            File tempFile = new File("reservas_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int reservaId = Integer.parseInt(data[0]);

                if (reservaId == id) {
                    writer.write(novaReserva.getId() + "," + novaReserva.getIdQuarto() + ","
                            + novaReserva.getIdCama() + "," + novaReserva.getIdCliente() + ","
                            + novaReserva.getDataEntrada() + "," + novaReserva.getDataSaida());
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
                System.out.println("Reserva alterada com sucesso.");
            } else {
                throw new IOException("Falha ao excluir o arquivo original.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao alterar reserva: " + e.getMessage());
        }
    }

    public static void excluirReserva(int id) {
        try {
            File inputFile = new File("reservas.txt");
            File tempFile = new File("reservas_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean reservaEncontrada = false;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int reservaId = Integer.parseInt(data[0]);

                if (reservaId != id) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    reservaEncontrada = true;
                }
            }

            reader.close();
            writer.close();

            if (reservaEncontrada) {
                if (inputFile.delete()) {
                    if (!tempFile.renameTo(inputFile)) {
                        throw new IOException("Falha ao renomear o arquivo temporário.");
                    }
                    System.out.println("Reserva excluída com sucesso.");
                } else {
                    throw new IOException("Falha ao excluir o arquivo original.");
                }
            } else {
                tempFile.delete();
                System.out.println("Reserva não encontrada.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }

    public static void listarReservas() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int idQuarto = Integer.parseInt(data[1]);
                int idCama = Integer.parseInt(data[2]);
                int idCliente = Integer.parseInt(data[3]);
                String dataEntrada = data[4];
                String dataSaida = data[5];

                reserva reserva = new reserva(id, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
                System.out.println(reserva);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao listar reservas: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idQuarto=" + idQuarto +
                ", idCama=" + idCama +
                ", idCliente=" + idCliente +
                ", dataEntrada='" + dataEntrada + '\'' +
                ", dataSaida='" + dataSaida + '\'' +
                '}';
    }
}
