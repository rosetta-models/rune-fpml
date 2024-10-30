package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.validation.BusinessCenterTimeTypeFormatValidator;
import fpml.confirmation.validation.BusinessCenterTimeValidator;
import fpml.confirmation.validation.exists.BusinessCenterTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BusinessCenterTime.class)
public class BusinessCenterTimeMeta implements RosettaMetaData<BusinessCenterTime> {

	@Override
	public List<Validator<? super BusinessCenterTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCenterTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessCenterTime> validator() {
		return new BusinessCenterTimeValidator();
	}

	@Override
	public Validator<? super BusinessCenterTime> typeFormatValidator() {
		return new BusinessCenterTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCenterTime, Set<String>> onlyExistsValidator() {
		return new BusinessCenterTimeOnlyExistsValidator();
	}
}
