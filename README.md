# RApp
Recipe App
The Recipe Application is a recipe management system that will provide access to and allow users to manage recipes. The system stores recipes and makes them easily located by users. The inital release has a database with selected recipes, a search function, filters, random recipe picker and the ability for users to add and publish their own recipes. Additionally the site has a trending tab that shows users the most popular recipes. 

## Breytingar á aðferðum og viðföngum þeirra

Í sumum get aðferðum höfum við tekið út viðföng sem þær nota ekki. Dæmi um þetta er aðferðin
recipeCreateViewGet sem tekur ekki lengur inn User og Recipe hluti.

RecipeRepository sér ekki lengur um að finna random raðir því h2 styður ekki random query. Í staðinn
sér random aðferðin í RecipePageController um að finna random id og sækja uppskrift fyrir það.

## Postgres

* Í `application.properties` skjalinu þarf að breyta gildinu undir what to do on start frá create-drop. Sjá þennan
  hlekk `https://dzone.com/articles/configuring-spring-boot-for-postgresql`