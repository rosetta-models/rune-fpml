package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenters;
import fpml.confirmation.validation.BusinessCentersTypeFormatValidator;
import fpml.confirmation.validation.BusinessCentersValidator;
import fpml.confirmation.validation.exists.BusinessCentersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BusinessCenters.class)
public class BusinessCentersMeta implements RosettaMetaData<BusinessCenters> {

	@Override
	public List<Validator<? super BusinessCenters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCenters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessCenters> validator() {
		return new BusinessCentersValidator();
	}

	@Override
	public Validator<? super BusinessCenters> typeFormatValidator() {
		return new BusinessCentersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCenters, Set<String>> onlyExistsValidator() {
		return new BusinessCentersOnlyExistsValidator();
	}
}
