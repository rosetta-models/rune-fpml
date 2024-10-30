package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityEuropeanExerciseSequence;
import fpml.confirmation.validation.CommodityEuropeanExerciseSequenceTypeFormatValidator;
import fpml.confirmation.validation.CommodityEuropeanExerciseSequenceValidator;
import fpml.confirmation.validation.exists.CommodityEuropeanExerciseSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityEuropeanExerciseSequence.class)
public class CommodityEuropeanExerciseSequenceMeta implements RosettaMetaData<CommodityEuropeanExerciseSequence> {

	@Override
	public List<Validator<? super CommodityEuropeanExerciseSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityEuropeanExerciseSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityEuropeanExerciseSequence> validator() {
		return new CommodityEuropeanExerciseSequenceValidator();
	}

	@Override
	public Validator<? super CommodityEuropeanExerciseSequence> typeFormatValidator() {
		return new CommodityEuropeanExerciseSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityEuropeanExerciseSequence, Set<String>> onlyExistsValidator() {
		return new CommodityEuropeanExerciseSequenceOnlyExistsValidator();
	}
}
