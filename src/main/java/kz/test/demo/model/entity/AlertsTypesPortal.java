package kz.test.demo.model.entity;

public class AlertsTypesPortal {

    static String[] typesPortal = {"telegram", "sms", "email"};

    public static boolean getAlertTypesPortal(String alertsTypesPortal) {
        for (String type : typesPortal) {
            if (type.equals(alertsTypesPortal)) {
                return true;
            }
        }
        return false;
    }
}
