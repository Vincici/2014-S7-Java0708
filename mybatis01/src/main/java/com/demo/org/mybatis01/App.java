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
import com.demo.org.bean.UserLog;
import com.demo.org.dao.IRoleDao;
import com.demo.org.dao.IUserLog;

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
        
        
        //第一种映射方式 域名查找
        List<Account> accountList = session.selectList("test.getAll");
        
        for(Account account:accountList) {
        	System.out.println(account.getUsername());
        }
        System.out.println("--------------------");
        //第二种映射方式 接口映射
        
        IRoleDao ird = session.getMapper(IRoleDao.class);
        List<Role> roleList = ird.getAll();
        for(Role r : roleList) {
        	System.out.println(r.getRole_name());
        }
        
        Role role = new Role();
        role.setDescription("test role");
        role.setRole_name("TestRole");
        
        ird.insertRole(role);
        
        session.commit();
        
        System.out.println("-------------------");
        //第三种映射方式 注解配置
        	//添加映射配置
        session.getConfiguration().addMapper(IUserLog.class);
        IUserLog iul = session.getMapper(IUserLog.class);
        List<UserLog> userLogList = iul.getAll();
        for(UserLog ul : userLogList) {
        	System.out.println(ul.getDescription());
        }
    }
}
