# code-generate-template
code-generator-plugin的示例模板，包含POJOs和MVC

## 使用步骤

1. 修改java包名为实际项目中的包名
2. 根据自己的项目规范或者习惯修改模版代码（.java 和 Mapper.xml）
3. 生成POJOs和MVC代码(可选)
```bash
# 生成POJOs
mvn code-generator:generate-pojo

# 生成MVC代码(可选)
mvn code-generator:generate-mvc
```