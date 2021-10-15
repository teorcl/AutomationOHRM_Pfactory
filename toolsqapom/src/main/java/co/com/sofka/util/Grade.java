package co.com.sofka.util;

public enum Grade {
    GRADO1("1"),
    GRADO2("2"),
    GRADO3("3"),
    GRADO4("4"),
    GRADO5("5"),
    GRADO6("6"),
    GRADO7("7"),
    GRADO8("8"),
    GRADO9("9"),
    GRADO10("10"),
    GRADO11("11");

    private final String value;

    Grade(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}

