package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxComplexBarrierBase;
import fpml.confirmation.validation.FxComplexBarrierBaseTypeFormatValidator;
import fpml.confirmation.validation.FxComplexBarrierBaseValidator;
import fpml.confirmation.validation.exists.FxComplexBarrierBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxComplexBarrierBase.class)
public class FxComplexBarrierBaseMeta implements RosettaMetaData<FxComplexBarrierBase> {

	@Override
	public List<Validator<? super FxComplexBarrierBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxComplexBarrierBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxComplexBarrierBase> validator() {
		return new FxComplexBarrierBaseValidator();
	}

	@Override
	public Validator<? super FxComplexBarrierBase> typeFormatValidator() {
		return new FxComplexBarrierBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxComplexBarrierBase, Set<String>> onlyExistsValidator() {
		return new FxComplexBarrierBaseOnlyExistsValidator();
	}
}
