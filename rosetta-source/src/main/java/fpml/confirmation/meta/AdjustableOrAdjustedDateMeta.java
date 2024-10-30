package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.validation.AdjustableOrAdjustedDateTypeFormatValidator;
import fpml.confirmation.validation.AdjustableOrAdjustedDateValidator;
import fpml.confirmation.validation.exists.AdjustableOrAdjustedDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableOrAdjustedDate.class)
public class AdjustableOrAdjustedDateMeta implements RosettaMetaData<AdjustableOrAdjustedDate> {

	@Override
	public List<Validator<? super AdjustableOrAdjustedDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdjustableOrAdjustedDate>create(fpml.confirmation.validation.datarule.AdjustableOrAdjustedDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrAdjustedDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableOrAdjustedDate> validator() {
		return new AdjustableOrAdjustedDateValidator();
	}

	@Override
	public Validator<? super AdjustableOrAdjustedDate> typeFormatValidator() {
		return new AdjustableOrAdjustedDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrAdjustedDate, Set<String>> onlyExistsValidator() {
		return new AdjustableOrAdjustedDateOnlyExistsValidator();
	}
}
