package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RelativeDates;
import fpml.confirmation.validation.RelativeDatesTypeFormatValidator;
import fpml.confirmation.validation.RelativeDatesValidator;
import fpml.confirmation.validation.exists.RelativeDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RelativeDates.class)
public class RelativeDatesMeta implements RosettaMetaData<RelativeDates> {

	@Override
	public List<Validator<? super RelativeDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelativeDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RelativeDates> validator() {
		return new RelativeDatesValidator();
	}

	@Override
	public Validator<? super RelativeDates> typeFormatValidator() {
		return new RelativeDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDates, Set<String>> onlyExistsValidator() {
		return new RelativeDatesOnlyExistsValidator();
	}
}
