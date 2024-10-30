### Hexlet tests and linter status:
[![Actions Status](https://github.com/aar87/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/aar87/java-project-78/actions)
[![Test Coverage](https://api.codeclimate.com/v1/badges/a3dbce64f5d1baef0d4c/test_coverage)](https://codeclimate.com/github/aar87/java-project-78/test_coverage)

### Приложение валидации данных

Валидатор данных - это библиотека для проверки данных.
Правила устанавливаются валидатором и позволяют контролировать переданные данные.

```java
var validator = new Validator();
```

Реализованы 3 схемы валидаторов:
1. **StringSchema** реализует валидацию строк
2. **number()** реализует валидацию чисел
3. **map()** реализует валидацию отображений

#### Валидатор строк
```java
StringSchema s = validator.string();

s.isValid(""); // true
s.isValid(null); // true

s.required();

s.isValid("with text"); // true
s.isValid("a"); // true
s.isValid(null); // false
s.isValid(""); // false
```

#### Валидатор чисел
```java
NumberSchema s = validator.number();

s.isValid(null); // true
s.isValid(0); // true
s.isValid(-5); // true

s.positive();

s.isValid(50); // true
s.isValid(null); // false
s.isValid(-50); // false
```

#### Валидатор отображений
```java
MapSchema s = validator.map();

s.isValid(null); // true
s.isValid(new HashMap()); // true
        
s.required();
s.isValid(null); // false
s.isValid(new HashMap()); // false
Map<String, String> data = new HashMap<>();
data.put("key", "value");
s.isValid(data); // true
```
