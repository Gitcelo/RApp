# RApp
Recipe App
The Recipe Application is a recipe management system that will provide access to and allow users to manage recipes. The system stores recipes and makes them easily located by users. The inital release has a database with selected recipes, a search function, filters, random recipe picker and the ability for users to add and publish their own recipes. Additionally the site has a trending tab that shows users the most popular recipes. 

## Breytingar á aðferðum og viðföngum þeirra

- Í sumum get aðferðum höfum við tekið út viðföng sem þær nota ekki. Dæmi um þetta er aðferðin recipeCreateViewGet
sem tekur ekki lengur inn User og Recipe hluti.

- Erum ekki lengur með findRandom aðferð sem skilar Recipe í repository-inu heldur finnum við random ID fyrir uppskrift
og köllum á /Recipe/{id} fyrir það ID til að sýna þá uppskrift.

- Hendi út RecipeUploadController þar sem við finnum ekki not fyrir það eins og er. Á móti setjum við nýja aðferði inní
RecipePageController sem sýnir allar uppskriftir sem eru published.

- Breytti recipeUploadController í recipeUploadedController. Í staðinn fyrir að hlaða upp published uppskriftum
þá sýnir hann bara published uppskriftir. recipeChangeController sér um að breyta uppskriftum yfir í published.
