package com.ctrip.util;

import com.ctrip.beans.MysqlBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author W.L.Y
 * @用途:mysql工具类
 * @版本时间:2020/6/19
 * @备注:
 */
public class MysqlCommonHandler {
    public static void main(String[] args) {
        System.out.println(getSql("pageid,keyid,key_params,isactive", "dim_log_key_params_config"));
    }
    //根据字段名称和表名拼接insert语句--重复覆盖更新
    public static String getSql(String keys,String tableName){
        StringBuilder sbkey = new StringBuilder();
        StringBuilder sbw = new StringBuilder();
        StringBuilder result = new StringBuilder();
        StringBuilder update = new StringBuilder();
        if(!keys.isEmpty() && !tableName.isEmpty()){
            for(String k : keys.split(",")){
                sbkey.append(k).append(",");
                sbw.append("?").append(",");
                update.append(k).append(" = values(").append(k+"),");
            }
            result.append("insert into "+tableName)
                    .append(" ("+sbkey.substring(0,sbkey.toString().length() - 1)+")")
                    .append(" values (")
                    .append(sbw.substring(0,sbw.toString().length() - 1))
                    .append(") ON DUPLICATE KEY UPDATE ")
                    .append(update.substring(0,update.length() - 1));
        }

        return result.toString();
    }

    public static Connection getConn(MysqlBean bean) throws Exception {
        // 加载JDBC驱动
        Class.forName(bean.getDriver());
        // 获取数据库连接
        Connection connection = DriverManager.getConnection(bean.getUrl(),bean.getUsername(),bean.getPassword());
        return connection;
    }
}
