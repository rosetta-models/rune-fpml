package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Prepayment;
import fpml.confirmation.validation.PrepaymentTypeFormatValidator;
import fpml.confirmation.validation.PrepaymentValidator;
import fpml.confirmation.validation.exists.PrepaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model= Prepayment.class)
public class PrePaymentMeta implements RosettaMetaData<Prepayment> {

	@Override
	public List<Validator<? super Prepayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Prepayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Prepayment> validator() {
		return new PrepaymentValidator();
	}

	@Override
	public Validator<? super Prepayment> typeFormatValidator() {
		return new PrepaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Prepayment, Set<String>> onlyExistsValidator() {
		return new PrepaymentOnlyExistsValidator();
	}
}
