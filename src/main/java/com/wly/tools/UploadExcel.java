package com.wly.tools;

import com.wly.util.MysqlCommonHandler;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/1/28
 * @备注:
 */
public class UploadExcel {
    public static void main(String[] args) throws Exception {
        File xlsFile = new File("D:\\Users\\liuyangwang\\Desktop\\page.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();

        String url = "jdbc:mysql://tourrealtimeti.ti.db.uat.qa.nt.ctripcorp.com:55777/tourrealtimetidb?useUnicode=true&characterEncoding=UTF-8";
        String username = "m_tourremeti_4r";
        String password = "UY460_pGPz!68()zz!v";
        String driver = "com.mysql.jdbc.Driver";
        String columnNames = "pageid,bu,bu_chinese,pagename,page_type_name,page_owner";
        String tableName = "dim_vacpage";
        String sql = MysqlCommonHandler.getSql(columnNames,tableName);
        System.out.println(sql);
        // 加载JDBC驱动
        Class.forName(driver);
        // 获取数据库连接
        Connection connection = DriverManager.getConnection(url,username,password);
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = 0;

        try{
            // 遍历工作表
            if (sheets != null) {
                for (Sheet sheet : sheets) {
                    // 获得行数
                    int rows = sheet.getRows();
                    // 读取数据
                    for (int row = 1; row < rows; row++) {
                        for(int i = 0;i < columnNames.split(",").length;i++){
                            preparedStatement.setObject(i + 1,sheet.getCell(i, row).getContents().trim());
                        }
                        /*preparedStatement.setObject(1,sheet.getCell(0, row).getContents().trim());
                        preparedStatement.setObject(2,sheet.getCell(1, row).getContents().trim());
                        preparedStatement.setObject(3,sheet.getCell(2, row).getContents().trim());
                        preparedStatement.setObject(4,sheet.getCell(3, row).getContents().trim());
                        preparedStatement.setObject(5,sheet.getCell(4, row).getContents().trim());
                        preparedStatement.setObject(6,sheet.getCell(5, row).getContents().trim());*/
                        preparedStatement.addBatch();
                        count++;
                        if(count > 500){
                            preparedStatement.executeBatch();
                            connection.commit();
                            count = 0;
                        }
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(workbook != null){
                workbook.close();
            }

            if(connection != null){
                connection.close();
            }

            if(preparedStatement != null){
                preparedStatement.close();
            }
        }

    }
}
