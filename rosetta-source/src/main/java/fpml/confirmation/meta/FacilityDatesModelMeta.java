package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityDatesModel;
import fpml.confirmation.validation.FacilityDatesModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityDatesModelValidator;
import fpml.confirmation.validation.exists.FacilityDatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityDatesModel.class)
public class FacilityDatesModelMeta implements RosettaMetaData<FacilityDatesModel> {

	@Override
	public List<Validator<? super FacilityDatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityDatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityDatesModel> validator() {
		return new FacilityDatesModelValidator();
	}

	@Override
	public Validator<? super FacilityDatesModel> typeFormatValidator() {
		return new FacilityDatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityDatesModel, Set<String>> onlyExistsValidator() {
		return new FacilityDatesModelOnlyExistsValidator();
	}
}
