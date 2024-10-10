package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityExercise;
import fpml.confirmation.validation.CommodityExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityExerciseValidator;
import fpml.confirmation.validation.exists.CommodityExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityExercise.class)
public class CommodityExerciseMeta implements RosettaMetaData<CommodityExercise> {

	@Override
	public List<Validator<? super CommodityExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityExercise>create(fpml.confirmation.validation.datarule.CommodityExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityExercise> validator() {
		return new CommodityExerciseValidator();
	}

	@Override
	public Validator<? super CommodityExercise> typeFormatValidator() {
		return new CommodityExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExercise, Set<String>> onlyExistsValidator() {
		return new CommodityExerciseOnlyExistsValidator();
	}
}
