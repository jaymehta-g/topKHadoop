default: build run
build:
	mvn clean package
run:
	rm -rf ./output
	java -jar target/topKHadoop-0.1-SNAPSHOT-jar-with-dependencies.jar ./flights.csv.bz2 ./output/intermediate ./output/final