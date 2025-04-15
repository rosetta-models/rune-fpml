package fpml.confirmation.custom.functions;

import fpml.confirmation.*;
import fpml.confirmation.custom.ExerciseChoice;

public class ToExerciseChoiceImpl extends ToExerciseChoice {

    @Override
    protected ExerciseChoice.ExerciseChoiceBuilder doEvaluate(Exercise exercise) {
        ExerciseChoice.ExerciseChoiceBuilder builder = ExerciseChoice.builder();

        if (exercise instanceof EuropeanExercise) {
            builder.setEuropeanExercise((EuropeanExercise) exercise);
        } else if (exercise instanceof CommodityPhysicalAmericanExercise) {
            builder.setCommodityPhysicalAmericanExercise((CommodityPhysicalAmericanExercise) exercise);
        } else if (exercise instanceof CommodityAmericanExercise) {
            builder.setCommodityAmericanExercise((CommodityAmericanExercise) exercise);
        } else if (exercise instanceof FxAmericanExercise) {
            builder.setFxAmericanExercise((FxAmericanExercise) exercise);
        } else if (exercise instanceof AmericanExercise) {
            builder.setAmericanExercise((AmericanExercise) exercise);
        } else if (exercise instanceof BermudaExercise) {
            builder.setBermudaExercise((BermudaExercise) exercise);
        } else if (exercise instanceof EquityEuropeanExercise) {
            builder.setEquityEuropeanExercise((EquityEuropeanExercise) exercise);
        } else if (exercise instanceof CommodityPhysicalEuropeanExercise) {
            builder.setCommodityPhysicalEuropeanExercise((CommodityPhysicalEuropeanExercise) exercise);
        } else if (exercise instanceof FxEuropeanExercise) {
            builder.setFxEuropeanExercise((FxEuropeanExercise) exercise);
        } else if (exercise instanceof CommodityEuropeanExercise) {
            builder.setCommodityEuropeanExercise((CommodityEuropeanExercise) exercise);
        } else if (exercise instanceof EquityBermudaExercise) {
            builder.setEquityBermudaExercise((EquityBermudaExercise) exercise);
        } else if (exercise instanceof EquityAmericanExercise) {
            builder.setEquityAmericanExercise((EquityAmericanExercise) exercise);
        }

        return builder;
    }
}