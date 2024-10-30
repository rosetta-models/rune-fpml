package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributePercentageSequence0;
import fpml.confirmation.validation.CoalAttributePercentageSequence0TypeFormatValidator;
import fpml.confirmation.validation.CoalAttributePercentageSequence0Validator;
import fpml.confirmation.validation.exists.CoalAttributePercentageSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalAttributePercentageSequence0.class)
public class CoalAttributePercentageSequence0Meta implements RosettaMetaData<CoalAttributePercentageSequence0> {

	@Override
	public List<Validator<? super CoalAttributePercentageSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalAttributePercentageSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalAttributePercentageSequence0> validator() {
		return new CoalAttributePercentageSequence0Validator();
	}

	@Override
	public Validator<? super CoalAttributePercentageSequence0> typeFormatValidator() {
		return new CoalAttributePercentageSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributePercentageSequence0, Set<String>> onlyExistsValidator() {
		return new CoalAttributePercentageSequence0OnlyExistsValidator();
	}
}
