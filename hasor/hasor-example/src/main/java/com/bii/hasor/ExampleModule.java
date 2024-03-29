package com.bii.hasor;

import javax.sql.DataSource;
import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bihaiyang
 * @since 2022/12/13
 */
@DimModule
@Component
public class ExampleModule implements SpringModule {
    
    @Autowired
    private DataSource dataSource = null;
    
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource form Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
    }
}
