package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestLegResetDates;
import fpml.confirmation.validation.InterestLegResetDatesTypeFormatValidator;
import fpml.confirmation.validation.InterestLegResetDatesValidator;
import fpml.confirmation.validation.exists.InterestLegResetDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestLegResetDates.class)
public class InterestLegResetDatesMeta implements RosettaMetaData<InterestLegResetDates> {

	@Override
	public List<Validator<? super InterestLegResetDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.InterestLegResetDates>create(fpml.confirmation.validation.datarule.InterestLegResetDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestLegResetDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestLegResetDates> validator() {
		return new InterestLegResetDatesValidator();
	}

	@Override
	public Validator<? super InterestLegResetDates> typeFormatValidator() {
		return new InterestLegResetDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestLegResetDates, Set<String>> onlyExistsValidator() {
		return new InterestLegResetDatesOnlyExistsValidator();
	}
}
