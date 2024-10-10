package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestCapitalization;
import fpml.confirmation.validation.InterestCapitalizationTypeFormatValidator;
import fpml.confirmation.validation.InterestCapitalizationValidator;
import fpml.confirmation.validation.exists.InterestCapitalizationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestCapitalization.class)
public class InterestCapitalizationMeta implements RosettaMetaData<InterestCapitalization> {

	@Override
	public List<Validator<? super InterestCapitalization>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestCapitalization, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestCapitalization> validator() {
		return new InterestCapitalizationValidator();
	}

	@Override
	public Validator<? super InterestCapitalization> typeFormatValidator() {
		return new InterestCapitalizationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestCapitalization, Set<String>> onlyExistsValidator() {
		return new InterestCapitalizationOnlyExistsValidator();
	}
}
