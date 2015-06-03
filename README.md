部署到仓库 https://github.com/maxwe/maven
xxxn 为用户名
xxxp 为密码
mvn clean deploy -DGNAME=xxxn -DGPASSWORD=xxxp -DskipTests  --settings settings.xml

手动部署
1.下载
https://github.com/maxwe/maven
最新的分支

路径为:/Users/Meng/Documents/maven

2.到epub
mvn clean package
cd target
# -Durl=file:///Users/xxx/dev/workspaces/maxwe/maven  为步骤1的maven项目的具体位置。
mvn deploy:deploy-file -DpomFile=../pom.xml -Durl=file:///Users/danhantao/dev/workspaces/maxwe/maven/repositories/thirdparty  -Dfile=android-epub.aar
