package socketchannel.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gene on 2017/9/25.
 */
public class Client {
    public static void client(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try{
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("192.168.40.253",8080));

            if(socketChannel.finishConnect()){
                int i = 0;
                while(true){
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm"+i+++"-th infomation from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while ((buffer.hasRemaining())) {
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }

        }catch (Exception e){

        }
        finally {
            try {
                if(socketChannel!=null){
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}
