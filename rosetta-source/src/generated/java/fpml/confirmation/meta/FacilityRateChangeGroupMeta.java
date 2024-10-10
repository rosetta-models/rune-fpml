package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityRateChangeGroup;
import fpml.confirmation.validation.FacilityRateChangeGroupTypeFormatValidator;
import fpml.confirmation.validation.FacilityRateChangeGroupValidator;
import fpml.confirmation.validation.exists.FacilityRateChangeGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityRateChangeGroup.class)
public class FacilityRateChangeGroupMeta implements RosettaMetaData<FacilityRateChangeGroup> {

	@Override
	public List<Validator<? super FacilityRateChangeGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityRateChangeGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityRateChangeGroup> validator() {
		return new FacilityRateChangeGroupValidator();
	}

	@Override
	public Validator<? super FacilityRateChangeGroup> typeFormatValidator() {
		return new FacilityRateChangeGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityRateChangeGroup, Set<String>> onlyExistsValidator() {
		return new FacilityRateChangeGroupOnlyExistsValidator();
	}
}
