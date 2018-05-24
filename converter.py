
headers = "Electronegativity, Calculated Radius, First Ionization, Core Configuration, Heat of Vapor, Covalent Radius, Heat of Fusion, Bulk Modulus, Boiling Point, Brinell Hardness, Melting Point, Symbol, STP Density, Young Modulus, Shear Modulus, Vickers Hardness, Name, Common Ions, Second Ionization, Mass, Van der Waals Radius, Specific Heat, Thermal Cond., Third Ionization, Series, Electron Affinity, Atomic Number, Mohs Hardness, Empirical Radius"

for chunk in [i.strip() for i in headers.split(",")]:
	print("{0}(\"{1}\"),".format(chunk.replace(" ", "").replace("of", ""), chunk));
