package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DaysModelSequence0;
import fpml.confirmation.validation.DaysModelSequence0TypeFormatValidator;
import fpml.confirmation.validation.DaysModelSequence0Validator;
import fpml.confirmation.validation.exists.DaysModelSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DaysModelSequence0.class)
public class DaysModelSequence0Meta implements RosettaMetaData<DaysModelSequence0> {

	@Override
	public List<Validator<? super DaysModelSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DaysModelSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DaysModelSequence0> validator() {
		return new DaysModelSequence0Validator();
	}

	@Override
	public Validator<? super DaysModelSequence0> typeFormatValidator() {
		return new DaysModelSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DaysModelSequence0, Set<String>> onlyExistsValidator() {
		return new DaysModelSequence0OnlyExistsValidator();
	}
}
