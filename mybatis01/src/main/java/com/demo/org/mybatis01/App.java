package com.demo.org.mybatis01;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.demo.org.bean.Account;
import com.demo.org.bean.Role;
import com.demo.org.dao.IRoleDao;

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
        
        
        //第一种映射方式
        List<Account> accountList = session.selectList("test.getAll");
        
        for(Account account:accountList) {
        	System.out.println(account.getUsername());
        }
        System.out.println("--------------------");
        //第二种映射方式
        
        IRoleDao ird = session.getMapper(IRoleDao.class);
        List<Role> roleList = ird.getAll();
        for(Role r : roleList) {
        	System.out.println(r.getRolename());
        }
        
        
    }
}
