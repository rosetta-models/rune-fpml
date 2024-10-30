package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceAdvisory;
import fpml.confirmation.validation.ServiceAdvisoryTypeFormatValidator;
import fpml.confirmation.validation.ServiceAdvisoryValidator;
import fpml.confirmation.validation.exists.ServiceAdvisoryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ServiceAdvisory.class)
public class ServiceAdvisoryMeta implements RosettaMetaData<ServiceAdvisory> {

	@Override
	public List<Validator<? super ServiceAdvisory>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceAdvisory, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ServiceAdvisory> validator() {
		return new ServiceAdvisoryValidator();
	}

	@Override
	public Validator<? super ServiceAdvisory> typeFormatValidator() {
		return new ServiceAdvisoryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceAdvisory, Set<String>> onlyExistsValidator() {
		return new ServiceAdvisoryOnlyExistsValidator();
	}
}
