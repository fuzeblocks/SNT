package fr.fuzeblocks.passwordstrength_tester.tester;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class PasswordTester {
    private List<Character> specialChars = List.of(
            ' ', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
            '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_',
            '`', '{', '|', '}', '~', '¡', '¢', '£', '¤', '¥', '¦', '§', '¨', '©',
            'ª', '«', '¬', '®', 'ˉ', '°', '±', '²', '³', '´', 'μ', '¶', '¸', '¹',
            'º', '»', '¼', '½', '¾', '¿', '×', '÷'
    );
    List<String> commonPasswords = Arrays.asList(
            "root", "123456", "1234", "admin", "password", "12345", "123", "12345678", "1",
            "123456789", "qwerty", "toor", "test", "Aa123456", "root123", "admin123", "1234567890",
            "default", "abc123", "111111", "ubuntu", "0", "1q2w3e4r", "P@ssw0rd", "eve", "123123",
            "1qaz@WSX", "1234567", "qwe123", "p@ssw0rd", "1qaz2wsx", "root@123", "abcd1234", "raspberry",
            "changeme", "redhat", "root@2024", "guest", "rootroot", "server", "pass", "qwer1234",
            "000000", "alpine", "q1w2e3r4", "ubnt", "root1234", "admin@123", "1qazXSW@", "master",
            "welcome", "password1", "administrator", "zaq12wsx", "!QAZ2wsx", "123321", "123.com",
            "Passw0rd", "passw0rd", "1qaz!QAZ", "letmein", "1111", "qwerty123", "123qwe", "123qweasd",
            "system", "test123", "Password1", "cisco", "Aa12341234", "superuser", "1q2w3e", "sysadmin",
            "Password", "11111", "oracle", "alex", "calvin", "trustno1", "rootpass", "-", "admin1234",
            "a", "insecure", "123@abc", "rootadmin", "centos", "11111111", "102030", "1qazxsw2",
            "apple", "asdf1234", "Aa123123", "zaq1xsw2", "root2023", "abc@123", "qwe123!@#",
            "123qwe!@#", "root123456", "rootme", "654321", "Huawei@123", "user", "support",
            "Admin@123", "passwd", "qwertyuiop", "112233", "password123", "12qwaszx", "zxcvbnm",
            "Server123@", "public", "linux", "1122334455", "qweasdzxc", "1q2w3e4r5t", "123123123",
            "666666", "power", "54321", "pass123", "1234qwer", "2wsx3edc", "aa123456", "admin1",
            "super", "samsung", "pfsense", "qweasd", "cisco123", "asdf", "root1", "11223344",
            "dreambox", "888888", "r00t", "voyage", "!@", "1q2w3e4r5t6y", "987654321", "159753",
            "88888888", "huawei@123", "abc123!@#", "qazwsxedc", "admin123456", "12344321", "225588",
            "huawei", "root00", "P@55w0rd!", "a1s2d3f4", "avonline", "123qwer", "admin001", "Abc123",
            "1qaz@wsx", "aaa", "master123", "secret", "xxxxxx", "zabbix", "00000000", "pi",
            "123qweasdzxc", "senha1", "Admin123", "welc0me", "manager", "passwd123", "1qaz2wsx3edc",
            "Huawei12#$", "P@$$w0rd", "windows", "Qwer1234", "123!@#", "welcome123", "winner", "12",
            "qwertyui", "qazwsx123", "qwerty123456", "0000", "P@ssword", "qazwsx", "147852369",
            "123abc", "a123456", "aaaaaa", "12341234", "vision", "123456aa", "Password123",
            "firewall", "123654", "asd123", "system32", "!QAZ@WSX", "P@ssw0rd123", "q1w2e3r4t5y6",
            "555555", "temp", "debian", "baidu.com", "adminadmin", "p@ssw0rd1", "root12", "synopass",
            "Abcd1234", "azerty", "hlL0mlNAabiR", "@123456", "admin123#", "Root1234", "test1234",
            "Changeme123", "abc123456", "vagrant", "abc123!", "abc1234", "dragon", "a1b2c3d4",
            "lenovo", "root01", "asdfghjkl", "vmware", "qwe123456", "asd12345", "789789", "Aa123456789",
            "adminpassword", "iDirect", "openelec", "Ll123456", "live", "root12345", "asdasd",
            "blahblah", "123456a", "meiyoumima", "Root123456", "operator", "PassWord", "159357",
            "casa", "qazxsw", "linux123", "tang", "abcd123456", "root123!@#", "!QAZ1qaz", "87654321",
            "aA123456", "gateway", "147258", "daniel", "superman", "data", "centos6svm", "Passw0rd!",
            "jupiter", "uucp", "r00t123", "5201314", "root123456789", "1111111", "zxc123", "tester",
            "testtest", "pass@123", "juniper1", "monitor", "poiuyt", "george", "asdfg", "rootpw",
            "password@123", "Aa112233", "hadoop", "Admin123!@#", "password1!", "sales", "testing",
            "games", "1234abcd", "147147", "qazwsx12", "bling", "caonima", "powerpc", "nagios",
            "peter", "manager123", "whoami", "Test1234", "iloveyou", "nimda", "geheim", "toto",
            "100200", "apache", "pf123456", "welcome1", "mysql", "ftp", "123@123a", "huawei123",
            "qq123456", "love", "random", "!@#$5678", "rich", "789456", "abcdef", "dnflskfk", "test1"
    );
    List<Character> majuscules = Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    );
    private static final Logger logger = Logger.getLogger("PasswordTester");
    @CrossOrigin(origins = "https://snt.fuzeblocks.icu")
    @GetMapping("/passwordTest")
    private ResponseEntity<Integer> passwordTester(@RequestParam(required = false) String password) {
        if (password == null || password.isEmpty()) {
            logger.warning("Mot de passe vide ou null !");
            return ResponseEntity.badRequest().body(0);
        }

        int mark = 100;
        int passwordLength = password.length();
        logger.info("Analyse du mot de passe : " + password);
        logger.info("Longueur : " + passwordLength);


        if (passwordLength <= 4) {
            mark -= 90;
            logger.info("Pénalité -90 : Mot de passe trop court");
        } else if (passwordLength <= 6) {
            mark -= 40;
            logger.info("Pénalité -40 : Mot de passe court");
        } else if (passwordLength <= 8) {
            mark -= 20;
            logger.info("Pénalité -20 : Mot de passe moyennement sécurisé");
        } else if (passwordLength <= 10) {
            mark -= 10;
            logger.info("Pénalité -10 : Mot de passe correct");
        } else if (passwordLength <= 14) {
            mark += 5;
            logger.info("Bonus +5 : Mot de passe bien");
        } else {
            mark += 10;
            logger.info("Bonus +10 : Mot de passe très bien");
        }

        if (commonPasswords.contains(password)) {
            mark -= 30;
            logger.info("Pénalité -30 : Mot de passe trop courant");
        }


        boolean hasUppercase = false;
        boolean hasSpecial = false;
        Character lastChar = null;

        for (char passChar : password.toCharArray()) {
            if (Character.isUpperCase(passChar)) hasUppercase = true;
            if (specialChars.contains(passChar)) hasSpecial = true;

            if (lastChar != null && lastChar == passChar) {
                mark -= 10;
                logger.info("Pénalité -10 : Caractères répétés :" + passChar);
            }
            lastChar = passChar;
        }

        if (!hasUppercase) {
            mark -= 10;
            logger.info("Pénalité -10 : Aucune majuscule détectée");
        }
        if (!hasSpecial) {
            mark -= 10;
            logger.info("Pénalité -10 : Aucun caractère spécial détecté");
        }


        if (mark > 100) mark = 100;
        if (mark < 0) mark = 0;

        logger.info("Score final : " + mark);
        return ResponseEntity.ok(mark);
    }
}