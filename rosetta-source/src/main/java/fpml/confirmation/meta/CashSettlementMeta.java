package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.validation.CashSettlementTypeFormatValidator;
import fpml.confirmation.validation.CashSettlementValidator;
import fpml.confirmation.validation.exists.CashSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CashSettlement.class)
public class CashSettlementMeta implements RosettaMetaData<CashSettlement> {

	@Override
	public List<Validator<? super CashSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CashSettlement>create(fpml.confirmation.validation.datarule.CashSettlementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CashSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CashSettlement> validator() {
		return new CashSettlementValidator();
	}

	@Override
	public Validator<? super CashSettlement> typeFormatValidator() {
		return new CashSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashSettlement, Set<String>> onlyExistsValidator() {
		return new CashSettlementOnlyExistsValidator();
	}
}
