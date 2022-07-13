package com.ljl.web.common;

/**
 * @author RookiezzZ
 * @qq 963314043
 * @date 2022/5/19 10:43
 */
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("deleteflag", "0", metaObject);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // System.out.println(simpleDateFormat.format(date));
        String dd = simpleDateFormat.format(date) + "";
       this.setFieldValByName("workdate",dd , metaObject);
       this.setFieldValByName("time",dd , metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
