[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]]

<br />
<div align="center">
  <a href="https://github.com/idmr023/ProyectoWeb">
    <img src="https://w7.pngwing.com/pngs/1021/160/png-transparent-web-address-website-internet-symbol-icon-communication-online-www.png" alt="Logo" width="80" height="80">
  </a>
</div>

<h3 align="center">Proyecto - Hotel Antares</h3>

<details>
  <summary>Tabla de contenidos</summary>
  <ol>
    <li>
      <a href="#acerca-del-proyecto">Comandos GitHub</a>
    </li>
    <li>
      <ul>
        <li><a href="#errores">Errores GitHub</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>

## Acerca del proyecto

![Product Name Screen Shot][product-screenshot]
<br/>

<p>Proyecto Desarrollo Web - Hotel Antares. En el presente README.md se encuentron comandos de GitHub, pendientes para el avance del proyecto, entre otros</p>

<p align="right">(<a href="#readme-top">Regresar al inicio</a>)</p>

## Comandos Git Hub

Para subir por primer vez a un repositorio
  
  ⚠️ Para poder hacer cualquier cambio a nuestro proyecto, primero debemos hacer ``` git pull ``` (actualizar el repositorio ante cualquier cambio eventual)
  
  ⚠️ Para subir a un repositorio debemos entrar en la carpeta que se nos crea a la hora de clonar. Ya sea de forma manual o ``` cd ProyectoWeb ``` 
  
  ![image][mover]

```
git add .
git commit -m "Yatusabe"
git branch -M main
git remote add origin (url)
git push -u origin main
```

Para subir archivos después de la primera vez

```
git add . o git add (elemento1) (elemento2) (elemento3) ... (elementoN)
git commit -m "Yatusabe"
git push -u origin main
```


### Errores

1. Git remote origin already exists

![image][already-exists]

Solución:
  ```
  git remote rm origin
git remote add origin (nueva url)
  ```
<p align="right">(<a href="#readme-top">Subir al inicio</a>)</p>

## Actualizaciones

- Proyecto finalizado
- Redireccionamiento corregido, localhost::8080 eliminado

<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/image.png
[mover]: images/mover.png
[already-exists]: https://linuxhint.com/wp-content/uploads/2023/03/word-image-311050-1.png