package Config;

public class RequestBody {

    public static String getRequestBody(String businessActivity) {
        return switch (businessActivity) {
            case "private_person" -> """
                    {"client": {
                           "business_activity_kind": "private_person",
                           "first_name": "Jan",
                           "last_name": "Jeleń",
                           "street": "Zielona",
                           "street_number": "33",
                           "city": "Radom",
                           "country": "PL",
                           "postal_code": "22-222"
                       }
                    }""";
            case "self_employed" -> """
                    {"client": {
                           "business_activity_kind": "self_employed",
                           "first_name": "Tadeusz",
                           "last_name": "Trąba",
                           "street": "Warzywna",
                           "street_number": "68",
                           "city": "Częstochowa",
                           "country": "PL",
                           "postal_code": "03-654",
                           "company_name": "Restauracja",
                           "nip":"1113442668"
                       }
                    }""";
            case "other_business" -> """
                    {"client": {
                           "business_activity_kind": "other_business",
                           "first_name": "Krzysztof",
                           "last_name": "Krzemień",
                           "street": "Lwia",
                           "street_number": "34",
                           "city": "Kraków",
                           "country": "PL",
                           "postal_code": "34-343",
                           "company_name": "ZOO",
                           "nip":"1113442668"
                       }
                    }""";
            default -> """
                    {"client": {
                           "business_activity_kind": "private_person",
                           "first_name": "Jan",
                           "last_name": "Jeleń",
                           "street": "Zielona",
                           "street_number": "33",
                           "city": "Radom",
                           "country": "PL",
                           "postal_code": "22-222"
                       }
                    }""";
        };
    }

    public static String putRequestBody = """
            {"client":{
            "first_name":"Roman"
            }
            }
            """;
}
