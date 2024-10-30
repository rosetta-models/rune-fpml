package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SplitSettlement;
import fpml.confirmation.validation.SplitSettlementTypeFormatValidator;
import fpml.confirmation.validation.SplitSettlementValidator;
import fpml.confirmation.validation.exists.SplitSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SplitSettlement.class)
public class SplitSettlementMeta implements RosettaMetaData<SplitSettlement> {

	@Override
	public List<Validator<? super SplitSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SplitSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SplitSettlement> validator() {
		return new SplitSettlementValidator();
	}

	@Override
	public Validator<? super SplitSettlement> typeFormatValidator() {
		return new SplitSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SplitSettlement, Set<String>> onlyExistsValidator() {
		return new SplitSettlementOnlyExistsValidator();
	}
}
