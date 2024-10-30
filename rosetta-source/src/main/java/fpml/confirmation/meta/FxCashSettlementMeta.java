package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCashSettlement;
import fpml.confirmation.validation.FxCashSettlementTypeFormatValidator;
import fpml.confirmation.validation.FxCashSettlementValidator;
import fpml.confirmation.validation.exists.FxCashSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxCashSettlement.class)
public class FxCashSettlementMeta implements RosettaMetaData<FxCashSettlement> {

	@Override
	public List<Validator<? super FxCashSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxCashSettlement>create(fpml.confirmation.validation.datarule.FxCashSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxCashSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCashSettlement> validator() {
		return new FxCashSettlementValidator();
	}

	@Override
	public Validator<? super FxCashSettlement> typeFormatValidator() {
		return new FxCashSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCashSettlement, Set<String>> onlyExistsValidator() {
		return new FxCashSettlementOnlyExistsValidator();
	}
}
