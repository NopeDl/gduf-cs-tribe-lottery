# 抽奖系统

## 逻辑说明
    - 启动时从MYSQL读取奖品初始化数据
    - 加载奖品库存数据至Redis缓存
    - 项目完成初始化后不在与数据库进行交互，只有抽中人之后会扣减Redis中库存

## 贡献
    - Designed By 良哥 -18级
    - 19级
    - 弈龙 -20级

## 代码合并规范
    - 从 master 分支 checkout 新分支，在新分支写完后提pr