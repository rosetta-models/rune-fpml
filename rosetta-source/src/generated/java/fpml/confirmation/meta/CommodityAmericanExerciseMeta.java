package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityAmericanExercise;
import fpml.confirmation.validation.CommodityAmericanExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityAmericanExerciseValidator;
import fpml.confirmation.validation.exists.CommodityAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityAmericanExercise.class)
public class CommodityAmericanExerciseMeta implements RosettaMetaData<CommodityAmericanExercise> {

	@Override
	public List<Validator<? super CommodityAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityAmericanExercise>create(fpml.confirmation.validation.datarule.CommodityAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityAmericanExercise> validator() {
		return new CommodityAmericanExerciseValidator();
	}

	@Override
	public Validator<? super CommodityAmericanExercise> typeFormatValidator() {
		return new CommodityAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityAmericanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityAmericanExerciseOnlyExistsValidator();
	}
}
