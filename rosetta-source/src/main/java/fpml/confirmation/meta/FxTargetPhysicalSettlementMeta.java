package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetPhysicalSettlement;
import fpml.confirmation.validation.FxTargetPhysicalSettlementTypeFormatValidator;
import fpml.confirmation.validation.FxTargetPhysicalSettlementValidator;
import fpml.confirmation.validation.exists.FxTargetPhysicalSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetPhysicalSettlement.class)
public class FxTargetPhysicalSettlementMeta implements RosettaMetaData<FxTargetPhysicalSettlement> {

	@Override
	public List<Validator<? super FxTargetPhysicalSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetPhysicalSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetPhysicalSettlement> validator() {
		return new FxTargetPhysicalSettlementValidator();
	}

	@Override
	public Validator<? super FxTargetPhysicalSettlement> typeFormatValidator() {
		return new FxTargetPhysicalSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetPhysicalSettlement, Set<String>> onlyExistsValidator() {
		return new FxTargetPhysicalSettlementOnlyExistsValidator();
	}
}
