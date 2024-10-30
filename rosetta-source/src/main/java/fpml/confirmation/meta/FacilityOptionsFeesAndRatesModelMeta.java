package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityOptionsFeesAndRatesModel;
import fpml.confirmation.validation.FacilityOptionsFeesAndRatesModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityOptionsFeesAndRatesModelValidator;
import fpml.confirmation.validation.exists.FacilityOptionsFeesAndRatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityOptionsFeesAndRatesModel.class)
public class FacilityOptionsFeesAndRatesModelMeta implements RosettaMetaData<FacilityOptionsFeesAndRatesModel> {

	@Override
	public List<Validator<? super FacilityOptionsFeesAndRatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityOptionsFeesAndRatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityOptionsFeesAndRatesModel> validator() {
		return new FacilityOptionsFeesAndRatesModelValidator();
	}

	@Override
	public Validator<? super FacilityOptionsFeesAndRatesModel> typeFormatValidator() {
		return new FacilityOptionsFeesAndRatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityOptionsFeesAndRatesModel, Set<String>> onlyExistsValidator() {
		return new FacilityOptionsFeesAndRatesModelOnlyExistsValidator();
	}
}
