# desafio-dio-rest
 desafio dio rest 
## Diagrama de classes

```mermaid

classDiagram
    class City {
        - String cityName
        - int temperature
        - String status
        - int high
        - int low
        - List<HourlyForecast> hourlyForecast
    }

    class HourlyForecast {
        - int hour
        - String status
        - int temperature
    }

     class Cities {
        - String cityName
        - String country
        - String status
        - int temperature
        - int High
        - int Low
    }

    City "1" -- "0..*" HourlyForecast : has

```
