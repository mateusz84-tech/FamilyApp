FROM eclipse-temurin:18-alpine
# wybieram plika jaki mazostać umieszcony w kontenerze
ADD target/FamilyApp-0.0.1-SNAPSHOT.jar .
# podaje port na jakim aplikacja będzie dostępna
EXPOSE 8989
# komenda do uruchomienia obrazu
CMD java -jar FamilyApp-0.0.1-SNAPSHOT.jar


# komenda do zbudowania obrazu
#=============   docker build -f Dockerfile -t createfamily:createrestv1 .   ==============
#=============   komenda do uruchomienia docker run -d -p 8989:8888 <idrepository>