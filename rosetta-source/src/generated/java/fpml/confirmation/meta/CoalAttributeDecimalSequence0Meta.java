package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributeDecimalSequence0;
import fpml.confirmation.validation.CoalAttributeDecimalSequence0TypeFormatValidator;
import fpml.confirmation.validation.CoalAttributeDecimalSequence0Validator;
import fpml.confirmation.validation.exists.CoalAttributeDecimalSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CoalAttributeDecimalSequence0.class)
public class CoalAttributeDecimalSequence0Meta implements RosettaMetaData<CoalAttributeDecimalSequence0> {

	@Override
	public List<Validator<? super CoalAttributeDecimalSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalAttributeDecimalSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalAttributeDecimalSequence0> validator() {
		return new CoalAttributeDecimalSequence0Validator();
	}

	@Override
	public Validator<? super CoalAttributeDecimalSequence0> typeFormatValidator() {
		return new CoalAttributeDecimalSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributeDecimalSequence0, Set<String>> onlyExistsValidator() {
		return new CoalAttributeDecimalSequence0OnlyExistsValidator();
	}
}
