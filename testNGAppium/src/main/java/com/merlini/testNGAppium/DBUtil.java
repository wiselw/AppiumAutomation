package com.merlini.testNGAppium;

import java.sql.*;

public class DBUtil {
	/**
     * 驱动
     */
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private static String driver = "net.sourceforge.jtds.jdbc.Driver";
    /**
     * 连接字符串
     */
    //public static String url = "jdbc:sqlserver://192.168.43.209:50538;databaseName=ATDataBase";
    //public static String url="jdbc:sqlserver://192.168.81.16:55944;databaseName=ATDataBase";
    private static String url="jdbc:jtds:sqlserver://192.168.81.16:55944;databaseName=ATDataBase";
    /**
     * 用户名
     */
    private static String user = "uapp_autotest";
    /**
     * 密码
     */
    private static String password = "1qaz@wsx";
    /**
     * 不允许实例化该类
     */
    private DBUtil()
    {
    }
    /**
     * 获取一个数据库连接
     * 通过设置类的  driver / url / user / password 这四个静态变量来 设置数据库连接属性
     * @return 数据库连接
     */
    public static Connection getConnection()
    {
        try
        {
            Class.forName(driver);
        } catch (ClassNotFoundException ex)
        {
        	ex.printStackTrace();
        }
        try
        {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            return null;
        }
    }
    /**
     * 获取一个数据库连接
     * @param connecturl 数据库url,如jdbc:sqlserver://192.168.81.16:55944;databaseName=ATDataBase
     * @param username   用户名
     * @param psw：密码
     * @return
     */
    public static Connection getConnection(String connecturl,String username,String psw)
    {
    	url=connecturl;
    	user=username;
    	password=psw;
    	return getConnection();       
    }
    /**
     * 获取一个数据库连接,采用integratedSecurity=true的模式（系统账户登录，需要将sqljdbc_auth.dll放到C:\Java\jdk1.7.0_05\bin）
     * @param connecturl 数据库url 如jdbc:sqlserver://192.168.81.16:55944;databaseName=userdb;integratedSecurity=true;
     * @return
     */
    public static Connection getConnection(String connecturl)
    {
    	url=connecturl;
    	user="";
    	password="";
    	try
        {
            Class.forName(driver);
        } catch (ClassNotFoundException ex)
        {
        	ex.printStackTrace();
        }
        try
        {
            return DriverManager.getConnection(url);
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            return null;
        }
    }
    /**
     * 获取一个 Statement
     * 该 Statement 已经设置数据集 可以滚动,可以更新
     * @return 如果获取失败将返回 null,调用时记得检查返回值
     */
    public static Statement getStatement()
    {
        Connection conn = getConnection();
        if (conn == null)
        {
            return null;
        }
        try
        {
            return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        // 设置数据集可以滚动,可以更新
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            close(conn);
        }
        return null;
    }
    /**
     * 获取一个 Statement
     * 该 Statement 已经设置数据集 可以滚动,可以更新
     * @param conn 数据库连接
     * @return 如果获取失败将返回 null,调用时记得检查返回值
     */
    public static Statement getStatement(Connection conn)
    {
        if (conn == null)
        {
            return null;
        }
        try
        {
            return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // 设置数据集可以滚动,可以更新
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            return null;
        }
    }
    /**
     * 获取一个带参数的 PreparedStatement
     * 该 PreparedStatement 已经设置数据集 可以滚动,可以更新
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return 如果获取失败将返回 null,调用时记得检查返回值
     */
    public static PreparedStatement getPreparedStatement(String cmdText, Object... cmdParams)
    {
        Connection conn = getConnection();
        if (conn == null)
        {
            return null;
        }
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(cmdText, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int i = 1;
            for (Object item : cmdParams)
            {
                pstmt.setObject(i, item);
                i++;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            close(conn);
        }
        return pstmt;
    }
    /**
     *  获取一个带参数的 PreparedStatement
     * 该 PreparedStatement 已经设置数据集 可以滚动,可以更新
     * @param conn 数据库连接
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return 如果获取失败将返回 null,调用时记得检查返回值
     */
    public static PreparedStatement getPreparedStatement(Connection conn, String cmdText, Object... cmdParams)
    {
        if (conn == null)
        {
            return null;
        }
        PreparedStatement pstmt = null;
        try
        {
            pstmt = conn.prepareStatement(cmdText, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int i = 1;
            for (Object item : cmdParams)
            {
                pstmt.setObject(i, item);
                i++;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            close(pstmt);
        }
        return pstmt;
    }
    /**
     * 执行 SQL 语句,返回结果为整型
     * 主要用于执行非查询语句
     * @param cmdText SQL 语句
     * @return 非负数:正常执行; -1:执行错误; -2:连接错误
     */
    public static int ExecSql(String cmdText)
    {
        Statement stmt = getStatement();
        if (stmt == null)
        {
            return -2;
        }
        int i;
        try
        {
            i = stmt.executeUpdate(cmdText);
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            i = -1;
        }
        closeConnection(stmt);
        return i;
    }
    /**
     * 执行 SQL 语句,返回结果为整型
     * 主要用于执行非查询语句
     * @param cmdText SQL 语句
     * @return 非负数:正常执行; -1:执行错误; -2:连接错误
     */
    public static int ExecSql(Connection conn, String cmdText)
    {
        Statement stmt = getStatement(conn);
        if (stmt == null)
        {
            return -2;
        }
        int i;
        try
        {
            i = stmt.executeUpdate(cmdText);
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            i = -1;
        }
        close(stmt);
        return i;
    }
    /**
     * 执行 SQL 语句,返回结果为整型
     * 主要用于执行非查询语句
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return 非负数:正常执行; -1:执行错误; -2:连接错误
     */
    public static int ExecSql(String cmdText, Object... cmdParams)
    {
        PreparedStatement pstmt = getPreparedStatement(cmdText, cmdParams);
        if (pstmt == null)
        {
            return -2;
        }
        int i;
        try
        {
            i = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            i = -1;
        }
        closeConnection(pstmt);
        return i;
    }
    /**
     * 执行 SQL 语句,返回结果为整型
     * 主要用于执行非查询语句
     * @param conn 数据库连接
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return 非负数:正常执行; -1:执行错误; -2:连接错误
     */
    public static int ExecSql(Connection conn, String cmdText, Object... cmdParams)
    {
        PreparedStatement pstmt = getPreparedStatement(conn, cmdText, cmdParams);
        if (pstmt == null)
        {
            return -2;
        }
        int i;
        try
        {
            i = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            i = -1;
        }
        close(pstmt);
        return i;
    }
    /**
     * 返回结果集的第一行的一列的值,其他忽略
     * @param cmdText SQL 语句
     * @return
     */
    public static Object ExecScalar(String cmdText)
    {
        ResultSet rs = getResultSet(cmdText);
        Object obj = buildScalar(rs);
        closeConnection(rs);
        return obj;
    }
    /**
     * 返回结果集的第一行的一列的值,其他忽略
     * @param conn 数据库连接
     * @param cmdText SQL 语句
     * @return
     */
    public static Object ExecScalar(Connection conn, String cmdText)
    {
        ResultSet rs = getResultSet(conn, cmdText);
        Object obj = buildScalar(rs);
        closeEx(rs);
        return obj;
    }
    /**
     * 返回结果集的第一行的一列的值,其他忽略
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return
     */
    public static Object ExecScalar(String cmdText, Object... cmdParams)
    {
        ResultSet rs = getResultSet(cmdText, cmdParams);
        Object obj = buildScalar(rs);
        closeConnection(rs);
        return obj;
    }
    /**
     * 返回结果集的第一行的一列的值,其他忽略
     * @param conn 数据库连接
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return
     */
    public static Object ExecScalar(Connection conn, String cmdText, Object... cmdParams)
    {
        ResultSet rs = getResultSet(conn, cmdText, cmdParams);
        Object obj = buildScalar(rs);
        closeEx(rs);
        return obj;
    }
    /**
     * 返回一个 ResultSet
     * @param cmdText SQL 语句
     * @return
     */
    public static ResultSet getResultSet(String cmdText)
    {
        Statement stmt = getStatement();
        if (stmt == null)
        {
            return null;
        }
        try
        {
            return stmt.executeQuery(cmdText);
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            closeConnection(stmt);
        }
        return null;
    }
    /**
     * 返回一个 ResultSet
     * @param conn
     * @param cmdText SQL 语句
     * @return
     */
    public static ResultSet getResultSet(Connection conn, String cmdText)
    {
        Statement stmt = getStatement(conn);
        if (stmt == null)
        {
            return null;
        }
        try
        {
            return stmt.executeQuery(cmdText);
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            close(stmt);
        }
        return null;
    }
    /**
     * 返回一个 ResultSet
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return
     */
    public static ResultSet getResultSet(String cmdText, Object... cmdParams)
    {
        PreparedStatement pstmt = getPreparedStatement(cmdText, cmdParams);
        if (pstmt == null)
        {
            return null;
        }
        try
        {
            return pstmt.executeQuery();
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            closeConnection(pstmt);
        }
        return null;
    }
    /**
     * 返回一个 ResultSet
     * @param conn 数据库连接
     * @param cmdText 需要 ? 参数的 SQL 语句
     * @param cmdParams SQL 语句的参数表
     * @return
     */
    public static ResultSet getResultSet(Connection conn, String cmdText, Object... cmdParams)
    {
        PreparedStatement pstmt = getPreparedStatement(conn, cmdText, cmdParams);
        if (pstmt == null)
        {
            return null;
        }
        try
        {
            return pstmt.executeQuery();
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
            close(pstmt);
        }
        return null;
    }
    public static Object buildScalar(ResultSet rs)
    {
        if (rs == null)
        {
            return null;
        }
        Object obj = null;
        try
        {
            if (rs.next())
            {
                obj = rs.getObject(1);
            }
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
        }
        return obj;
    }
    private static void close(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        try
        {
            if (obj instanceof Statement)
            {
                ((Statement) obj).close();
            } else if (obj instanceof PreparedStatement)
            {
                ((PreparedStatement) obj).close();
            } else if (obj instanceof ResultSet)
            {
                ((ResultSet) obj).close();
            } else if (obj instanceof Connection)
            {
                ((Connection) obj).close();
            }
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
        }
    }
    private static void closeEx(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        try
        {
            if (obj instanceof Statement)
            {
                ((Statement) obj).close();
            } else if (obj instanceof PreparedStatement)
            {
                ((PreparedStatement) obj).close();
            } else if (obj instanceof ResultSet)
            {
                ((ResultSet) obj).getStatement().close();
            } else if (obj instanceof Connection)
            {
                ((Connection) obj).close();
            }
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
        }
    }
    private static void closeConnection(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        try
        {
            if (obj instanceof Statement)
            {
                ((Statement) obj).getConnection().close();
            } else if (obj instanceof PreparedStatement)
            {
                ((PreparedStatement) obj).getConnection().close();
            } else if (obj instanceof ResultSet)
            {
                ((ResultSet) obj).getStatement().getConnection().close();
            } else if (obj instanceof Connection)
            {
                ((Connection) obj).close();
            }
        } catch (SQLException ex)
        {
        	ex.printStackTrace();
        }
    }
}
