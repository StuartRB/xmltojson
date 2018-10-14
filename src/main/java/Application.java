import service.XmlToJsonService;

public class Application {

    public static void main(String[] args) {
        XmlToJsonService service = new XmlToJsonService();
        System.out.println(service.convertXmlToJson());
    }
}
