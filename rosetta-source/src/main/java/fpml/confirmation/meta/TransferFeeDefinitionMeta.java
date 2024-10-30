package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TransferFeeDefinition;
import fpml.confirmation.validation.TransferFeeDefinitionTypeFormatValidator;
import fpml.confirmation.validation.TransferFeeDefinitionValidator;
import fpml.confirmation.validation.exists.TransferFeeDefinitionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TransferFeeDefinition.class)
public class TransferFeeDefinitionMeta implements RosettaMetaData<TransferFeeDefinition> {

	@Override
	public List<Validator<? super TransferFeeDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransferFeeDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransferFeeDefinition> validator() {
		return new TransferFeeDefinitionValidator();
	}

	@Override
	public Validator<? super TransferFeeDefinition> typeFormatValidator() {
		return new TransferFeeDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferFeeDefinition, Set<String>> onlyExistsValidator() {
		return new TransferFeeDefinitionOnlyExistsValidator();
	}
}
