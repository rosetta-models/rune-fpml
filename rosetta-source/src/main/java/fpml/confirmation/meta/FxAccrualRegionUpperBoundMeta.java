package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegionUpperBound;
import fpml.confirmation.validation.FxAccrualRegionUpperBoundTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualRegionUpperBoundValidator;
import fpml.confirmation.validation.exists.FxAccrualRegionUpperBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualRegionUpperBound.class)
public class FxAccrualRegionUpperBoundMeta implements RosettaMetaData<FxAccrualRegionUpperBound> {

	@Override
	public List<Validator<? super FxAccrualRegionUpperBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionUpperBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualRegionUpperBound> validator() {
		return new FxAccrualRegionUpperBoundValidator();
	}

	@Override
	public Validator<? super FxAccrualRegionUpperBound> typeFormatValidator() {
		return new FxAccrualRegionUpperBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionUpperBound, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionUpperBoundOnlyExistsValidator();
	}
}
