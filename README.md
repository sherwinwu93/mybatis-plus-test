# 自定义MyBaseMapper方法
1. 定义SQL: MysqlInsertAllBatch extends AbstractMethod
2. 注册到Injector: MyLocalSqlInject extends DefaultSqlInjector
3. 方法定义到BaseMapper: MyBaseMapper
4. 配置Injector到Spring: @Bean