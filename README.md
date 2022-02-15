# Kafka Schema Registry POC
1. Run `mvn clean package` to build project (or separately mvn generate-sources to generate model from protobuf schema)
2. Run `mkdir -p data/storage{1,2,3} && mkdir -p data/zoo` in repo directory
3. Go into 3nodes directory and launch docker-compose
4. Run application from IDE
5. Execute `curl -X POST "http://localhost:8050/produce"` - it will produce and consume message using Protobuf datatype (and store schema in schema-registry)
