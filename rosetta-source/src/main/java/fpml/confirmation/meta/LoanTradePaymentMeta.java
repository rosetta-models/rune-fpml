package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradePayment;
import fpml.confirmation.validation.LoanTradePaymentTypeFormatValidator;
import fpml.confirmation.validation.LoanTradePaymentValidator;
import fpml.confirmation.validation.exists.LoanTradePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradePayment.class)
public class LoanTradePaymentMeta implements RosettaMetaData<LoanTradePayment> {

	@Override
	public List<Validator<? super LoanTradePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradePayment> validator() {
		return new LoanTradePaymentValidator();
	}

	@Override
	public Validator<? super LoanTradePayment> typeFormatValidator() {
		return new LoanTradePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradePayment, Set<String>> onlyExistsValidator() {
		return new LoanTradePaymentOnlyExistsValidator();
	}
}
