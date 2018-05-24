/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphoptimizer;

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

    
    
    public static void init() {
        inited = true;

    }

    public String GetInfo(String name, InfoType info) {

    }

}
