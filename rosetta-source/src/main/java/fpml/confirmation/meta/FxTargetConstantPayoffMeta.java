package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetConstantPayoff;
import fpml.confirmation.validation.FxTargetConstantPayoffTypeFormatValidator;
import fpml.confirmation.validation.FxTargetConstantPayoffValidator;
import fpml.confirmation.validation.exists.FxTargetConstantPayoffOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetConstantPayoff.class)
public class FxTargetConstantPayoffMeta implements RosettaMetaData<FxTargetConstantPayoff> {

	@Override
	public List<Validator<? super FxTargetConstantPayoff>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTargetConstantPayoff>create(fpml.confirmation.validation.datarule.FxTargetConstantPayoffChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetConstantPayoff, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetConstantPayoff> validator() {
		return new FxTargetConstantPayoffValidator();
	}

	@Override
	public Validator<? super FxTargetConstantPayoff> typeFormatValidator() {
		return new FxTargetConstantPayoffTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetConstantPayoff, Set<String>> onlyExistsValidator() {
		return new FxTargetConstantPayoffOnlyExistsValidator();
	}
}
