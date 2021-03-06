echo **************************************************************
echo Generate JAR
echo **************************************************************
mvn clean package -DskipTests
echo **************************************************************
echo BUILD AND PUSH Docker
echo **************************************************************
docker stop microdeposit
docker rm  microdeposit
echo **************************************************************
docker  build -t antony0618/ms-deposit-v1 .
docker push  antony0618/ms-deposit-v1
echo **************************************************************
echo run image 
docker run -p 8006:8006 --name microdeposit --network aforo255 -d antony0618/ms-deposit-v1
echo *************************************************************
echo End Process
echo *************************************************************