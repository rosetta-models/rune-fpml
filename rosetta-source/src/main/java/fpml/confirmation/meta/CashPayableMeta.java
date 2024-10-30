package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashPayable;
import fpml.confirmation.validation.CashPayableTypeFormatValidator;
import fpml.confirmation.validation.CashPayableValidator;
import fpml.confirmation.validation.exists.CashPayableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CashPayable.class)
public class CashPayableMeta implements RosettaMetaData<CashPayable> {

	@Override
	public List<Validator<? super CashPayable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashPayable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashPayable> validator() {
		return new CashPayableValidator();
	}

	@Override
	public Validator<? super CashPayable> typeFormatValidator() {
		return new CashPayableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashPayable, Set<String>> onlyExistsValidator() {
		return new CashPayableOnlyExistsValidator();
	}
}
