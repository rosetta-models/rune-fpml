package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegion;
import fpml.confirmation.validation.FxAccrualRegionTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualRegionValidator;
import fpml.confirmation.validation.exists.FxAccrualRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualRegion.class)
public class FxAccrualRegionMeta implements RosettaMetaData<FxAccrualRegion> {

	@Override
	public List<Validator<? super FxAccrualRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualRegion>create(fpml.confirmation.validation.datarule.FxAccrualRegionChoice0.class),
			factory.<fpml.confirmation.FxAccrualRegion>create(fpml.confirmation.validation.datarule.FxAccrualRegionChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualRegion> validator() {
		return new FxAccrualRegionValidator();
	}

	@Override
	public Validator<? super FxAccrualRegion> typeFormatValidator() {
		return new FxAccrualRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegion, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionOnlyExistsValidator();
	}
}
