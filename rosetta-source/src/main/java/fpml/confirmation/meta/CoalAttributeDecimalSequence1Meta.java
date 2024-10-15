package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalAttributeDecimalSequence1;
import fpml.confirmation.validation.CoalAttributeDecimalSequence1TypeFormatValidator;
import fpml.confirmation.validation.CoalAttributeDecimalSequence1Validator;
import fpml.confirmation.validation.exists.CoalAttributeDecimalSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CoalAttributeDecimalSequence1.class)
public class CoalAttributeDecimalSequence1Meta implements RosettaMetaData<CoalAttributeDecimalSequence1> {

	@Override
	public List<Validator<? super CoalAttributeDecimalSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalAttributeDecimalSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalAttributeDecimalSequence1> validator() {
		return new CoalAttributeDecimalSequence1Validator();
	}

	@Override
	public Validator<? super CoalAttributeDecimalSequence1> typeFormatValidator() {
		return new CoalAttributeDecimalSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalAttributeDecimalSequence1, Set<String>> onlyExistsValidator() {
		return new CoalAttributeDecimalSequence1OnlyExistsValidator();
	}
}
