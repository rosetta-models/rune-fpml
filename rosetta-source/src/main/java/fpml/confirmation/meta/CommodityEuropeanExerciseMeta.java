package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityEuropeanExercise;
import fpml.confirmation.validation.CommodityEuropeanExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityEuropeanExerciseValidator;
import fpml.confirmation.validation.exists.CommodityEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityEuropeanExercise.class)
public class CommodityEuropeanExerciseMeta implements RosettaMetaData<CommodityEuropeanExercise> {

	@Override
	public List<Validator<? super CommodityEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityEuropeanExercise> validator() {
		return new CommodityEuropeanExerciseValidator();
	}

	@Override
	public Validator<? super CommodityEuropeanExercise> typeFormatValidator() {
		return new CommodityEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityEuropeanExerciseOnlyExistsValidator();
	}
}
