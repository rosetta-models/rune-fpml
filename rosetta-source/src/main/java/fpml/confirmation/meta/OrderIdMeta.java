package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OrderId;
import fpml.confirmation.validation.OrderIdTypeFormatValidator;
import fpml.confirmation.validation.OrderIdValidator;
import fpml.confirmation.validation.exists.OrderIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OrderId.class)
public class OrderIdMeta implements RosettaMetaData<OrderId> {

	@Override
	public List<Validator<? super OrderId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OrderId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OrderId> validator() {
		return new OrderIdValidator();
	}

	@Override
	public Validator<? super OrderId> typeFormatValidator() {
		return new OrderIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OrderId, Set<String>> onlyExistsValidator() {
		return new OrderIdOnlyExistsValidator();
	}
}
