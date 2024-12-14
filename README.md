# Conversor de Monedas
## Descripción

El **Conversor de Monedas** es un programa en Java que permite convertir cantidades de una moneda a otra utilizando tasas de cambio obtenidas en tiempo real desde un API. Actualmente, soporta las siguientes conversiones:

1. **USD a ARS** (Dólar a Peso Argentino)
2. **ARS a USD** (Peso Argentino a Dólar)
3. **USD a BRL** (Dólar a Real Brasileño)
4. **BRL a USD** (Real Brasileño a Dólar)
5. **USD a COP** (Dólar a Peso Colombiano)
6. **COP a USD** (Peso Colombiano a Dólar)

El programa presenta un menú interactivo y solicita al usuario que ingrese la cantidad en la moneda de origen para realizar la conversión.


## Funcionalidad del Programa

### Menú Principal

Al iniciar el programa, se muestra un menú interactivo con las opciones de conversión disponibles y la opción de salir. El usuario puede elegir una opción ingresando el número correspondiente.

![image](https://github.com/user-attachments/assets/befa00c5-2168-418f-9ecd-565fa25d1917)

### Proceso de Conversión

#### Ejemplo: Convertir USD a COP
1. Selecciona la opción **5** del menú.
2. El programa solicita al usuario que ingrese la cantidad en dólares (USD).
3. El sistema realiza la conversión utilizando la tasa de cambio actual y muestra el monto convertido en pesos colombianos (COP).

![image](https://github.com/user-attachments/assets/1cdff264-15c7-4971-84fb-704b471d796d)


#### Ejemplo: Convertir ARS a USD
1. Selecciona la opción **2** del menú.
2. Ingresa la cantidad en pesos argentinos (ARS).
3. El programa realiza la conversión utilizando la tasa de cambio y muestra el monto en dólares (USD).

![image](https://github.com/user-attachments/assets/01c52d62-1abc-47d0-9422-d4063d1fd66f)


#### Otras Conversiones
El proceso es similar para las demás opciones del menú:
- USD a ARS (opción 1)
- USD a BRL (opción 3)
- BRL a USD (opción 4)
- COP a USD (opción 6)


### Salir del Programa

Selecciona la opción **7** para salir del programa. Se muestra un mensaje confirmando la salida.

![image](https://github.com/user-attachments/assets/c80040d2-80c7-4751-86be-c1b7937c47ca)


## Estructura del Código

### Clases y Componentes
- **`CurrencyConverterService`**: Contiene el menú interactivo y la lógica de conversión.
- **`ExchangeRateHttpClient`**: Realiza las solicitudes HTTP para obtener las tasas de cambio actuales.
- **`ExchangeRateResponse`**: Clase auxiliar para deserializar las tasas de cambio desde el JSON recibido.

---

## Requisitos

- Java 8 o superior
- Biblioteca Gson para procesar JSON (https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1)
- Conexión a internet para obtener las tasas de cambio en tiempo real
- API Exchange Rate (https://www.exchangerate-api.com/) 

---

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/usuario/currency-converter-service.git
