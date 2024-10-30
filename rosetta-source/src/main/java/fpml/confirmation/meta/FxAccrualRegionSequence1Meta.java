package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegionSequence1;
import fpml.confirmation.validation.FxAccrualRegionSequence1TypeFormatValidator;
import fpml.confirmation.validation.FxAccrualRegionSequence1Validator;
import fpml.confirmation.validation.exists.FxAccrualRegionSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualRegionSequence1.class)
public class FxAccrualRegionSequence1Meta implements RosettaMetaData<FxAccrualRegionSequence1> {

	@Override
	public List<Validator<? super FxAccrualRegionSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualRegionSequence1> validator() {
		return new FxAccrualRegionSequence1Validator();
	}

	@Override
	public Validator<? super FxAccrualRegionSequence1> typeFormatValidator() {
		return new FxAccrualRegionSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionSequence1, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionSequence1OnlyExistsValidator();
	}
}
