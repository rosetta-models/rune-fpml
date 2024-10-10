package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import fpml.confirmation.validation.CommodityPhysicalAmericanExerciseSequence0TypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalAmericanExerciseSequence0Validator;
import fpml.confirmation.validation.exists.CommodityPhysicalAmericanExerciseSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPhysicalAmericanExerciseSequence0.class)
public class CommodityPhysicalAmericanExerciseSequence0Meta implements RosettaMetaData<CommodityPhysicalAmericanExerciseSequence0> {

	@Override
	public List<Validator<? super CommodityPhysicalAmericanExerciseSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalAmericanExerciseSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExerciseSequence0> validator() {
		return new CommodityPhysicalAmericanExerciseSequence0Validator();
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExerciseSequence0> typeFormatValidator() {
		return new CommodityPhysicalAmericanExerciseSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalAmericanExerciseSequence0, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalAmericanExerciseSequence0OnlyExistsValidator();
	}
}
