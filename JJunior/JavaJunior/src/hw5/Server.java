package hw5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Server {

    public static final int PORT = 8181;
    private static long clientIdCounter = 1L;
    private static final Map<Long, SocketWrapper> clients = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);
            while (true) {
                final Socket client = server.accept();
                final long clientId = clientIdCounter++;

                SocketWrapper wrapper = new SocketWrapper(clientId, client);
                System.out.println("Подключился новый клиент[" + wrapper + "]");
                clients.put(clientId, wrapper);

                new Thread(() -> {
                    try (Scanner input = wrapper.getInput(); PrintWriter output = wrapper.getOutput()) {
                        output.println("Подключение успешно. Список всех клиентов: " + clients);

                        // достаём до флага админа
                        String className = client.getClass().getSimpleName();
                        Class<?> clazz = Class.forName(className);
                        boolean isAdmin = (boolean) clazz.getDeclaredField("isAdmin").get(null);

                        if(isAdmin){
                            tellEveryOne("Админ ф чяте, фсем баяца!");
                        }

                        while (true) {
                            String clientInput = input.nextLine();
                            if (Objects.equals("q", clientInput)) {
                                clients.remove(clientId);
                                tellEveryOne("Клиент с портом " + client.getPort() + " отключился\n"
                                        + "Список всех клиентов: " + clients);

                                break;
                            }
                            if (clientInput.startsWith("@")) {
                                long destinationId = Long.parseLong(clientInput.substring(1, 2));
                                SocketWrapper destination = clients.get(destinationId);
                                destination.getOutput().println(clientInput.substring(2));
                            } else if (clientInput.equals("clients")) {
                                output.println("Список всех клиентов: " + clients);
                            } else if (clientInput.startsWith("kick") && isAdmin) {
                                long looser = Long.parseLong(clientInput.substring(5, 6));
                                clients.remove(looser);
                                tellEveryOne("Клиент с портом " + client.getPort() + " кикнут Админом\n"
                                        + "Список всех клиентов: " + clients);
                            } else {
                                tellEveryOne(clientInput);
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchFieldException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }
    }

    private static void tellEveryOne(String s) {
        clients.values().forEach(it -> it.getOutput().println(s));
    }

}

