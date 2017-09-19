package com.demo.org.mybatis01;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.demo.org.bean.Account;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Reader reader = Resources.getResourceAsReader("config/config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        
        SqlSession session = ssf.openSession();
        
        List<Account> accountList = session.selectList("test.getAll");
        
        for(Account account:accountList) {
        	System.out.println(account.getUsername());
        }
    }
}
