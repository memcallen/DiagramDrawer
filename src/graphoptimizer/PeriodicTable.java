/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author memcallen
 */
public class PeriodicTable {

    private static boolean inited = false;

    public enum InfoType {

        Electronegativity("Electronegativity"),
        CalculatedRadius("Calculated Radius"),
        FirstIonization("First Ionization"),
        CoreConfiguration("Core Configuration"),
        HeatVapor("Heat of Vapor"),
        CovalentRadius("Covalent Radius"),
        HeatFusion("Heat of Fusion"),
        BulkModulus("Bulk Modulus"),
        BoilingPoint("Boiling Point"),
        BrinellHardness("Brinell Hardness"),
        MeltingPoint("Melting Point"),
        Symbol("Symbol"),
        STPDensity("STP Density"),
        YoungModulus("Young Modulus"),
        ShearModulus("Shear Modulus"),
        VickersHardness("Vickers Hardness"),
        Name("Name"),
        CommonIons("Common Ions"),
        SecondIonization("Second Ionization"),
        Mass("Mass"),
        VanderWaalsRadius("Van der Waals Radius"),
        SpecificHeat("Specific Heat"),
        ThermalConductivity("Thermal Conductivity"),
        ThirdIonization("Third Ionization"),
        Series("Series"),
        ElectronAffinity("Electron Affinity"),
        AtomicNumber("Atomic Number"),
        MohsHardness("Mohs Hardness"),
        EmpiricalRadius("Empirical Radius");

        private final String plain_text;

        InfoType(String plain_text) {
            this.plain_text = plain_text;
        }

        public String GetPlainText() {
            return plain_text;
        }

        public static InfoType GetTypeForString(String name) {
            if (name != null) {
                for (InfoType it : InfoType.values()) {
                    if (it.GetPlainText().equals(name)) {
                        return it;
                    }
                }
            }

            return null;
        }
    }

    private static HashMap<String, HashMap<InfoType, String>> byname = new HashMap<>();
    private static HashMap<String, HashMap<InfoType, String>> bysymbol = new HashMap<>();

    public static void init() throws IOException, ParserConfigurationException, SAXException {
        inited = true;

        Path data_xml = Paths.get("G:\\NetBeansProjects\\DiagramDrawer\\data.xml");

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document data = builder.parse(data_xml.toFile());

        NodeList children = data.getDocumentElement().getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element) {
                Element curr = (Element) children.item(i);

                HashMap<InfoType, String> el_data = new HashMap<>();

                for (InfoType type : InfoType.values()) {
                    el_data.put(type, curr.getElementsByTagName(type.toString()).item(0).getTextContent());
                }

                byname.put(el_data.get(InfoType.Name), el_data);
                bysymbol.put(el_data.get(InfoType.Symbol), el_data);
            }
        }

    }

    public static String GetInfo(String element, InfoType info) {
        return GetInfo(element, info, false);
    }

    public static String GetInfo(String element, InfoType info, boolean symbol) {
        if (symbol) {

            if (!bysymbol.containsKey(element)) {
                throw new IllegalArgumentException("Element Symbol " + element + " does not exist in the table");
            }

            return bysymbol.get(element).get(info);

        } else {

            if (!byname.containsKey(element)) {
                throw new IllegalArgumentException("Element " + element + " does not exist in the table");
            }

            return byname.get(element).get(info);

        }
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        init();

        System.out.println(GetInfo("Helium", InfoType.Mass));
    }

}
