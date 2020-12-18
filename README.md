#ALERT
>- **VERY IMPORTANT** - Guide on running the application : shorturl.at/rsPR4 
>- I have two remote repositories , one which has corrupted files so i decided to create a new one
>
>>- old remote repo : https://github.com/EshenGan/COMP2042_CW_E-SHENGAN-outdated-.git
>>- new and curernt repo: https://github.com/EshenGan/COMP2042_CW2020_E-SHEN_GAN.git

# EXTENSION
*All extensions made are for the purpose of providing convenience and better player experience*
>- **START SCREEN**
>
>>- **MenuScene.java** is the class to create START screen
>>- Contains 4 buttons ,**PLAY** ,**MANUAL** ,**BGM** ,**EXIT**

>- **INFO SCREEN**
>
>>- **ManualScene.java** is the class to create INFO screen and also 2 buttons, **BACK TO MENU** and **EXIT**. 

>- **INTERESTING LEVELS ADDED**
>
>>- Original game behavior was slightly altered which is now **EasyScene.java**
>>- two new levels are added , **MediumScene.java** and **HardScene.java**
>>- **Snake.java**: a new obstacle that appears only in medium and hard mode
>>- **Frog.java**: 
>>
>>>- added animation and condition for death by snake
>>>- conditional statements for frog to move same speed and direction as safe platforms
>>- **Turtle.java** and **WetTurtle.java**:
>>
>>>- added animation for turtles to swim towards right 

>- **PERMANENT HIGH SCORE LIST IN TXT FILE**
>
>>- **ScoreHandler.java** and **AnimationHandler.java**: txt files are used to store scores permanently e.g. scoreboard.txt

>- **POP UP OF HIGH SCORES AT END OF EACH ROUND**
>
>>- **ScoreHandler.java** and **AnimationHandler.java** :When game over,a window pops up to show current score and top 5 highest score ever recorded
>>- **BubbleSort.java**: Sort scores in descending order

>- **PAUSE FEATURE**
>
>>- **GameSceneButtons.java** and **PauseLayer.java**:
>>
>>>- **PAUSE** to generate PAUSE screen with 3 buttons: **RESUME**,**BACK TO MENU** and **EXIT** 

>- **BACK TO MENU AND AUTO SAVE FEATURE**
>
>>- **BACK TO MENU** in PAUSE screen goes back to START screen while automatically saving the progress in the game

>- **CHOOSE BACKGROUND MUSIC**
>
>>- **MenuScene.java** and **Bgm.java**:
>>
>>>- **BGM** in START screen drops 3 buttons for background music choice

>- **UNIT TESTING**
>
>>- Unit testing with Junit5 and TestFX framework, test files all in src/test/java  

>- **Class for Buttons**
>
>>- **Button.java** is used for creating buttons in any pane

>- **Set up icon and title for application GUI**
 


# REFACTORING

>- Extract class/ Replace method with method object
>
>>-  Extracted **AnimationHandler.java** to replace createTimer() method in **FroggerApp** because method is too long
>>-  Extracted **EasyScene.java** from **FroggerApp.java** because **FroggerApp.java** act as **Main.java** where all scenes and sprites are aggregated
>>-  Obey single responsibility principle

>- Data Encapsulation
>
>>- All fields and objects in all classes are private
>>- Setter and getter methods are the only accessors to obey Object Orientation core concept 

>- Extract Interface
>
>>- FroggerApp class has an interface,**Launchable.java**
>>- Program to an interface not implementation

>- Factory Method Design Pattern
>
>>- **SceneFactory.java** and **SpriteFactory.java** are factory classes with static methods that create scenes and sprites respectively
>>-  Factory Method is used to create different objects without necessarily knowing what kind of object it creates or how to create it and also to centralize creation of similar objects


>- Organize codes according to MVC Pattern
>
>>- Reorganize all codes in each class into blocks of Model , View and Controller
>>- Increase readability and comprehensiveness of codes

>- Extract methods
>
>>- Extract **prepareMP()** from **playMusic()** 
>>- Extract methods **buildFrogHome()**, **buildLogs()**, **buildTurtles()** and **buildVehicles()** from constructors in EasyScene, MediumScene and HardScene
>>- Obey Single Responsibility principle 

>- Replace aggregation/composition with inheritance
>
>>- Created **ScoreHandler.java** to aggregate in **AnimationHandler.java**
>>- **Bgm.java** aggregate in **GamePane.java**
>>- Promote loose coupling and obey Composite Reuse principle

>- Consolidate duplicate conditional fragments
>
>>- Move identical codes out of each branches of a conditional to remove duplicated codes:
>>- **Frog.java**: **setSecond()** in **handle(KeyEvent)** 
>>- **WetTurtle.java**: **setSunk()** in **act(long now)**

>- Pull up method
>
>>- Pull up method **act(long now)** to **Sprites.java** to avoid code duplication

*visit javadoc for detailed information*
