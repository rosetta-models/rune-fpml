package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.validation.AdjustableOrRelativeDateTypeFormatValidator;
import fpml.confirmation.validation.AdjustableOrRelativeDateValidator;
import fpml.confirmation.validation.exists.AdjustableOrRelativeDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdjustableOrRelativeDate.class)
public class AdjustableOrRelativeDateMeta implements RosettaMetaData<AdjustableOrRelativeDate> {

	@Override
	public List<Validator<? super AdjustableOrRelativeDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdjustableOrRelativeDate>create(fpml.confirmation.validation.datarule.AdjustableOrRelativeDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrRelativeDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableOrRelativeDate> validator() {
		return new AdjustableOrRelativeDateValidator();
	}

	@Override
	public Validator<? super AdjustableOrRelativeDate> typeFormatValidator() {
		return new AdjustableOrRelativeDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrRelativeDate, Set<String>> onlyExistsValidator() {
		return new AdjustableOrRelativeDateOnlyExistsValidator();
	}
}
