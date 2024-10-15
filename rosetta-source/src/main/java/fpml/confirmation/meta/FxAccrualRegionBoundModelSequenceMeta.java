package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegionBoundModelSequence;
import fpml.confirmation.validation.FxAccrualRegionBoundModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualRegionBoundModelSequenceValidator;
import fpml.confirmation.validation.exists.FxAccrualRegionBoundModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualRegionBoundModelSequence.class)
public class FxAccrualRegionBoundModelSequenceMeta implements RosettaMetaData<FxAccrualRegionBoundModelSequence> {

	@Override
	public List<Validator<? super FxAccrualRegionBoundModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionBoundModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualRegionBoundModelSequence> validator() {
		return new FxAccrualRegionBoundModelSequenceValidator();
	}

	@Override
	public Validator<? super FxAccrualRegionBoundModelSequence> typeFormatValidator() {
		return new FxAccrualRegionBoundModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionBoundModelSequence, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionBoundModelSequenceOnlyExistsValidator();
	}
}
