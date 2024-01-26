package Data;

public class User {


    private String randomEmail = System.currentTimeMillis() + "@abc.com";

    private String password = "Abc12345$";

    private String nip = "1587627103";

    private String keyLabel = "key";

    public static String apiKey = "";

    public String getRandomEmail() {
        return randomEmail;
    }

    public void setRandomEmail(String randomEmail) {
        this.randomEmail = randomEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKeyLabel() {
        return keyLabel;
    }

    public void setKeyLabel(String keyLabel) {
        this.keyLabel = keyLabel;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        User.apiKey = apiKey;
    }
}
