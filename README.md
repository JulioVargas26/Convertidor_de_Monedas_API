# 🌍 Convertidor de Monedas con API 💱

## Descripción del Proyecto

Este es un **Conversor de Monedas** desarrollado en **Java** que opera a través de una interfaz de consola. El proyecto está diseñado para obtener los tipos de cambio más recientes al consumir una **API de tipo de cambio** externa (requiere conexión a internet para funcionar), garantizando conversiones precisas y actualizadas.

El proyecto está estructurado con **Apache Maven** para la gestión de dependencias y utiliza la librería **Google Gson** para el eficiente manejo y parseo de las respuestas en formato JSON obtenidas de la API.

## ⚙️ Tecnologías Utilizadas

* **Lenguaje:** Java
* **Gestor de Dependencias:** Apache Maven
* **Manejo de JSON:** Google Gson (`com.google.code.gson:gson:2.10.1`)
* **Conexiones de Red:** Clases estándar de Java (`java.net.URL`, `java.net.HttpURLConnection`).

## ✨ Funcionalidades Principales

La aplicación ofrece un menú interactivo en la consola para realizar conversiones directas entre las siguientes divisas:

| Opción | Conversión |
| :---: | :--- |
| **1** | Nuevo Sol (PEN) a Dólar (USD) |
| **2** | Dólar (USD) a Nuevo Sol (PEN) |
| **3** | Nuevo Sol (PEN) a Euro (EUR) |
| **4** | Euro (EUR) a Nuevo Sol (PEN) |
| **5** | Nuevo Sol (PEN) a Yen (JPY) |
| **6** | Yen (JPY) a Nuevo Sol (PEN) |
| **7** | Nuevo Sol (PEN) a Peso Argentino (ARS) |
| **8** | Peso Argentino (ARS) a Nuevo Sol (PEN) |

Además, la opción **9** permite salir del programa.

## 🚀 Instalación y Ejecución

Sigue estos pasos para clonar y ejecutar el proyecto localmente.

### 1. Clonar el Repositorio

Abre tu terminal o Git Bash y ejecuta:

```bash
git clone [https://github.com/JulioVargas26/Convertidor_de_Monedas_API.git](https://github.com/JulioVargas26/Convertidor_de_Monedas_API.git)
cd Convertidor_de_Monedas_API
```

### 2. Configuración (API Key)
Importante: Asegúrate de que la URL de la API y cualquier clave necesaria estén configuradas dentro del método obtenerTipoCambio en la clase Main.java para que las peticiones HTTP funcionen correctamente.

### 3. Ejecutar la Aplicación

💡 Ejemplo de Uso
Al ejecutar el programa, serás guiado por los siguientes pasos:
```
****************************************
Escriba el numero de la opcion deseada ***
Convertir:
1 - Nuevo Sol (PEN) a Dolar (USD)
...
9 - Salir
****************************************
Opción: 2
Ingrese la cantidad a convertir: 2.99
2.99 USD = 10.13 PEN
```
## 👨‍💻 Autor

* **Julio Vargas** - [GitHub Profile](https://github.com/JulioVargas26)
  
📄 Licencia
Este proyecto está distribuido bajo la licencia MIT. Consulta el archivo LICENSE para más información.




