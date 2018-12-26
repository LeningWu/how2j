package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionpoolWorkingThread extends Thread{
    /*
    使用连接池方式，建立连接的工作线程
     */
    private ConnectionPool cp;

    public ConnectionpoolWorkingThread(ConnectionPool cp){
        this.cp= cp;
    }

    public void run(){
        Connection c=cp.getConnection();
        try (Statement st=c.createStatement()){
            for (int i=0;i<100;i++){
                String sql="insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
                st.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cp.returnConnection(c);
    }
}
