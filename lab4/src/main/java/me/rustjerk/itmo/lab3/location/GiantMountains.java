package me.rustjerk.itmo.lab3.location;

public class GiantMountains extends Location {
    @Override
    public LocationSize getSize() {
        return LocationSize.INFINITE;
    }

    @Override
    public String getDescription() {
        return "На некоторых пиках правильные кубы и нечто, напоминавшее крепостные залы, вырисовывались четче, чем на прочих, усиливая сходство с изображенными на картинах Рериха руинами в горах Азии. Что касается загадочных отверстий -- возможных входов в пещеры, то они распределялись довольно равномерно на свободных от снега темных вершинах.";
    }

    @Override
    public String getName() {
        return "Гигантские горы";
    }
}
