/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcpclient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // IP address dari server (localhost jika Hercules di komputer yang sama)
        int port = 12345; // Port yang sama dengan yang digunakan di Hercules

        try (Socket socket = new Socket(serverAddress, port)) {
            // Jika koneksi berhasil
            System.out.println("Berhasil terkoneksi");

            // Mengirim pesan ke server (Hercules)
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Connected to localhost");

            // Tutup koneksi setelah mengirim pesan
            writer.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Gagal terkoneksi: " + e.getMessage());
        }
    }
}
