package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.IntermediaryInformation;
import fpml.confirmation.validation.IntermediaryInformationTypeFormatValidator;
import fpml.confirmation.validation.IntermediaryInformationValidator;
import fpml.confirmation.validation.exists.IntermediaryInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=IntermediaryInformation.class)
public class IntermediaryInformationMeta implements RosettaMetaData<IntermediaryInformation> {

	@Override
	public List<Validator<? super IntermediaryInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IntermediaryInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super IntermediaryInformation> validator() {
		return new IntermediaryInformationValidator();
	}

	@Override
	public Validator<? super IntermediaryInformation> typeFormatValidator() {
		return new IntermediaryInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IntermediaryInformation, Set<String>> onlyExistsValidator() {
		return new IntermediaryInformationOnlyExistsValidator();
	}
}
