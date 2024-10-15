package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityDigitalExercise;
import fpml.confirmation.validation.CommodityDigitalExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityDigitalExerciseValidator;
import fpml.confirmation.validation.exists.CommodityDigitalExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityDigitalExercise.class)
public class CommodityDigitalExerciseMeta implements RosettaMetaData<CommodityDigitalExercise> {

	@Override
	public List<Validator<? super CommodityDigitalExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityDigitalExercise>create(fpml.confirmation.validation.datarule.CommodityDigitalExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDigitalExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityDigitalExercise> validator() {
		return new CommodityDigitalExerciseValidator();
	}

	@Override
	public Validator<? super CommodityDigitalExercise> typeFormatValidator() {
		return new CommodityDigitalExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigitalExercise, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalExerciseOnlyExistsValidator();
	}
}
