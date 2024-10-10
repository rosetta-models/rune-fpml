package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetSettlementPeriodPayoff;
import fpml.confirmation.validation.FxTargetSettlementPeriodPayoffTypeFormatValidator;
import fpml.confirmation.validation.FxTargetSettlementPeriodPayoffValidator;
import fpml.confirmation.validation.exists.FxTargetSettlementPeriodPayoffOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetSettlementPeriodPayoff.class)
public class FxTargetSettlementPeriodPayoffMeta implements RosettaMetaData<FxTargetSettlementPeriodPayoff> {

	@Override
	public List<Validator<? super FxTargetSettlementPeriodPayoff>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetSettlementPeriodPayoff, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetSettlementPeriodPayoff> validator() {
		return new FxTargetSettlementPeriodPayoffValidator();
	}

	@Override
	public Validator<? super FxTargetSettlementPeriodPayoff> typeFormatValidator() {
		return new FxTargetSettlementPeriodPayoffTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetSettlementPeriodPayoff, Set<String>> onlyExistsValidator() {
		return new FxTargetSettlementPeriodPayoffOnlyExistsValidator();
	}
}
