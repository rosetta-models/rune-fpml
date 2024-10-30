package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxComplexBarrierBaseSequence0;
import fpml.confirmation.validation.FxComplexBarrierBaseSequence0TypeFormatValidator;
import fpml.confirmation.validation.FxComplexBarrierBaseSequence0Validator;
import fpml.confirmation.validation.exists.FxComplexBarrierBaseSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxComplexBarrierBaseSequence0.class)
public class FxComplexBarrierBaseSequence0Meta implements RosettaMetaData<FxComplexBarrierBaseSequence0> {

	@Override
	public List<Validator<? super FxComplexBarrierBaseSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxComplexBarrierBaseSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxComplexBarrierBaseSequence0> validator() {
		return new FxComplexBarrierBaseSequence0Validator();
	}

	@Override
	public Validator<? super FxComplexBarrierBaseSequence0> typeFormatValidator() {
		return new FxComplexBarrierBaseSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxComplexBarrierBaseSequence0, Set<String>> onlyExistsValidator() {
		return new FxComplexBarrierBaseSequence0OnlyExistsValidator();
	}
}
