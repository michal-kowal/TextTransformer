![example workflow](https://github.com/michal-kowal/TextTransformer/actions/workflows/ci.yml/badge.svg)
# TextTransformer
Software Engineering Project

# Build
```bash
mvn build
```

# Run
```bash
java -jar io-project-architecture-1.0.jar
```

Endpoints:
- GET /{text}
- POST /{text}

Available actions:
- upper
- lower
- capitalize
- inverse
- eliminate
- minimize
- expand
- latex
- strip

Swagger dashboard is available at ```http://localhost:8080/swagger-ui/index.html```
