# this file takes a periodictable file without the headers

import xml.etree.ElementTree as ET
from xml.dom.minidom import parseString

headers = "Electronegativity, Calculated Radius, First Ionization, Core Configuration, Heat of Vapor, Covalent Radius, Heat of Fusion, Bulk Modulus, Boiling Point, Brinell Hardness, Melting Point, Symbol, STP Density, Young Modulus, Shear Modulus, Vickers Hardness, Name, Common Ions, Second Ionization, Mass, Van der Waals Radius, Specific Heat, Thermal Conductivity, Third Ionization, Series, Electron Affinity, Atomic Number, Mohs Hardness, Empirical Radius"

headers =  [i.strip().replace(" ", "").replace("of", "") for i in headers.split(",")]

root = ET.Element("elements")

data = open("dataonly.csv", "r")

for line in data:
	curr = ET.SubElement(root, "element")
	s = line.split(',')
	for i in range(len(headers)):
		el = ET.SubElement(curr, headers[i])
		el.text = s[i]

data.close()		

print(parseString(ET.tostring(root)).toprettyxml(indent='\t'))
