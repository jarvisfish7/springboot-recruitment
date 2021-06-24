package com.gdpu;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import javafx.scene.control.Tab;

import java.util.ArrayList;


// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/recuitment-web/src/test/java");
        gc.setAuthor("linjia");
        //是否打开当前文件管理器
        gc.setOpen(false);
        // 设置主键策略
        gc.setIdType(IdType.AUTO);
        // 自动生成的Service接口首字母I去掉
        gc.setServiceName("%sService");
        // 日期配置
        gc.setDateType(DateType.ONLY_DATE);
        // 实体属性 Swagger2 注解  当然前提是你配置了swagger 不清楚的可以看我之前博客，地址附在文末
//        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/recruitment_web?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("recuitment-web");
        pc.setParent("com.gdpu");
        mpg.setPackageInfo(pc);
        pc.setEntity("model");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //转换成驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);//表名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//字段名
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");

        strategy.setEntityLombokModel(true);//自动添加乐观锁
        strategy.setRestControllerStyle(true);
        // 自动填充
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

        // 乐观锁
        strategy.setVersionFieldName("version");
        // restful
        strategy.setRestControllerStyle(true);
        //url t驼峰变 _
        strategy.setControllerMappingHyphenStyle(true);
        //设置deleted的字段名
        strategy.setLogicDeleteFieldName("deleted");

        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();
    }

}
