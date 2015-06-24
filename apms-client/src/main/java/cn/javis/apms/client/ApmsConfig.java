package cn.javis.apms.client;

public enum ApmsConfig {

    SERVER_URL("server.url");

    private String rawStr;

    private ApmsConfig(String raw) {
        this.rawStr = raw;
    }

    public static ApmsConfig getValue(String raw) {
        if(raw==null) {
            return null;
        }
        raw = raw.toLowerCase();
        for (ApmsConfig value : values()) {
            System.out.println(value.rawStr);
            if (value.rawStr.equals(raw)) {
                return value;
            }
        }
        return null;
    }

}
