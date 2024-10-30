package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetBarrier;
import fpml.confirmation.validation.FxTargetBarrierTypeFormatValidator;
import fpml.confirmation.validation.FxTargetBarrierValidator;
import fpml.confirmation.validation.exists.FxTargetBarrierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetBarrier.class)
public class FxTargetBarrierMeta implements RosettaMetaData<FxTargetBarrier> {

	@Override
	public List<Validator<? super FxTargetBarrier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetBarrier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetBarrier> validator() {
		return new FxTargetBarrierValidator();
	}

	@Override
	public Validator<? super FxTargetBarrier> typeFormatValidator() {
		return new FxTargetBarrierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetBarrier, Set<String>> onlyExistsValidator() {
		return new FxTargetBarrierOnlyExistsValidator();
	}
}
