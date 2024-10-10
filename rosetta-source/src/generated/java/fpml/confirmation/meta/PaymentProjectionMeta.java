package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentProjection;
import fpml.confirmation.validation.PaymentProjectionTypeFormatValidator;
import fpml.confirmation.validation.PaymentProjectionValidator;
import fpml.confirmation.validation.exists.PaymentProjectionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaymentProjection.class)
public class PaymentProjectionMeta implements RosettaMetaData<PaymentProjection> {

	@Override
	public List<Validator<? super PaymentProjection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentProjection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentProjection> validator() {
		return new PaymentProjectionValidator();
	}

	@Override
	public Validator<? super PaymentProjection> typeFormatValidator() {
		return new PaymentProjectionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentProjection, Set<String>> onlyExistsValidator() {
		return new PaymentProjectionOnlyExistsValidator();
	}
}
