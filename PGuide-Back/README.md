## 项导



### 项目介绍

该项目旨在为大学生提供一个竞赛组队交流平台，同时定期展示相关竞赛信息，为大学生竞赛、创新创业项目提供支持和帮助。项目分为组队管理、竞赛信息、项目管理等多个模块，并在ruoyi框架的基础上进行了对后台管理系统的二次开发。



### 项目结构

后端目录结构

```text
|-- pguide-api：                                 接口层
|-- pguide-auth：                                鉴权中心
|-- pguide-business-providers：                  业务模块
|-- pguide-code-generator：                      代码生成器（待完成，暂时使用的是ruoyi）
|-- pguide-commons：                             工具包
|   |-- pguide-common-core：                         基础工具包
|   |-- pguide-common-download：                     下载工具包
|   |-- pguide-common-page：                         分页工具包 
|   |-- pguide-common-redis：                        redis工具包
|   |-- pguide-common-search：                       elasticsearch工具包
|   |-- pguide-common-security：                     鉴权工具包
|-- pguide-demo：                                demo
|-- pguide-entity：                              实体类
|-- pguide-gateway：                             
|   -- sc-gateway：                              网关
|-- pguide-service：                             service层
|-- pguide-third-integration：                   整合第三方依赖
```
