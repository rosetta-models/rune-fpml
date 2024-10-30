package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashPriceMethod;
import fpml.confirmation.validation.CashPriceMethodTypeFormatValidator;
import fpml.confirmation.validation.CashPriceMethodValidator;
import fpml.confirmation.validation.exists.CashPriceMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CashPriceMethod.class)
public class CashPriceMethodMeta implements RosettaMetaData<CashPriceMethod> {

	@Override
	public List<Validator<? super CashPriceMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashPriceMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashPriceMethod> validator() {
		return new CashPriceMethodValidator();
	}

	@Override
	public Validator<? super CashPriceMethod> typeFormatValidator() {
		return new CashPriceMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashPriceMethod, Set<String>> onlyExistsValidator() {
		return new CashPriceMethodOnlyExistsValidator();
	}
}
