package com.curriculum.app.auth;

public class JwtConfig {

    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAtIKW7Cw/uSgFWTXq/zNOy1r2I3yhMqGQzxrXL+Ph8waDr1+0\n" +
            "PnhTN/DZViZ6OS+BDurI6Be9A4x7LdJgoyBtoRiO0cogC676dLVOfXqtLmF+EgwX\n" +
            "hfTy1349BKej5noQsHYlYsHdHM+zaW3KsMkPkZuyQyxFGikoUWOYAZQw6BJWBb2l\n" +
            "bAA0U8EYhDz0sRHKWmioYA4JhTUEmUj8XpJz9KAwfWFDxLtCh40mH+NNeNhaF8R9\n" +
            "vUsZNpQbl8kcqytz2zpdowngI+LnKMY3un/+bYTfkBWV5wX8JIk8qvkbNQIoRoH+\n" +
            "KV7RWfJ2/GJsxF6KXQBKy9YnGxy1pH1o2npv/QIDAQABAoIBAQCFPNcVoFuw2Z+J\n" +
            "B8lbcY25gHyqGPYLH0J5/D/Vs4k2DxroOeYbLkmOwxJJCsGwsCW80wRUfCEiG3FY\n" +
            "ky6NegQxoqTYqS8aMJ/hwWocKI7n60JZI9/BGtqcwStc4jiSiIsFFU/nI12IRK8T\n" +
            "JN01vFLnkVr1RhoDg1mlKbQrhizLPm/gI/bZF8MxcwTMo0jK0tX92itVjyFgiyEK\n" +
            "y8Gm1yZH0L92gfed5HgE7Du7zhHryR+JI+3FkQHZHgkedH3QFJ/eokqK/MFmEIiu\n" +
            "Vf/GTs1Kka2Pd26z2lneR4ZYJJ7LOVKgCj8huhWWrlRv29OXD8g8A5CaxRFdMpKN\n" +
            "9xz0+VDpAoGBAODzzyoz3E9NuXSat4z+FtegsKbfncDewajx6eb3EvksJjuLJ3aH\n" +
            "q/LD5WlPFfIkApjwtWpbvc4APCLkR0HunS7mrVuokLJOj0TcD+8whgzft7rIHndo\n" +
            "P3GQuruaoLJHlOe5QJt1zwiaqafbfLkL+Y44Cm8FouFIO1OVwW1QOugHAoGBAM1s\n" +
            "gxFRnPc7iCb9HK1tYWuHpOJwQ3Rq5rem7DNKeMuJElSscnq8RVVzgqWliPaPXC1q\n" +
            "vLGuVg7W3/IH0rHz3c9TkHZojX+nyILm/oqE7LRxr0DSvBnJ/etYaU4qi/XmMnfj\n" +
            "q7gCm80E6F7cZRtgkfNJVt63AMvGpTlIzQzNaf7bAoGANy4XRzbpd9qM/3lkRQWe\n" +
            "/M3CB20a+VCrGJIe2jUJRm36AukjiQPGvgonoClyLK+Ao5uIJMrUSE/ucHCmuhma\n" +
            "HQMgyzcSJ2r14eJJVlcEyuul2f902b2MsoLaC2LmwFSmxiC/JGNFocquiypf8dRq\n" +
            "JuTASnOLfM+HHf3CMNpZWMkCgYAmz5+bwA2l8EtzAlNOuOG1DTWryoYUErZwcEsk\n" +
            "Dafw3H7oHISsh7GZyW8fmLzdyIwj0IzCDSwZNaOt+KhoEqkPqLwcgvho6+xIPxhM\n" +
            "V3zZQrlXx/jd7nnY4yVSLVuwI8PZPtyMsYF6JLk6Yu1/VKl+i5asEWtHFMrWndiP\n" +
            "2Kd0DQKBgQC5tEIFYdoM9N/Fpn+R64Beh0RWt+HHJ5XUIh+loYLc1bA4Qf/NoEoo\n" +
            "GL1ZC9LIKLhxO11b6ed0qY/hbzoBpsjgMrIi0rSswd5byTNYR1vz+BgR2nGlLfTU\n" +
            "2Ho5A3230TSxNkaSMOW0pBgXPH9qFDk5Ao+P1DC3miItqI1lXRoYRg==\n" +
            "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtIKW7Cw/uSgFWTXq/zNO\n" +
            "y1r2I3yhMqGQzxrXL+Ph8waDr1+0PnhTN/DZViZ6OS+BDurI6Be9A4x7LdJgoyBt\n" +
            "oRiO0cogC676dLVOfXqtLmF+EgwXhfTy1349BKej5noQsHYlYsHdHM+zaW3KsMkP\n" +
            "kZuyQyxFGikoUWOYAZQw6BJWBb2lbAA0U8EYhDz0sRHKWmioYA4JhTUEmUj8XpJz\n" +
            "9KAwfWFDxLtCh40mH+NNeNhaF8R9vUsZNpQbl8kcqytz2zpdowngI+LnKMY3un/+\n" +
            "bYTfkBWV5wX8JIk8qvkbNQIoRoH+KV7RWfJ2/GJsxF6KXQBKy9YnGxy1pH1o2npv\n" +
            "/QIDAQAB\n" +
            "-----END PUBLIC KEY-----";
}
