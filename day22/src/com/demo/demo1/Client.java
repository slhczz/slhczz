package com.demo.demo1;import java.net.InetSocketAddress;import java.nio.ByteBuffer;import java.nio.channels.SocketChannel;public class Client {    public static void main(String[] args) throws Exception {        SocketChannel sc = SocketChannel.open();        sc.connect(new InetSocketAddress("127.0.0.1",8899));        ByteBuffer bb = ByteBuffer.allocate(1024);        bb.put("你好".getBytes());        bb.flip();        sc.write(bb);    }}