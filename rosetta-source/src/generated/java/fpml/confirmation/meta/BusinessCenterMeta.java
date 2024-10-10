package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.validation.BusinessCenterTypeFormatValidator;
import fpml.confirmation.validation.BusinessCenterValidator;
import fpml.confirmation.validation.exists.BusinessCenterOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BusinessCenter.class)
public class BusinessCenterMeta implements RosettaMetaData<BusinessCenter> {

	@Override
	public List<Validator<? super BusinessCenter>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessCenter, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessCenter> validator() {
		return new BusinessCenterValidator();
	}

	@Override
	public Validator<? super BusinessCenter> typeFormatValidator() {
		return new BusinessCenterTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCenter, Set<String>> onlyExistsValidator() {
		return new BusinessCenterOnlyExistsValidator();
	}
}
