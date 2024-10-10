package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegionSequence0;
import fpml.confirmation.validation.FxAccrualRegionSequence0TypeFormatValidator;
import fpml.confirmation.validation.FxAccrualRegionSequence0Validator;
import fpml.confirmation.validation.exists.FxAccrualRegionSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualRegionSequence0.class)
public class FxAccrualRegionSequence0Meta implements RosettaMetaData<FxAccrualRegionSequence0> {

	@Override
	public List<Validator<? super FxAccrualRegionSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualRegionSequence0> validator() {
		return new FxAccrualRegionSequence0Validator();
	}

	@Override
	public Validator<? super FxAccrualRegionSequence0> typeFormatValidator() {
		return new FxAccrualRegionSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionSequence0, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionSequence0OnlyExistsValidator();
	}
}
