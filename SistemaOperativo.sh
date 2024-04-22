
#!/bin/bash

# Directorio donde se encuentran los archivos .java
DIRECTORIO="/home/joel/Escritorio/img"


javac -cp "$DIRECTORIO" "$DIRECTORIO"/Escritorio.java "$DIRECTORIO"/CasaPanel.java "$DIRECTORIO"/Buscador.java


if [ $? -eq 0 ]; then
    # Ejecutar la clase principal
    java -cp "$DIRECTORIO" Escritorio
else
    echo "Error: La compilación falló."
fi
