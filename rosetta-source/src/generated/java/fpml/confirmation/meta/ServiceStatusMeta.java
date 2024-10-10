package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceStatus;
import fpml.confirmation.validation.ServiceStatusTypeFormatValidator;
import fpml.confirmation.validation.ServiceStatusValidator;
import fpml.confirmation.validation.exists.ServiceStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ServiceStatus.class)
public class ServiceStatusMeta implements RosettaMetaData<ServiceStatus> {

	@Override
	public List<Validator<? super ServiceStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ServiceStatus> validator() {
		return new ServiceStatusValidator();
	}

	@Override
	public Validator<? super ServiceStatus> typeFormatValidator() {
		return new ServiceStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceStatus, Set<String>> onlyExistsValidator() {
		return new ServiceStatusOnlyExistsValidator();
	}
}
