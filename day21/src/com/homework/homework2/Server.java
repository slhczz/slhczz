package com.homework.homework2;import java.io.*;import java.net.ServerSocket;import java.net.Socket;public class Server {    public static void main(String[] args) throws Exception {        ServerSocket ss = new ServerSocket(9988);        while (true){            new Thread(){                Socket s = ss.accept();                @Override                public void run() {                    InputStream is = null;                    try {                        is = s.getInputStream();                        byte[] bs = new byte[1024];                        int len;                        len = is.read(bs);                        String name = new String(bs,0,len);                        File file = new File(name);                        OutputStream os = s.getOutputStream();                        os.write(file.getName().getBytes());                        FileInputStream fis = new FileInputStream(name);                        while ((len = fis.read(bs)) != -1){                            os.write(bs,0,len);                        }                        os.close();                    } catch (IOException e) {                        e.printStackTrace();                    }                }            }.start();        }    }}