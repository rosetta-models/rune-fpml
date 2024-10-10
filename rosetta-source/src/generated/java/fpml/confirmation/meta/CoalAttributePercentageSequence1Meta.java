package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributePercentageSequence1;
import fpml.confirmation.validation.CoalAttributePercentageSequence1TypeFormatValidator;
import fpml.confirmation.validation.CoalAttributePercentageSequence1Validator;
import fpml.confirmation.validation.exists.CoalAttributePercentageSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CoalAttributePercentageSequence1.class)
public class CoalAttributePercentageSequence1Meta implements RosettaMetaData<CoalAttributePercentageSequence1> {

	@Override
	public List<Validator<? super CoalAttributePercentageSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalAttributePercentageSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalAttributePercentageSequence1> validator() {
		return new CoalAttributePercentageSequence1Validator();
	}

	@Override
	public Validator<? super CoalAttributePercentageSequence1> typeFormatValidator() {
		return new CoalAttributePercentageSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributePercentageSequence1, Set<String>> onlyExistsValidator() {
		return new CoalAttributePercentageSequence1OnlyExistsValidator();
	}
}
