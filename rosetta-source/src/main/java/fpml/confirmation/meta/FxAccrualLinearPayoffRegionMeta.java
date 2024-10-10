package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import fpml.confirmation.validation.FxAccrualLinearPayoffRegionTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualLinearPayoffRegionValidator;
import fpml.confirmation.validation.exists.FxAccrualLinearPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualLinearPayoffRegion.class)
public class FxAccrualLinearPayoffRegionMeta implements RosettaMetaData<FxAccrualLinearPayoffRegion> {

	@Override
	public List<Validator<? super FxAccrualLinearPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualLinearPayoffRegion>create(fpml.confirmation.validation.datarule.FxAccrualLinearPayoffRegionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualLinearPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualLinearPayoffRegion> validator() {
		return new FxAccrualLinearPayoffRegionValidator();
	}

	@Override
	public Validator<? super FxAccrualLinearPayoffRegion> typeFormatValidator() {
		return new FxAccrualLinearPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualLinearPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxAccrualLinearPayoffRegionOnlyExistsValidator();
	}
}
