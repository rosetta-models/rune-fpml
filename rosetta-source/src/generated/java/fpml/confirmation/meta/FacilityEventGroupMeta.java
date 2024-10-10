package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityEventGroup;
import fpml.confirmation.validation.FacilityEventGroupTypeFormatValidator;
import fpml.confirmation.validation.FacilityEventGroupValidator;
import fpml.confirmation.validation.exists.FacilityEventGroupOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityEventGroup.class)
public class FacilityEventGroupMeta implements RosettaMetaData<FacilityEventGroup> {

	@Override
	public List<Validator<? super FacilityEventGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityEventGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityEventGroup> validator() {
		return new FacilityEventGroupValidator();
	}

	@Override
	public Validator<? super FacilityEventGroup> typeFormatValidator() {
		return new FacilityEventGroupTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityEventGroup, Set<String>> onlyExistsValidator() {
		return new FacilityEventGroupOnlyExistsValidator();
	}
}
