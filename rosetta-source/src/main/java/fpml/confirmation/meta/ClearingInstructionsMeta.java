package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingInstructions;
import fpml.confirmation.validation.ClearingInstructionsTypeFormatValidator;
import fpml.confirmation.validation.ClearingInstructionsValidator;
import fpml.confirmation.validation.exists.ClearingInstructionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingInstructions.class)
public class ClearingInstructionsMeta implements RosettaMetaData<ClearingInstructions> {

	@Override
	public List<Validator<? super ClearingInstructions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingInstructions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingInstructions> validator() {
		return new ClearingInstructionsValidator();
	}

	@Override
	public Validator<? super ClearingInstructions> typeFormatValidator() {
		return new ClearingInstructionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingInstructions, Set<String>> onlyExistsValidator() {
		return new ClearingInstructionsOnlyExistsValidator();
	}
}
