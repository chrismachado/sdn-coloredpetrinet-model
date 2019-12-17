package conn;
import cpn.*;

public class Connect {
        private JavaCPN socket;
        public Connect() {
            socket = new JavaCPN();
        }
        public JavaCPN getSocket() {
            return this.socket;
        }
        public void setSocket(JavaCPN socket) {
            this.socket = socket;
        }
        public boolean openConnection(int port) {
            try {
                socket.accept(port);
                return true;
            } catch (Exception e) {
                System.err.println("Unable to connect.");
                return false;
            }
        }


}
