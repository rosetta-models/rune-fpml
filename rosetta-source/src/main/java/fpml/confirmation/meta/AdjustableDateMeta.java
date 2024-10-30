package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.validation.AdjustableDateTypeFormatValidator;
import fpml.confirmation.validation.AdjustableDateValidator;
import fpml.confirmation.validation.exists.AdjustableDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableDate.class)
public class AdjustableDateMeta implements RosettaMetaData<AdjustableDate> {

	@Override
	public List<Validator<? super AdjustableDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustableDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableDate> validator() {
		return new AdjustableDateValidator();
	}

	@Override
	public Validator<? super AdjustableDate> typeFormatValidator() {
		return new AdjustableDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDate, Set<String>> onlyExistsValidator() {
		return new AdjustableDateOnlyExistsValidator();
	}
}
