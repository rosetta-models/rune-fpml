package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxComplexBarrierBaseSequence1;
import fpml.confirmation.validation.FxComplexBarrierBaseSequence1TypeFormatValidator;
import fpml.confirmation.validation.FxComplexBarrierBaseSequence1Validator;
import fpml.confirmation.validation.exists.FxComplexBarrierBaseSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxComplexBarrierBaseSequence1.class)
public class FxComplexBarrierBaseSequence1Meta implements RosettaMetaData<FxComplexBarrierBaseSequence1> {

	@Override
	public List<Validator<? super FxComplexBarrierBaseSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxComplexBarrierBaseSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxComplexBarrierBaseSequence1> validator() {
		return new FxComplexBarrierBaseSequence1Validator();
	}

	@Override
	public Validator<? super FxComplexBarrierBaseSequence1> typeFormatValidator() {
		return new FxComplexBarrierBaseSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxComplexBarrierBaseSequence1, Set<String>> onlyExistsValidator() {
		return new FxComplexBarrierBaseSequence1OnlyExistsValidator();
	}
}
