package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObligationAcceleration;
import fpml.confirmation.validation.ObligationAccelerationTypeFormatValidator;
import fpml.confirmation.validation.ObligationAccelerationValidator;
import fpml.confirmation.validation.exists.ObligationAccelerationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ObligationAcceleration.class)
public class ObligationAccelerationMeta implements RosettaMetaData<ObligationAcceleration> {

	@Override
	public List<Validator<? super ObligationAcceleration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationAcceleration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ObligationAcceleration> validator() {
		return new ObligationAccelerationValidator();
	}

	@Override
	public Validator<? super ObligationAcceleration> typeFormatValidator() {
		return new ObligationAccelerationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationAcceleration, Set<String>> onlyExistsValidator() {
		return new ObligationAccelerationOnlyExistsValidator();
	}
}
