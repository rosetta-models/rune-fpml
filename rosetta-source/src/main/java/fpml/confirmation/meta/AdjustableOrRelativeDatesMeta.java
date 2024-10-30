package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.validation.AdjustableOrRelativeDatesTypeFormatValidator;
import fpml.confirmation.validation.AdjustableOrRelativeDatesValidator;
import fpml.confirmation.validation.exists.AdjustableOrRelativeDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableOrRelativeDates.class)
public class AdjustableOrRelativeDatesMeta implements RosettaMetaData<AdjustableOrRelativeDates> {

	@Override
	public List<Validator<? super AdjustableOrRelativeDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdjustableOrRelativeDates>create(fpml.confirmation.validation.datarule.AdjustableOrRelativeDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrRelativeDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableOrRelativeDates> validator() {
		return new AdjustableOrRelativeDatesValidator();
	}

	@Override
	public Validator<? super AdjustableOrRelativeDates> typeFormatValidator() {
		return new AdjustableOrRelativeDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrRelativeDates, Set<String>> onlyExistsValidator() {
		return new AdjustableOrRelativeDatesOnlyExistsValidator();
	}
}
