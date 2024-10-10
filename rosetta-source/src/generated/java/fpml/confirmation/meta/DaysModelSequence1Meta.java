package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DaysModelSequence1;
import fpml.confirmation.validation.DaysModelSequence1TypeFormatValidator;
import fpml.confirmation.validation.DaysModelSequence1Validator;
import fpml.confirmation.validation.exists.DaysModelSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DaysModelSequence1.class)
public class DaysModelSequence1Meta implements RosettaMetaData<DaysModelSequence1> {

	@Override
	public List<Validator<? super DaysModelSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DaysModelSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DaysModelSequence1> validator() {
		return new DaysModelSequence1Validator();
	}

	@Override
	public Validator<? super DaysModelSequence1> typeFormatValidator() {
		return new DaysModelSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DaysModelSequence1, Set<String>> onlyExistsValidator() {
		return new DaysModelSequence1OnlyExistsValidator();
	}
}
