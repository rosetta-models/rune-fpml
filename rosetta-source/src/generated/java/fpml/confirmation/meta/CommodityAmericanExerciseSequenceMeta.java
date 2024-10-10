package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.validation.CommodityAmericanExerciseSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityAmericanExerciseSequenceValidator;
import fpml.confirmation.validation.exists.CommodityAmericanExerciseSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityAmericanExerciseSequence.class)
public class CommodityAmericanExerciseSequenceMeta implements RosettaMetaData<CommodityAmericanExerciseSequence> {

	@Override
	public List<Validator<? super CommodityAmericanExerciseSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityAmericanExerciseSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityAmericanExerciseSequence> validator() {
		return new CommodityAmericanExerciseSequenceValidator();
	}

	@Override
	public Validator<? super CommodityAmericanExerciseSequence> typeFormatValidator() {
		return new CommodityAmericanExerciseSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityAmericanExerciseSequence, Set<String>> onlyExistsValidator() {
		return new CommodityAmericanExerciseSequenceOnlyExistsValidator();
	}
}
