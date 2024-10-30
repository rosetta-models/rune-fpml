package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityGroup;
import fpml.confirmation.validation.FacilityGroupTypeFormatValidator;
import fpml.confirmation.validation.FacilityGroupValidator;
import fpml.confirmation.validation.exists.FacilityGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityGroup.class)
public class FacilityGroupMeta implements RosettaMetaData<FacilityGroup> {

	@Override
	public List<Validator<? super FacilityGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityGroup> validator() {
		return new FacilityGroupValidator();
	}

	@Override
	public Validator<? super FacilityGroup> typeFormatValidator() {
		return new FacilityGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityGroup, Set<String>> onlyExistsValidator() {
		return new FacilityGroupOnlyExistsValidator();
	}
}
