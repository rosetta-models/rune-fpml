package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualPayoffRegion;
import fpml.confirmation.validation.FxAccrualPayoffRegionTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualPayoffRegionValidator;
import fpml.confirmation.validation.exists.FxAccrualPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualPayoffRegion.class)
public class FxAccrualPayoffRegionMeta implements RosettaMetaData<FxAccrualPayoffRegion> {

	@Override
	public List<Validator<? super FxAccrualPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualPayoffRegion> validator() {
		return new FxAccrualPayoffRegionValidator();
	}

	@Override
	public Validator<? super FxAccrualPayoffRegion> typeFormatValidator() {
		return new FxAccrualPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxAccrualPayoffRegionOnlyExistsValidator();
	}
}
