package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashSettlementPaymentDate;
import fpml.confirmation.validation.CashSettlementPaymentDateTypeFormatValidator;
import fpml.confirmation.validation.CashSettlementPaymentDateValidator;
import fpml.confirmation.validation.exists.CashSettlementPaymentDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CashSettlementPaymentDate.class)
public class CashSettlementPaymentDateMeta implements RosettaMetaData<CashSettlementPaymentDate> {

	@Override
	public List<Validator<? super CashSettlementPaymentDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CashSettlementPaymentDate>create(fpml.confirmation.validation.datarule.CashSettlementPaymentDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CashSettlementPaymentDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashSettlementPaymentDate> validator() {
		return new CashSettlementPaymentDateValidator();
	}

	@Override
	public Validator<? super CashSettlementPaymentDate> typeFormatValidator() {
		return new CashSettlementPaymentDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlementPaymentDate, Set<String>> onlyExistsValidator() {
		return new CashSettlementPaymentDateOnlyExistsValidator();
	}
}
