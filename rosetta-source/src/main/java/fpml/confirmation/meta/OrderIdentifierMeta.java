package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OrderIdentifier;
import fpml.confirmation.validation.OrderIdentifierTypeFormatValidator;
import fpml.confirmation.validation.OrderIdentifierValidator;
import fpml.confirmation.validation.exists.OrderIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OrderIdentifier.class)
public class OrderIdentifierMeta implements RosettaMetaData<OrderIdentifier> {

	@Override
	public List<Validator<? super OrderIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrderIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OrderIdentifier> validator() {
		return new OrderIdentifierValidator();
	}

	@Override
	public Validator<? super OrderIdentifier> typeFormatValidator() {
		return new OrderIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrderIdentifier, Set<String>> onlyExistsValidator() {
		return new OrderIdentifierOnlyExistsValidator();
	}
}
