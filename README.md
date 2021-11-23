# RApp
Uppskriftarvefur

RApp er uppskriftarvefur sem heldur utan um uppskriftir notenda sinna og gefur þeim greiðan aðgang á að halda utan um sínar eigin uppskriftir ásamt því að gefa þeim aðgang að birtum uppskriftum annarra notenda. Fyrsta útgáfan mun innihalda uppskriftir, leitarvél, síur, val á uppskrift af handahófi og möguleikann fyrir notendur að bæta við og birta sínar eigin uppskriftir. Að auki er síðan með yfirlit yfir vinsælustu uppskriftirnar á síðunni. Notendur geta auðveldlega búið til aðgang og skráð sig inn til þess að skoða eigin uppskriftir og birta nýjar. Einnig geta þeir séð uppskriftir annarra notenda sem hafa verið birtar og hægt er að fylgjast með öðrum notendum til að sjá allar nýjustu uppskriftir þeirra. Uppskriftum er bæði hægt að breyta og eyða ef notandinn telur það vera við hæfi. 

Recipe App

The Recipe Application is a recipe management system that will provide access to and allow users to manage recipes. The system stores recipes and makes them easily located by users. The inital release has a database with selected recipes, a search function, filters, random recipe picker and the ability for users to add and publish their own recipes. Additionally the site has a trending tab that shows users the most popular recipes. Users can sign up and login to their accounts providing them with access to their own recipes that they have uploaded as well as browsing through recipes that other users have made public. Users can follow other users to easily find their recipes. Recipes can be edited by the owner and deleted just as easily. 

## Breytingar á aðferðum og viðföngum þeirra

- Í sumum get aðferðum höfum við tekið út viðföng sem þær nota ekki. Dæmi um þetta er aðferðin recipeCreateViewGet
sem tekur ekki lengur inn User og Recipe hluti.

- Erum ekki lengur með findRandom aðferð sem skilar Recipe í repository-inu heldur finnum við random ID fyrir uppskrift
og köllum á /Recipe/{id} fyrir það ID til að sýna þá uppskrift.

- Hendi út RecipeUploadController þar sem við finnum ekki not fyrir það eins og er. Á móti setjum við nýja aðferði inní
RecipePageController sem sýnir allar uppskriftir sem eru published.

- Breytti recipeUploadController í recipeUploadedController. Í staðinn fyrir að hlaða upp published uppskriftum
þá sýnir hann bara published uppskriftir. recipeChangeController sér um að breyta uppskriftum yfir í published.

- Breytti frá userFollowingViewPost yfir í userFollowPost, þar sem ekki þarf að sjá að maður sé að followa einn
ákveðinn einstakling.
