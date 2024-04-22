
#!/bin/bash

# Directorio donde se encuentran los archivos .java
DIRECTORIO=""


javac -cp "$DIRECTORIO" "$DIRECTORIO"/Escritorio.java "$DIRECTORIO"/CasaPanel.java "$DIRECTORIO"/Buscador.java  "$DIRECTORIO"/Terminaal.java 


if [ $? -eq 0 ]; then
    # Ejecutar la clase principal
    java -cp "$DIRECTORIO" Escritorio
else
    echo "Error: La compilación falló."
fi
