package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BrokerConfirmationType;
import fpml.confirmation.validation.BrokerConfirmationTypeTypeFormatValidator;
import fpml.confirmation.validation.BrokerConfirmationTypeValidator;
import fpml.confirmation.validation.exists.BrokerConfirmationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BrokerConfirmationType.class)
public class BrokerConfirmationTypeMeta implements RosettaMetaData<BrokerConfirmationType> {

	@Override
	public List<Validator<? super BrokerConfirmationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BrokerConfirmationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BrokerConfirmationType> validator() {
		return new BrokerConfirmationTypeValidator();
	}

	@Override
	public Validator<? super BrokerConfirmationType> typeFormatValidator() {
		return new BrokerConfirmationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BrokerConfirmationType, Set<String>> onlyExistsValidator() {
		return new BrokerConfirmationTypeOnlyExistsValidator();
	}
}
